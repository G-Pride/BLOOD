package com.dfish.domain.vo;

public class UploadFileResult {

    /**
     * 0 表示上传失败，1 表示上传成功
     */
    private int success ;
    /**
     * 提示的信息，上传成功或上传失败及错误信息等。
     */
    private String message ;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件地址
     */
    private String url ;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public UploadFileResult() {
    }

    public UploadFileResult(int success, String message, String url, String fileName) {
        this.success = success;
        this.message = message;
        this.url = url;
        this.fileName = fileName;
    }
}
