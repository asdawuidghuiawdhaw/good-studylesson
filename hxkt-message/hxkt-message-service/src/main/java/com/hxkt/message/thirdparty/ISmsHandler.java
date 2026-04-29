package com.hxkt.message.thirdparty;

import com.hxkt.api.dto.sms.SmsInfoDTO;
import com.hxkt.message.domain.po.MessageTemplate;

/**
 * 第三方接口对接平台
 */
public interface ISmsHandler {

    /**
     * 发送短信
     */
    void send(SmsInfoDTO platformSmsInfoDTO, MessageTemplate template);


}
