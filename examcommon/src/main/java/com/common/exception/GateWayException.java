package com.common.exception;



import com.common.api.IErrorCode;
import lombok.Data;

/**
* @desc: 类的描述:网关异常类
* @author: zuo
*/
@Data
public class GateWayException extends RuntimeException{

    private long code;

    private String message;

    public GateWayException(IErrorCode iErrorCode) {
        this.code = iErrorCode.getCode();
        this.message = iErrorCode.getMessage();
    }
}
