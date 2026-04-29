package com.hxkt.trade.service;

import com.hxkt.trade.domain.dto.OrderDelayQueryDTO;
import com.hxkt.trade.domain.dto.PayApplyFormDTO;
import com.hxkt.trade.domain.vo.PayChannelVO;

import java.util.List;

public interface IPayService {
    List<PayChannelVO> queryPayChannels();

    String applyPayOrder(PayApplyFormDTO payApply);

    void queryPayResult(OrderDelayQueryDTO message);
}
