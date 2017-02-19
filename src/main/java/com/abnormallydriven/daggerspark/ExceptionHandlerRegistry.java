package com.abnormallydriven.daggerspark;

import com.abnormallydriven.daggerspark.errors.EntityNotFoundException;
import com.abnormallydriven.daggerspark.errors.EntityNotFoundExceptionHandler;

import javax.inject.Inject;
import javax.inject.Singleton;

import static spark.Spark.exception;

@Singleton
public class ExceptionHandlerRegistry {

    private EntityNotFoundExceptionHandler entityNotFoundExceptionHandler;

    @Inject
    public ExceptionHandlerRegistry(EntityNotFoundExceptionHandler entityNotFoundExceptionHandler){
        this.entityNotFoundExceptionHandler = entityNotFoundExceptionHandler;
    }

    public void registerHandlers(){
        exception(EntityNotFoundException.class, entityNotFoundExceptionHandler);
    }

}
