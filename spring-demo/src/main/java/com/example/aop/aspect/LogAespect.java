package com.example.aop.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * *                            _ooOoo_
 * *                           o8888888o
 * *                           88" . "88
 * *                           (| -_- |)
 * *                            O\ = /O
 * *                        ____/`---'\____
 * *                      .   ' \\| |// `.
 * *                       / \\||| : |||// \
 * *                    / _||||| -:- |||||- \
 * *                       | | \\\ - /// | |
 * *                     | \_| ''\---/'' | |
 * *                      \ .-\__ `-` ___/-. /
 * *                   ___`. .' /--.--\ `. . __
 * *                ."" '< `.___\_<|>_/___.' >'"".
 * *               | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * *                 \ \ `-. \_ __\ /__ _/ .-` / /
 * *         ======`-.____`-.___\_____/___.-`____.-'======
 * *                            `=---='
 * *
 * *         .............................................
 * *                  佛祖保佑             永无BUG
 * *          佛曰:
 * *                  写字楼里写字间，写字间里程序员；
 * *                  程序人员写程序，又拿程序换酒钱。
 * *                  酒醒只在网上坐，酒醉还来网下眠；
 * *                  酒醉酒醒日复日，网上网下年复年。
 * *                  但愿老死电脑间，不愿鞠躬老板前；
 * *                  奔驰宝马贵者趣，公交自行程序员。
 * *                  别人笑我忒疯癫，我笑自己命太贱；
 * *                  不见满街漂亮妹，哪个归得程序员？
 *
 * @Author:shixianqing
 * @Date:2019/8/23 15:26
 * @Description:
 **/
@Aspect
public class LogAespect {

    /**
     * 公共切入点表达式
     */
    @Pointcut(value = "execution(public int com.example.aop.Calculate.*(..))")
    public void pointCut(){

    }

    @Before(value = "pointCut()")
    public void logBefore(){

        System.out.println("...................Before.............");
    }

    /**
     * 在目标方法(div)运行结束之后运行,无论正常或异常结束 (@After)
     */
    @After(value = "pointCut()")
    public void logEnd(){

        System.out.println("...................After.............");
    }


    /**
     * 在目标方法(div)正常返回之后运行 (@AfterReturning)
     */
    @AfterReturning(value = "pointCut()")
    public void logReturn(){

        System.out.println("...................AfterReturning.............");
    }

    /**
     * 在目标方法(div)出现异常后运行(@AfterThrowing)
     */
    @AfterThrowing(value = "pointCut()")
    public void logException(){

        System.out.println("...................AfterThrowing.............");
    }

    @Around(value = "pointCut()")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("...................logAround开始.............");
        joinPoint.proceed();
        System.out.println("...................logAround结束.............");
    }
}


