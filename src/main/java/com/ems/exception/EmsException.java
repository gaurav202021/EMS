package com.ems.exception;


/**
 * @author Dev
 *
 * Custom Exception class for com.EmsException.
 */
public class EmsException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorMessge;

    private String errorCode;


    public EmsException(String errorCode, String errorMessge) {
        this.errorCode = errorCode;
        this.errorMessge = errorMessge;
    }

    public EmsException(String s, String errorMessge, String errorCode) {
        super(s);
        this.errorMessge = errorMessge;
        this.errorCode = errorCode;
    }

    public EmsException(String s, Throwable throwable, String errorMessge, String errorCode) {
        super(s, throwable);
        this.errorMessge = errorMessge;
        this.errorCode = errorCode;
    }

    public EmsException(Throwable throwable, String errorMessge, String errorCode) {
        super(throwable);
        this.errorMessge = errorMessge;
        this.errorCode = errorCode;
    }

    public EmsException(Throwable e) {
        super(e);
    }



    public String getErrorMessge() {
        return errorMessge;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
