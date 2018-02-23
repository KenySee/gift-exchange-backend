package com.bootdo.common.infrastructure;

import com.bootdo.common.exception.ResponseException;
import com.bootdo.common.page.AjaxResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
//    @ExceptionHandler({ RuntimeException.class })
//    @ResponseStatus(HttpStatus.OK)
//    public ModelAndView processException(RuntimeException exception) {
//        logger.info("自定义异常处理-RuntimeException");
//        ModelAndView m = new ModelAndView();
//        m.addObject("exception", exception.getMessage());
//        m.setViewName("error/500");
//        return m;
//
//    }
//
//    @ExceptionHandler({ Exception.class })
//    @ResponseStatus(HttpStatus.OK)
//    public ModelAndView processException(Exception exception) {
//        logger.info("自定义异常处理-Exception");
//        ModelAndView m = new ModelAndView();
//        m.addObject("exception", exception.getMessage());
//        m.setViewName("error/500");
//        return m;
//
//    }
    AjaxResponse<String> createAjaxResponse(RuntimeException e){
        AjaxResponse<String> ajaxResponse = new AjaxResponse<>();
        ajaxResponse.setStatusCode(-1);
        ajaxResponse.setMessage(e.getMessage());
        ajaxResponse.setSuccess(false);
        ajaxResponse.setResult(null);
        return ajaxResponse;
    }
    @ExceptionHandler({RuntimeException.class})
    @ResponseBody
    public AjaxResponse<String> processException(HttpServletRequest req, RuntimeException e) throws Exception {
        return createAjaxResponse(e);
    }
    @ExceptionHandler({ResponseException.class})
    @ResponseBody
    public AjaxResponse<String> jsonErrorHandler(HttpServletRequest req, ResponseException e) throws Exception {
        return createAjaxResponse(e);
    }
}