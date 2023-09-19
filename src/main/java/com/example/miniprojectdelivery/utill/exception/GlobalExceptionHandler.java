package com.example.miniprojectdelivery.utill.exception;

import com.example.miniprojectdelivery.model.Msg;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public Msg handlerIllegalArgumentException(HttpServletResponse response,
            IllegalArgumentException ex) {
        response.setStatus(400);
        String msg = ex.getMessage();
        return new Msg(400, msg);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Msg handlerMethodArgumentNotValidException(HttpServletResponse response,
            MethodArgumentNotValidException ex) {
        response.setStatus(400);
        String msg = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new Msg(400, msg);
    }

    @ExceptionHandler(Exception.class)
    public String ExHandler(Exception e) {
        return e.getMessage();
    }
}
