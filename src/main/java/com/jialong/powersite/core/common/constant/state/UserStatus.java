package com.jialong.powersite.core.common.constant.state;


public enum UserStatus {

    ENABLE(1, "启用"),
    DISABLE(2, "冻结"),
    DELETED(3, "删除");

    int code;
    String message;

    UserStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String valueOf(Integer status) {
        if (status == null) {
            return "";
        } else {
            for (UserStatus s : UserStatus.values()) {
                if (s.getCode() == status) {
                    return s.getMessage();
                }
            }
            return "";
        }
    }
}
