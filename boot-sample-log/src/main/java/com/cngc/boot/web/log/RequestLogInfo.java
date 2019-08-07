package com.cngc.boot.web.log;

import lombok.Data;

import java.util.Date;

/**
 * 请求日志类.
 *
 * @author maxD
 */
@Data
public class RequestLogInfo {

    private String loginAccount;
    private String userName;
    private String orgName;
    private String ip;
    private String uri;
    private String hostUrl;
    private Date requestTime;
    private String message;
    private String request;
}
