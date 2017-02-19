package com.abnormallydriven.daggerspark.people;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import spark.Request;
import spark.Response;

@Singleton
public class PeopleResource {

    private PeopleRepository peopleRepository;
    private Gson gson;

    @Inject
    public PeopleResource(PeopleRepository peopleRepository, Gson gson){
        this.peopleRepository = peopleRepository;
        this.gson = gson;
    }

    public Person createPerson(Request request, Response response){
        JsonObject requestDto = gson.fromJson(request.body(), JsonObject.class);
        return peopleRepository.createPerson(requestDto.get("firstName").getAsString(), requestDto.get("lastName").getAsString());
    }

    public Person getPerson(Request request, Response response){
        Long personId = Long.valueOf(request.params(":id"));
        return peopleRepository.getPersonById(personId);
    }

    public List<Person> getAllPeople(Request request, Response response){
        return peopleRepository.getAllPeople();
    }

    public Person updatePerson(Request request, Response response){
        Long personId = Long.valueOf(request.params(":id"));

        JsonObject requestDto = gson.fromJson(request.body(), JsonObject.class);
        Person person = peopleRepository.getPersonById(personId);

        person.setFirstName(requestDto.get("firstName").getAsString());
        person.setLastName(requestDto.get("lastName").getAsString());

        return peopleRepository.updatePerson(person);
    }

    public Person deletePerson(Request request, Response response){
        Long personId = Long.valueOf(request.params(":id"));
        return peopleRepository.deletePerson(personId);
    }

}
