package com.carlospavao.github.personapi.controller;

import com.carlospavao.github.personapi.dto.MessageResponseDTO;
import com.carlospavao.github.personapi.entity.Person;
import com.carlospavao.github.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);

        return MessageResponseDTO
                .builder()
                .message("Create person with ID "+savedPerson.getId())
                .build();
    }
}
