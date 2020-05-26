package com.babyjuan.house.service.dto;

/**
 * @author anxi
 * @version 2020/5/26 0:37
 */
public class BaseResponse<T> {

    private Integer code;

    private String msg;

    protected T result;

    public static <T> BaseResponse<T> newSuccessResponse(T result) {
        return new Builder<>().code(20000).msg("Successful").result(result).build();
    }

    public static <T> BaseResponse<T> newFailureResponse(String msg) {
        return new Builder<>().code(50000).msg(msg).build();
    }

    public BaseResponse(Builder<T> builder) {
        this.code = builder.code;
        this.msg = builder.msg;
        this.result = builder.result;
    }

    public static final class Builder<T> {

        private Integer code;

        private String msg;

        private T result;

        private Builder() {
        }

        public BaseResponse build() {
            return new BaseResponse(this);
        }

        public Builder<T> code(Integer code) {
            this.code = code;
            return this;
        }

        public Builder<T> msg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder<T> result(T result) {
            this.result = result;
            return this;
        }
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getResult() {
        return result;
    }
}
