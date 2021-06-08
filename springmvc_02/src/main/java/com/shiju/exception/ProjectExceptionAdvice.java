package com.shiju.exception;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author shiju
 * @date 2021/06/08 21:11
 */
@Component
@ControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(BusinessException.class)
    public String doBusinessException(Exception ex, Model m) {
        m.addAttribute("msg", ex.getMessage());
        return "error.jsp";
    }

    @ExceptionHandler(SystemException.class)
    public String doSystemException(Exception ex, Model m) {
        m.addAttribute("msg", ex.getMessage());
        return "error.jsp";
    }

    @ExceptionHandler(Exception.class)
    public String doException(Exception ex, Model m) {
        m.addAttribute("msg", ex.getMessage());
        return "error.jsp";
    }
}
