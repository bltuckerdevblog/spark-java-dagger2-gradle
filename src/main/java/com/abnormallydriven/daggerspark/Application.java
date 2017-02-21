package com.abnormallydriven.daggerspark;

import com.abnormallydriven.daggerspark.dagger.ApplicationComponent;
import com.abnormallydriven.daggerspark.dagger.DaggerApplicationComponent;

public class Application {

    private static ApplicationComponent applicationComponent;

    public static ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }

    private void start(){
        //initialize dagger
        initializeDagger();

        //register exception handlers
        registerExceptionHandlers();

        //register our filters
        registerFilters();

        //register routes
        registerRoutes();
    }

    private void initializeDagger() {
        applicationComponent = DaggerApplicationComponent.create();
    }

    private void registerExceptionHandlers() {
        applicationComponent.exceptionHandlerRegistry().registerHandlers();
    }

    private void registerFilters() {
        applicationComponent.filterRegistry().registerFilters();
    }

    private void registerRoutes(){
        applicationComponent.resourceRegistry().registerRoutes();
    }

    public static void main(String[] args) {
        new Application().start();
    }
}
