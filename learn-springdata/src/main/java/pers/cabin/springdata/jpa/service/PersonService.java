package pers.cabin.springdata.jpa.service;

import pers.cabin.springdata.jpa.po.Person;

import java.util.List;

/**
 * Created by caiping on 2017/6/11.
 */
public interface PersonService {
    void save(List<Person> personList);
}
