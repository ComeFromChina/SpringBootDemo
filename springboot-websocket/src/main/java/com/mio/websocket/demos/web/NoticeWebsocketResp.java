package com.mio.websocket.demos.web;

/**
 * @author jin
 * @date 2024/2/4
 * @Note
 */
import lombok.Data;

@Data
public class NoticeWebsocketResp<T> {

    //通知类型
    private String noticeType;

    //通知内容
    private T noticeInfo;

}