package com.hxkt.promotion.strategy.scope;

import com.hxkt.api.dto.promotion.OrderCourseDTO;
import com.hxkt.promotion.constants.ScopeType;

import java.util.List;

public interface Scope {

    boolean canUse(OrderCourseDTO course);

    ScopeType getType();

    List<Long> getScopeIds();
}
