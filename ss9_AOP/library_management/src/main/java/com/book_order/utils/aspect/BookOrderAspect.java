package com.book_order.utils.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookOrderAspect {
    private static int count = 0;

    @After("execution(* com.book_order.controller.BookOrderController.order(..))")
    public void logAfterOrder(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Modified:  Người dùng đã " + methodName);
    }

    @After("execution(* com.book_order.controller.BookOrderController.returnBook(..))")
    public void logAfterReturn(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Modified:  Người dùng đã " + methodName);
    }

    @After("within(com.book_order.controller.*)")
    public void logAfterAll(JoinPoint joinPoint) {
        count++;
        String methodName = joinPoint.getSignature().getName();
        System.out.println("All:  Người dùng đã " + methodName);
        System.out.println("No " + count);
    }

}
