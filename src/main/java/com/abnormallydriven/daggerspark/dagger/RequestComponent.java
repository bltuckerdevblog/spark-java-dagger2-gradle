package com.abnormallydriven.daggerspark.dagger;

import com.abnormallydriven.daggerspark.statistics.RequestStatistics;

import dagger.Subcomponent;

@RequestScope
@Subcomponent()
public interface RequestComponent {

    String REQUEST_COMPONENT_ATTR_NAME = "requestComponent";

    RequestStatistics requestStatistics();

}
