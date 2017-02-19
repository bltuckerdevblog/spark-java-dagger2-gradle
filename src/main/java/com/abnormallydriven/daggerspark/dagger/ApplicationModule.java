package com.abnormallydriven.daggerspark.dagger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.abnormallydriven.daggerspark.transformers.GsonTransformer;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import spark.ResponseTransformer;

@Module
@Singleton
public class ApplicationModule {

    @Provides
    public Gson provideGson(){
        return new GsonBuilder().setPrettyPrinting().create();
    }

    @Provides
    public ResponseTransformer provideResponseTransformer(GsonTransformer gsonTransformer){
        return gsonTransformer;
    }

    @Provides
    @Named("api_key")
    public String provideApiKey(){
        return "fakeApiKey";
    }

}
