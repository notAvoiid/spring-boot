package br.com.mrzoom.restwithspringbootandjava.services;

import br.com.mrzoom.restwithspringbootandjava.controllers.PersonController;
import br.com.mrzoom.restwithspringbootandjava.data.vo.v1.PersonVO;
import br.com.mrzoom.restwithspringbootandjava.data.vo.v2.PersonVOV2;
import br.com.mrzoom.restwithspringbootandjava.exceptions.RequiredObjectIsNullException;
import br.com.mrzoom.restwithspringbootandjava.mapper.ModelMapper;
import br.com.mrzoom.restwithspringbootandjava.mapper.custom.PersonMapper;
import br.com.mrzoom.restwithspringbootandjava.model.Person;
import br.com.mrzoom.restwithspringbootandjava.repository.PersonRepository;
import br.com.mrzoom.restwithspringbootandjava.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper mapper;

    public List<PersonVO> findAll() {
        logger.info("Finding all people!");
        List<PersonVO> people = ModelMapper.parseListObjects(repository.findAll(), PersonVO.class);
        people
                .stream()
                .forEach(
                        p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getId())).withSelfRel())
                );
        return people;
    }

    public PersonVO findById(Long id){
        logger.info("Finding one person!");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        PersonVO vo = ModelMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;
    }

    public PersonVO create(PersonVO person) {
        if (person == null) throw new RequiredObjectIsNullException();
        logger.info("Creating one person!");

        Person entity = ModelMapper.parseObject(person, Person.class);
        PersonVO vo = ModelMapper.parseObject(repository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getId())).withSelfRel());
        return vo;
    }

    public PersonVOV2 createV2(PersonVOV2 person) {
        logger.info("Creating one person!");

        Person entity = mapper.convertVOToEntity(person);
        PersonVOV2 vo = mapper.convertEntityToVO(repository.save(entity));
//        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getId())).withSelfRel());
        return vo;
    }

    public PersonVO update(PersonVO person) {
        if (person == null) throw new RequiredObjectIsNullException();
        logger.info("Updating one person!");
        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        PersonVO vo = ModelMapper.parseObject(repository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getId())).withSelfRel());
        return vo;
    }

    public void delete(Long id){
        logger.info("Deleting one person!");
        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
        repository.delete(entity);
    }
}
