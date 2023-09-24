package br.com.mrzoom.restwithspringbootandjava.services;

import br.com.mrzoom.restwithspringbootandjava.controllers.PersonController;
import br.com.mrzoom.restwithspringbootandjava.data.vo.v1.PersonVO;
import br.com.mrzoom.restwithspringbootandjava.exceptions.ResourceNotFoundException;
import br.com.mrzoom.restwithspringbootandjava.mapper.ModelMapper;
import br.com.mrzoom.restwithspringbootandjava.model.Person;
import br.com.mrzoom.restwithspringbootandjava.model.User;
import br.com.mrzoom.restwithspringbootandjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UserServices implements UserDetailsService {

    private Logger logger = Logger.getLogger(UserServices.class.getName());

    @Autowired
    UserRepository repository;

    public UserServices(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Finding one user by name " + username + "!");
        User user = repository.findByUsername(username);

        if (user != null){
            return user;
        }else {
            throw new UsernameNotFoundException("Username " + username + " not found!");
        }
    }
}
