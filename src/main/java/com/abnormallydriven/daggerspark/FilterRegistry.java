package com.abnormallydriven.daggerspark;

import com.abnormallydriven.daggerspark.authorization.AuthorizationFilter;
import com.abnormallydriven.daggerspark.statistics.RequestScopeInjectionFilter;
import com.abnormallydriven.daggerspark.statistics.StatisticsAfterAfterFilter;
import com.abnormallydriven.daggerspark.statistics.StatisticsAfterFilter;

import javax.inject.Inject;
import javax.inject.Singleton;

import static spark.Spark.after;
import static spark.Spark.afterAfter;
import static spark.Spark.before;

@Singleton
public class FilterRegistry {

    private final AuthorizationFilter authorizationFilter;
    private final RequestScopeInjectionFilter requestScopeInjectionFilter;
    private final StatisticsAfterFilter statisticsAfterFilter;
    private final StatisticsAfterAfterFilter statisticsAfterAfterFilter;

    @Inject
    public FilterRegistry(AuthorizationFilter authorizationFilter,
                          RequestScopeInjectionFilter requestScopeInjectionFilter,
                          StatisticsAfterFilter statisticsAfterFilter,
                          StatisticsAfterAfterFilter statisticsAfterAfterFilter){

        this.authorizationFilter = authorizationFilter;
        this.requestScopeInjectionFilter = requestScopeInjectionFilter;
        this.statisticsAfterFilter = statisticsAfterFilter;
        this.statisticsAfterAfterFilter = statisticsAfterAfterFilter;
    }

    void registerFilters(){

        before(requestScopeInjectionFilter);
        before(authorizationFilter);

        after(statisticsAfterFilter);

        afterAfter(statisticsAfterAfterFilter);
    }

}
