package com.babyjuan.house.global;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * @Author: hjg
 * @Date: Create in 2018/12/9 11:47
 * @Description:
 */
@Aspect
@Configuration
public class TransactionConfig {

    /**
     * 包名后面的 .. 表示当前包及子包
     */
    private static final String AOP_POINTCUT_EXPRESSION = "execution (* com.babyjuan.house.service..*.*(..))";

    private final PlatformTransactionManager transactionManager;
    private final DefaultTransactionAttribute txAttr_required;
    private final DefaultTransactionAttribute txAttr_required_readonly;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public TransactionConfig(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;

        txAttr_required = new DefaultTransactionAttribute();
        txAttr_required.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        txAttr_required_readonly = new DefaultTransactionAttribute();
        txAttr_required_readonly.setPropagationBehavior(TransactionDefinition.PROPAGATION_SUPPORTS);
        txAttr_required_readonly.setReadOnly(true);
    }


    @Bean
    public TransactionInterceptor txAdvice() {
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        source.addTransactionalMethod("add*", txAttr_required);
        source.addTransactionalMethod("save*", txAttr_required);
        source.addTransactionalMethod("create*", txAttr_required);
        source.addTransactionalMethod("insert*", txAttr_required);
        source.addTransactionalMethod("delete*", txAttr_required);
        source.addTransactionalMethod("update*", txAttr_required);
        source.addTransactionalMethod("exec*", txAttr_required);
        source.addTransactionalMethod("set*", txAttr_required);

        source.addTransactionalMethod("get*", txAttr_required_readonly);
        source.addTransactionalMethod("query*", txAttr_required_readonly);
        source.addTransactionalMethod("find*", txAttr_required_readonly);
        source.addTransactionalMethod("select*", txAttr_required_readonly);
        source.addTransactionalMethod("list*", txAttr_required_readonly);
        source.addTransactionalMethod("count*", txAttr_required_readonly);
        source.addTransactionalMethod("is*", txAttr_required_readonly);
        return new TransactionInterceptor(transactionManager, source);
    }

    @Bean
    public Advisor txAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }
}
