package com.home.restspringboot.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@JsonPropertyOrder({
        "id",
        "firstName",
        "lastName",
        "address",
        "gender"})
@Builder
@Getter
@Setter
public class PersonDTO extends RepresentationModel implements Serializable {

    @JsonProperty("id")
    private Long key;

    private String firstName;

    private String lastName;

    private String address;

    private String gender;
}
