package cn.sparking.core.entity;

import java.io.Serializable;
import java.util.Map;

public class BaseData implements Serializable {

    private static final long serialVersionUID = 4703800489672099527L;

    private String className;

    private String data;

    /**
     * gets class name.
     * @return String
     */
    public String getClassName() {
        return className;
    }

    /**
     * gets className.
     * @param className class name
     */
    public void setClassName(final String className) {
        this.className = className;
    }

    /**
     * get data.
     * @return {@link String}
     */
    public String getData() {
        return data;
    }

    /**
     * set data.
     * @param data {@link Map}
     */
    public void setData(final String data) {
        this.data = data;
    }
}
