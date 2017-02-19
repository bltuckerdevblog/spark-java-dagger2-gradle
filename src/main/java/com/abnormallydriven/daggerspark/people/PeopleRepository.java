package com.abnormallydriven.daggerspark.people;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PeopleRepository {

    private final AtomicInteger idSequence;

    private final Map<Long, Person> personMap;

    @Inject
    public PeopleRepository(){
        idSequence = new AtomicInteger(0);
        personMap = new ConcurrentHashMap<>(10);
    }

    public Person createPerson(String firstName, String lastName){
        Person newPerson = new Person(idSequence.incrementAndGet(), firstName, lastName);
        personMap.put(newPerson.getId(), newPerson);
        return newPerson;
    }

    public List<Person> getAllPeople(){
        return personMap.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public Person getPersonById(long personId){
        return personMap.get(personId);
    }

    public Person updatePerson(Person updatedPerson){
        personMap.replace(updatedPerson.getId(), updatedPerson);
        return updatedPerson;
    }

    public Person deletePerson(long personId){
        return personMap.remove(personId);
    }
}
