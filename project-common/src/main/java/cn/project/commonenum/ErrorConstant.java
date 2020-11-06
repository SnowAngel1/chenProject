package com.eigpay.bpass.finengine.exception;

/**
 * @author cyp
 * @date 2020/8/4
 * 自定义异常返回码枚举类
 */
public enum ErrorConstant {
    ERROR_CODE("999999","","系统处理异常"),
    ERROR_MSG("000000","","处理成功");

    ErrorConstant(String code,String type,String desc) {
        this.code = code;
        this.type = type;
        this.desc = desc;
    }

   /**错误码*/
   private String code;
   /**错误类型*/
   private String type;
   /**描述*/
   private String desc;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
