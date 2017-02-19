package com.abnormallydriven.daggerspark;

import com.abnormallydriven.daggerspark.dagger.ApplicationComponent;
import com.abnormallydriven.daggerspark.dagger.DaggerApplicationComponent;

public class Application {

    private ApplicationComponent applicationComponent;

    private void start(){
        //initialize dagger
        initializeDagger();

        //register routes
        registerRoutes();
    }

    private void initializeDagger() {
        applicationComponent = DaggerApplicationComponent.create();
    }

    private void registerRoutes(){
        applicationComponent.resourceRegistry().registerRoutes();
    }

    public static void main(String[] args) {
        new Application().start();
    }
}
