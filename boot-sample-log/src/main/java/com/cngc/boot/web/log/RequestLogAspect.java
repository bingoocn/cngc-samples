package com.cngc.boot.web.log;

import com.cngc.boot.web.log.spel.LogEvaluationContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 处理请求日志的切面.
 *
 * @author maxD
 */
@Component
@Aspect
public class RequestLogAspect {

    @Around("@annotation(requestLog)")
    public Object doBasicProfiling(ProceedingJoinPoint pjp, RequestLog requestLog) throws Throwable {
        // 使用代理后的注解,别名生效.
        requestLog = AnnotationUtils.synthesizeAnnotation(requestLog, null);
        // 寻找使用RequestLogParam注解的参数,将其作为rootObject设置为spel的上下文中.
        Map<String, Object> params = new HashMap<>(5);
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Parameter[] parameters = signature.getMethod().getParameters();
        for (int i = 0; i < parameters.length; i++) {
            int finalI = i;
            Optional.ofNullable(parameters[finalI].getAnnotation(RequestLogParam.class)).ifPresent(
                    requestLogParam -> params.put(requestLogParam.value(), pjp.getArgs()[finalI])
            );
        }

        String message = new SpelExpressionParser().parseExpression(requestLog.message(),
                new TemplateParserContext()).getValue(new LogEvaluationContext(params), String.class);

        Object retVal = pjp.proceed();

        return retVal;
    }
}
