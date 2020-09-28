package com.home.restspringboot.domain.builder;

import com.home.restspringboot.domain.Person;
import com.home.restspringboot.domain.dto.PersonDTO;

public class PessoaBuilder {

    public PersonDTO toPersonDTO(Person person){
        return PersonDTO.builder()
                .key(person.getId())
                .address(person.getAddress())
                .firstName(person.getFirstName())
                .gender(person.getGender())
                .lastName(person.getLastName())
                .build();
    }

    public Person toPerson(PersonDTO personDto){
        return Person.builder()
                .id(personDto.getKey())
                .address(personDto.getAddress())
                .firstName(personDto.getFirstName())
                .gender(personDto.getGender())
                .lastName(personDto.getLastName())
                .build();
    }

}
