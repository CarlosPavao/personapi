package com.carlospavao.github.personapi.service;

import com.carlospavao.github.personapi.dto.MessageResponseDTO;
import com.carlospavao.github.personapi.entity.Person;
import com.carlospavao.github.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);

        return MessageResponseDTO
                .builder()
                .message("Create person with ID "+savedPerson.getId())
                .build();
    }



}
