package br.com.mrzoom.restwithspringbootandjava.repository;

import br.com.mrzoom.restwithspringbootandjava.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
