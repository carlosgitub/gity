package ec.org.isspol.service.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.*;

/**
 * Created by mauchilan on 24/3/17.
 */
public class IsspolAsyncServiceCaller implements InvocationHandler {

    private long currentRetryDelay = 0;
    private ExecutorService executor;
    private static Logger logger = LoggerFactory.getLogger(IsspolAsyncServiceCaller.class);
    long timeout = 50000;
    long delayTime = 60000 * 5; // Five minutes by default.

    public IsspolAsyncServiceCaller(long timeout, long delayTime) {
        this.timeout = timeout;
        this.delayTime = delayTime;
        executor = Executors.newCachedThreadPool();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxy, args);
    }

    public Object callRemoteClass(final String method, final Object clazz, final Object[] payload){
        Object result = null;

        Callable<Object> task = () -> {
            if (System.currentTimeMillis() > currentRetryDelay) {
                for (Method cm : (clazz.getClass().getDeclaredMethods())) {
                    if (method.equals(cm.getName())) {
                        try {
                            cm.setAccessible(true);
                            return invoke(clazz, cm, payload);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    }
                }
            }
            return null;
        };
        Future<Object> future = executor.submit(task);
        try {
            result = future.get(timeout, TimeUnit.MILLISECONDS);
        } catch (TimeoutException ex) {
            logger.error("Service " + clazz + " timed out after " + timeout + " milliseconds, marking the service as down for " + delayTime
                    + " milliseconds.");

            currentRetryDelay = System.currentTimeMillis() + delayTime;

            result = null;
        } catch (InterruptedException e) {
            // handle the interrupts
            logger.error("Service " + clazz + " was interrupted " + e);
            result = null;
        } catch (ExecutionException e) {
            // handle other exceptions
            logger.error("Service " + clazz + " had an execution problem " + e + " " + result);
            result = null;
        } finally {
            future.cancel(true); // may or may not desire this
        }
        return result;
    }

}
