package com.todoapp.controller;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public String handle(Exception ex) {
        return "redirect:/";
    }
}