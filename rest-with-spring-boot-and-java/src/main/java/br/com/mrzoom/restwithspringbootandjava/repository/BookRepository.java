package br.com.mrzoom.restwithspringbootandjava.repository;

import br.com.mrzoom.restwithspringbootandjava.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}
