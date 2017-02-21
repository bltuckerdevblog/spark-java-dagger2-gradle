package com.abnormallydriven.daggerspark;

import com.abnormallydriven.daggerspark.people.PeopleResource;

import javax.inject.Inject;
import javax.inject.Singleton;

import spark.ResponseTransformer;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

@Singleton
public class ResourceRegistry {

    private PeopleResource peopleResource;
    private ResponseTransformer responseTransformer;

    @Inject
    ResourceRegistry(PeopleResource peopleResource,
                     ResponseTransformer responseTransformer){
        this.peopleResource = peopleResource;
        this.responseTransformer = responseTransformer;
    }

    void registerRoutes(){

        //Routes for our people resource
        post("/people", "application/json", peopleResource::createPerson, responseTransformer);
        get("/people/:id", "application/json", peopleResource::getPerson, responseTransformer);
        get("/people", "application/json", peopleResource::getAllPeople, responseTransformer);
        put("/people/:id", "application/json", peopleResource::updatePerson, responseTransformer);
        delete("/people/:id", "application/json", peopleResource::deletePerson, responseTransformer);

    }
}
