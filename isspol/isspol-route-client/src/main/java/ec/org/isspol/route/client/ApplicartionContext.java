package ec.org.isspol.route.client;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by mauchilan on 23/3/17.
 */
@Component
public class ApplicartionContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static Object getBean(String bean){
        if (applicationContext == null){
            applicationContext = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/route-client.xml");
        }
        return applicationContext.getBean(bean);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
