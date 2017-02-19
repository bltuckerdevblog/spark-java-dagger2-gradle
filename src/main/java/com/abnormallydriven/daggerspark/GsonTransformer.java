package com.abnormallydriven.daggerspark;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

import spark.ResponseTransformer;

@Singleton
public class GsonTransformer implements ResponseTransformer {

    private final Gson gson;

    @Inject
    GsonTransformer(Gson gson){
        this.gson = gson;
    }

    @Override
    public String render(Object model) throws Exception {
        return gson.toJson(model);
    }
}
