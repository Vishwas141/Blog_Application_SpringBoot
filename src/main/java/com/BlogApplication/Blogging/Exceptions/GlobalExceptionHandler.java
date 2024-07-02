package com.BlogApplication.Blogging.Exceptions;


import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{
   @ExceptionHandler(ResourceNotFoundException.class)
    public String resourceNotFoundExceptionHandler(ResourceNotFoundException ex)
   {
       String message = ex.getMessage();
       return message;
   }

   @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleMethodArgsNotFound(MethodArgumentNotValidException ex)
   {
       String message = ex.getBindingResult().getFieldError().getDefaultMessage();

       return message;
   }
}
