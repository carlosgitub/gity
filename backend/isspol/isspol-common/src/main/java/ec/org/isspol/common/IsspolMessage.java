package ec.org.isspol.common;

import java.io.Serializable;

/**
 * Created by mauchilan on 24/3/17.
 */
public class IsspolMessage implements Serializable {

    private String method;
    private Object[] parameters;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
