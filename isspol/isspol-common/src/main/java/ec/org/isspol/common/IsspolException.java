package ec.org.isspol.common;

/**
 * Created by mauchilan on 24/3/17.
 */
public class IsspolException extends Exception {

    public IsspolException(String message){
        super(message);
    }

    public IsspolException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
