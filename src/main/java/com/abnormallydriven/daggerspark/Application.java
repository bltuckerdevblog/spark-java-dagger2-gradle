package com.abnormallydriven.daggerspark;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.abnormallydriven.daggerspark.people.PeopleRepository;
import com.abnormallydriven.daggerspark.people.PeopleResource;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;


public class Application {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PeopleRepository peopleRepository = new PeopleRepository();
        GsonTransformer transformer = new GsonTransformer(gson);

        PeopleResource peopleResource = new PeopleResource(peopleRepository, gson);

        post("/people", "application/json", peopleResource::createPerson, transformer);
        get("/people/:id", "application/json", peopleResource::getPerson, transformer);
        get("/people", "application/json", peopleResource::getAllPeople, transformer);
        put("/people/:id", "application/json", peopleResource::updatePerson, transformer);
        delete("/people/:id", "application/json", peopleResource::deletePerson, transformer);

    }
}
