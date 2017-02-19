package com.abnormallydriven.daggerspark.dagger;

import com.abnormallydriven.daggerspark.ExceptionHandlerRegistry;
import com.abnormallydriven.daggerspark.ResourceRegistry;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    ResourceRegistry resourceRegistry();
    ExceptionHandlerRegistry exceptionHandlerRegistry();
}
