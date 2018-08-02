package com.etoak.service.impl;

import com.etoak.dto.OrderDTO;
import com.etoak.service.PushMessage;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author 邢尚尚
 * @Date 2018/5/25
 */
@Slf4j
@Service
public class PushMessageImpl implements PushMessage {
    @Autowired
    private WxMpService wxMpService;
    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage wxMpTemplateMessage = new WxMpTemplateMessage();
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(wxMpTemplateMessage);
        } catch (WxErrorException e) {
            e.printStackTrace();
            log.error("【消息模板】 发送失败 ，{}",e);
        }
    }
}
