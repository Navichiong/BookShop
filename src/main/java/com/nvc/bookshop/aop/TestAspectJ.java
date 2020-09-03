package com.nvc.bookshop.aop;

import com.nvc.bookshop.utils.ServerMessage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

@Component
@Aspect
public class TestAspectJ {

    private Logger logger = LoggerFactory.getLogger(TestAspectJ.class);

    @Pointcut(value = "execution(public com.nvc.bookshop.utils.ServerMessage com.nvc.bookshop.controller.*.*(..))")
    private void testControllerPointCut() {

    }

    /**
     * aop数据校验错误信息返回值
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = "testControllerPointCut()", returning = "result")
    public void returningAdvice(JoinPoint joinPoint, Object result) {
        Object[] args = joinPoint.getArgs();
        ServerMessage sm = (ServerMessage) result;
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                System.out.println(arg.getClass().getName());
                BindingResult br = (BindingResult) arg;
                if (br.hasErrors()) {
                    logger.info("数据校验不通过，重新包装返回值...");
                    List<FieldError> fieldErrors = br.getFieldErrors();
                    for (FieldError fieldError : fieldErrors) {
                        sm.addData(fieldError.getField(), fieldError.getDefaultMessage());
                        sm.setCode(200);
                        sm.setMessage("数据校验失败!");
                    }
                }
                logger.info("数据校验通过，正常返回！");
                break;
            }
        }
    }
}
