package com.aumanca.sda.fitness.exceptions;

public class NotFoundException extends RuntimeException {
    private ErrorCode errorCode;

    public NotFoundException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getCode() {
        return this.errorCode.getCode();
    }

    public enum ErrorCode {
        USER_NOT_FOUND("user_not_found");

        private String code;

        ErrorCode(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

}
