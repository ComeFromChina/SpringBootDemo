package com.lovemio.jwt.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liwenjin
 * @date 2021年04月12日 11:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultInfo<T> {
    private Integer status;
    private String message;
    private T response;

    public ResultInfo(Integer status, String message) {
        this.status = status;
        this.message = message;
    }


    public static <E>ResultInfo<E> success(Integer status,String message,E t){

        return new ResultInfo(status,message,t);
    }

    public static <E>ResultInfo<E> success(Integer status,String message){

        return new ResultInfo(status,message);
    }
}
