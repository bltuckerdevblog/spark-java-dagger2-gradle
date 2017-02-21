package com.abnormallydriven.daggerspark.statistics;

import com.abnormallydriven.daggerspark.Application;
import com.abnormallydriven.daggerspark.dagger.RequestComponent;

import javax.inject.Inject;
import javax.inject.Singleton;

import spark.Filter;
import spark.Request;
import spark.Response;

@Singleton
public class RequestScopeInjectionFilter implements Filter {

    @Inject
    public RequestScopeInjectionFilter(){
    }


    @Override
    public void handle(Request request, Response response) throws Exception {
        RequestComponent requestComponent = Application.getApplicationComponent().requestComponent();
        request.attribute(RequestComponent.REQUEST_COMPONENT_ATTR_NAME, requestComponent);
        requestComponent.requestStatistics().setRequestStartTime(System.currentTimeMillis());
    }
}
