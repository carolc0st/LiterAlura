package br.com.alura.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public record PersonData (
    @JsonAlias("birth_year") Number anoDeNascimento,
    @JsonAlias("death_year") Number anoDeMorte,
    @JsonAlias("name") String nome
){}
