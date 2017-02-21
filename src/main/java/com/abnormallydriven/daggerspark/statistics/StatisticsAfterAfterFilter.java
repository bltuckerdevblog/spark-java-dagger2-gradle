package com.abnormallydriven.daggerspark.statistics;

import com.abnormallydriven.daggerspark.dagger.RequestComponent;

import javax.inject.Inject;
import javax.inject.Singleton;

import spark.Filter;
import spark.Request;
import spark.Response;

@Singleton
public class StatisticsAfterAfterFilter implements Filter {

    @Inject
    public StatisticsAfterAfterFilter(){
    }

    @Override
    public void handle(Request request, Response response) throws Exception {
        long requestTotalTime = ((RequestComponent) request.attribute(RequestComponent.REQUEST_COMPONENT_ATTR_NAME))
                .requestStatistics()
                .getTotalRequestTime();
        response.header("requestTime", String.valueOf(requestTotalTime));
        response.header("requestCount", String.valueOf(RequestStatistics.requestCount.get()));
    }
}
