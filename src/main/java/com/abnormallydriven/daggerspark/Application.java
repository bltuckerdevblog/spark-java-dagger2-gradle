package com.abnormallydriven.daggerspark;

import com.google.gson.Gson;

import com.abnormallydriven.daggerspark.people.Person;

import static spark.Spark.*;


public class Application {

    public static void main(String[] args) {
        Gson gson = new Gson();
        get("/hello", (req, res) -> "Hello World");
        get("/people/:id", "application/json", (req, res) -> {
            Long personId = Long.valueOf(req.params(":id"));
            return new Person(personId, "Test", "Person");}, new GsonTransformer(gson));
    }
}
