package cn.project.commonenum;


/**
 * @author cyp
 * @date 2020/8/1
 */
public class BusinessException extends RuntimeException {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -2865846601908676032L;

    /**
     * 结果码
     */
    private String resultCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 重写getMessage，附带结果枚举的信息
     *
     * @see Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return this.errorMsg;
    }

    public BusinessException(String resultCode, String errorMsg) {
        super();
        this.resultCode = resultCode;
        this.errorMsg = errorMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
