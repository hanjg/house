package com.babyjuan.house.common.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author anxi
 * @version 2020/8/19 10:43
 */
public class ElasticSearchCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String s = System.getenv("HOUSE_ENV");
        return "dev".equals(System.getenv("HOUSE_ENV"));
    }
}
