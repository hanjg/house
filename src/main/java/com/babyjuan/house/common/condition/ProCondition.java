package com.babyjuan.house.common.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author anxi
 * @version 2020/8/19 10:43
 */
public class ProCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return "pro".equals(System.getenv("HOUSE_ENV"));
    }
}
