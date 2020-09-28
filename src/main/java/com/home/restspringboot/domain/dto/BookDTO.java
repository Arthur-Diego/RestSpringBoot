package com.home.restspringboot.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;

@Builder
@Setter
@Getter
@JsonPropertyOrder({ "id", "author", "launchDate", "price", "title" })
public class BookDTO extends RepresentationModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private Long key;
    private String author;
    private Date launchDate;
    private Double price;
    private String title;

}