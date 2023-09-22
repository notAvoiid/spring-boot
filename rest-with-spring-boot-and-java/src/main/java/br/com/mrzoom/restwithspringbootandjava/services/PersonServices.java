package br.com.mrzoom.restwithspringbootandjava.services;

import br.com.mrzoom.restwithspringbootandjava.PersonRepository;
import br.com.mrzoom.restwithspringbootandjava.exceptions.ResourceNotFoundException;
import br.com.mrzoom.restwithspringbootandjava.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Finding all people!");
        return repository.findAll();
    }

    public Person findById(Long id){
        logger.info("Finding one person!");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one person!");
        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id){
        logger.info("Deleting one person!");
        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
        repository.delete(entity);
    }
}
