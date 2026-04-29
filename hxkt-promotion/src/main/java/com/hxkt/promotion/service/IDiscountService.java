package com.hxkt.promotion.service;

import com.hxkt.api.dto.promotion.CouponDiscountDTO;
import com.hxkt.api.dto.promotion.OrderCouponDTO;
import com.hxkt.api.dto.promotion.OrderCourseDTO;

import java.util.List;

public interface IDiscountService {
    List<CouponDiscountDTO> findDiscountSolution(List<OrderCourseDTO> orderCourses);

    CouponDiscountDTO queryDiscountDetailByOrder(OrderCouponDTO orderCouponDTO);
}
