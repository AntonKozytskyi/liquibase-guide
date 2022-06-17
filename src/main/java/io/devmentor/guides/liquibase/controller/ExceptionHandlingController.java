package io.devmentor.guides.liquibase.controller;

import io.devmentor.guides.liquibase.exception.PageNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

  @ExceptionHandler(PageNotFoundException.class)
  public String pageNotFoundHandler() {
    return "errors/404";
  }
}
