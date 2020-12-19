package com.wang.entity;

import java.io.Serializable;

public class ServerResponse<T> implements Serializable {
    private int status;
    private T workList;
    private int count;
    private String msg;

    private ServerResponse(int status,T workList,String msg,int count){
        this.status = status;
        this.workList = workList;
        this.msg = msg;
        this.count = count;
    }
    private ServerResponse(int status,String msg){
        this.status = status;
        this.msg = msg;
    }

    /**
     * getAll返回信息
     *
     * @param msg
     * @param workList
     * @param count
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> getSuccess(String msg,T workList,int count){
        return new ServerResponse<T>(200,workList,msg,count);
    }

    public static <T> ServerResponse<T> getError(String msg){
        return new ServerResponse<T>(403,null,msg,0);
    }

    /**
     * add返回信息
     *
     * @param msg
     * @param workList
     * @param count
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> AddSuccess(String msg,T workList,int count){
        return new ServerResponse<T>(200, workList, msg,count);
    }

    public static <T> ServerResponse<T> AddError(String msg){
        return new ServerResponse<T>(403, null, msg,0);
    }

    /**
     * delete返回信息
     *
     * @param msg
     * @param workList
     * @param count
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> DeleteSuccess(String msg,T workList,int count){
        return new ServerResponse<T>(200, workList, msg,count);
    }

    public static <T> ServerResponse<T> DeleteError(String msg){
        return new ServerResponse<T>(403, null, msg,0);
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getWorkList() {
        return workList;
    }

    public void setWorkList(T workList) {
        this.workList = workList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
