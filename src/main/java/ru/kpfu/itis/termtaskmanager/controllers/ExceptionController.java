package ru.kpfu.itis.termtaskmanager.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@Slf4j
public class ExceptionController {
    @ExceptionHandler(NoHandlerFoundException.class)
    public String notFoundException(HttpServletResponse response, NoHandlerFoundException e) {
        log.error(e.getMessage());
        response.setStatus(404);
        return "notFoundError";
    }

    @ExceptionHandler(Exception.class)
    public String exception(HttpServletResponse response, Exception e) {
        log.error(e.getMessage());
        response.setStatus(500);
        return "error";
    }
}
