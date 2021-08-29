package com.carlospavao.github.personapi.service;

import com.carlospavao.github.personapi.dto.MessageResponseDTO;
import com.carlospavao.github.personapi.dto.request.PersonDTO;
import com.carlospavao.github.personapi.entity.Person;
import com.carlospavao.github.personapi.mapper.PersonMapper;
import com.carlospavao.github.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {

        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO
                .builder()
                .message("Create person with ID "+savedPerson.getId())
                .build();
    }



}
