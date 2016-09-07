package com.dbraga.springrest.app.dao;

import java.util.List;

import com.dbraga.springrest.app.domain.Person;

public interface PersonDAO {
    public void saveOrUpdate(Person person);
    
    public void delete(int personId);
     
    public Person get(int personId);
     
    public List<Person> list();

}
