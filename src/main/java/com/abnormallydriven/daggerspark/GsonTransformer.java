package com.abnormallydriven.daggerspark;

import com.google.gson.Gson;

import spark.ResponseTransformer;

public class GsonTransformer implements ResponseTransformer {

    private final Gson gson;

    public GsonTransformer(Gson gson){
        this.gson = gson;
    }

    @Override
    public String render(Object model) throws Exception {
        return gson.toJson(model);
    }
}
