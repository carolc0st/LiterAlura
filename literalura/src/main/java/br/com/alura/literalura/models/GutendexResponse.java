package br.com.alura.literalura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonIgnoreProperties(ignoreUnknown=true)
public class GutendexResponse {
     @JsonProperty("count")
     public Number Quantidade;
//     String next;
//     String previous;
     @JsonProperty("results")
     public BookData[] books;
}

