package pers.cabin.java.constants.enums;


import pers.cabin.java.constants.Constants;

import java.io.UnsupportedEncodingException;

public enum CodeMsgEnum {

    SERVER_ERROR(500);
    private static final String BASE_NAME = "CodeMsg";
    private Integer code;
    private String msg;

    public String getMsg() {
        return this.msg;
    }

    CodeMsgEnum(Integer code) {
        this.code = code;
        this.msg = getBundleMsg(code);
    }

    private String getBundleMsg(Integer code) {
        if (null != code) {
            String resourceBundleString = Constants.CodeMsgBundle.getString(this.code + "");
            if (null != resourceBundleString) {
                try {
                    return new String(resourceBundleString.getBytes("iso8859-1"), Constants.ENCODING);
                } catch (UnsupportedEncodingException e) {
                    return resourceBundleString;
                }
            }
        }
        return null;
    }
}
