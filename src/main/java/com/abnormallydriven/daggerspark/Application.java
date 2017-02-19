package com.abnormallydriven.daggerspark;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import com.abnormallydriven.daggerspark.people.PeopleRepository;
import com.abnormallydriven.daggerspark.people.Person;

import static spark.Spark.*;


public class Application {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PeopleRepository peopleRepository = new PeopleRepository();
        GsonTransformer transformer = new GsonTransformer(gson);


        post("/people", "application/json", (request, response) -> {
            JsonObject requestDto = gson.fromJson(request.body(), JsonObject.class);
            return peopleRepository.createPerson(requestDto.get("firstName").getAsString(), requestDto.get("lastName").getAsString());
        }, transformer);


        get("/people/:id", "application/json", (request, response) -> {
            Long personId = Long.valueOf(request.params(":id"));
            return peopleRepository.getPersonById(personId);
        }, transformer);

        get("/people", "application/json", (request, response) -> {
            return peopleRepository.getAllPeople();
        }, transformer);


        put("/people/:id", "application/json", (request, response) -> {
            Long personId = Long.valueOf(request.params(":id"));

            JsonObject requestDto = gson.fromJson(request.body(), JsonObject.class);
            Person person = peopleRepository.getPersonById(personId);

            person.setFirstName(requestDto.get("firstName").getAsString());
            person.setLastName(requestDto.get("lastName").getAsString());

            return peopleRepository.updatePerson(person);
        }, transformer);


        delete("/people/:id", "application/json", (request, response) -> {
            Long personId = Long.valueOf(request.params(":id"));
            return peopleRepository.deletePerson(personId);
        }, transformer);

    }
}
