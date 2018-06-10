package pers.cabin.springdata.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import pers.cabin.springdata.jpa.po.Person;

/**
 * Created by caiping on 2017/6/11.
 */
public interface PersonDao extends CrudRepository<Person,Integer>{

}
