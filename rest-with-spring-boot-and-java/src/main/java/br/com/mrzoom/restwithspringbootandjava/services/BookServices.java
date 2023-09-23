package br.com.mrzoom.restwithspringbootandjava.services;

import br.com.mrzoom.restwithspringbootandjava.controllers.BookController;
import br.com.mrzoom.restwithspringbootandjava.data.vo.v1.BookVO;
import br.com.mrzoom.restwithspringbootandjava.data.vo.v2.PersonVOV2;
import br.com.mrzoom.restwithspringbootandjava.exceptions.RequiredObjectIsNullException;
import br.com.mrzoom.restwithspringbootandjava.exceptions.ResourceNotFoundException;
import br.com.mrzoom.restwithspringbootandjava.mapper.ModelMapper;
import br.com.mrzoom.restwithspringbootandjava.mapper.custom.PersonMapper;
import br.com.mrzoom.restwithspringbootandjava.model.Book;
import br.com.mrzoom.restwithspringbootandjava.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookServices {

    private Logger logger = Logger.getLogger(BookServices.class.getName());

    @Autowired
    BookRepository repository;

    @Autowired
    PersonMapper mapper;

    public List<BookVO> findAll() {
        logger.info("Finding all books!");
        var books = ModelMapper.parseListObjects(repository.findAll(), BookVO.class);
        books
                .stream()
                .forEach(
                        p -> p.add(linkTo(methodOn(BookController.class).findById(p.getId())).withSelfRel())
                );
        return books;
    }

    public BookVO findById(Long id){
        logger.info("Finding one book!");
        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        BookVO vo = ModelMapper.parseObject(entity, BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return vo;
    }

    public BookVO create(BookVO book) {
        if (book == null) throw new RequiredObjectIsNullException();
        logger.info("Creating one book!");

        Book entity = ModelMapper.parseObject(book, Book.class);
        BookVO vo = ModelMapper.parseObject(repository.save(entity), BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getId())).withSelfRel());
        return vo;
    }

    public BookVO update(BookVO book) {
        if (book == null) throw new RequiredObjectIsNullException();
        logger.info("Updating one book!");
        Book entity = repository.findById(book.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));

        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());

        BookVO vo = ModelMapper.parseObject(repository.save(entity), BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getId())).withSelfRel());
        return vo;
    }

    public void delete(Long id){
        logger.info("Deleting one book!");
        Book entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
        repository.delete(entity);
    }
}
