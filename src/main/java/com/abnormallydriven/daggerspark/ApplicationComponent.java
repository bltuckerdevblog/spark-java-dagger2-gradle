package com.abnormallydriven.daggerspark;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    ResourceRegistry resourceRegistry();
}
