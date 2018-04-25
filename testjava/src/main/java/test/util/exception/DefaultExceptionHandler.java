package test.util.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;
import test.util.log.LogUtils;

/**
 * Created by lb on 2018/3/20. ControllerAdvice此注解会对所有controller进行控制
 */
@ControllerAdvice
public class DefaultExceptionHandler {
    /**
     * 没有权限 异常
     * <p/>
     * 后续根据不同的需求定制即可
     */
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processUnauthenticatedException(NativeWebRequest request,Exception e){
        LogUtils.logError("用户权限验证失败",e);
        ExceptionResponse exceptionResponse = ExceptionResponse.from(e);

        ModelAndView mv = new ModelAndView();
        mv.addObject("error",exceptionResponse);
        mv.setViewName("error/exception");
        return mv;
    }

    @ExceptionHandler({ForbiddenException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView handleForbiddenException(NativeWebRequest request, ForbiddenException e) {
        LogUtils.logError("禁止访问", e);
        ExceptionResponse exceptionResponse = ExceptionResponse.from(e);

        ModelAndView mv = new ModelAndView();
        mv.addObject("error", exceptionResponse);
        mv.setViewName("error/403");
        return mv;
    }
}
