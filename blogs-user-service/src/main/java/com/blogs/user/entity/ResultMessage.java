package com.blogs.user.entity;

import java.util.List;

public class ResultMessage<T> {

    /**
     * 返回代码参数  0000为成功
     */
    private String code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 放回集合对象
     */
    private List<T> records;

    /**
     * 返回单个对象
     */
    private T record;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public T getRecord() {
        return record;
    }

    public void setRecord(T record) {
        this.record = record;
    }
}
