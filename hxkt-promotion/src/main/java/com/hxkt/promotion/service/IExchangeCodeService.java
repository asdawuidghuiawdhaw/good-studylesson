package com.hxkt.promotion.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hxkt.common.domain.dto.PageDTO;
import com.hxkt.promotion.domain.po.Coupon;
import com.hxkt.promotion.domain.po.ExchangeCode;
import com.hxkt.promotion.domain.query.CodeQuery;
import com.hxkt.promotion.domain.vo.ExchangeCodeVO;

/**
 * <p>
 * 兑换码 服务类
 * </p>
 *
 * @author 虎哥
 */
public interface IExchangeCodeService extends IService<ExchangeCode> {
    void asyncGenerateCode(Coupon coupon);

    boolean updateExchangeMark(long serialNum, boolean mark);

    PageDTO<ExchangeCodeVO> queryCodePage(CodeQuery query);

    Long exchangeTargetId(long serialNum);
}
