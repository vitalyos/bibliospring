package edu.bbu.bibliospring.common.dto;

/**
 *
 * @author zsvitalyos
 */
public  abstract class DataTransferObject implements java.io.Serializable {
    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public DataTransferObject(String className) {
        this.className = className;
    }
}
