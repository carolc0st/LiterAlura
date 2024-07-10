package br.com.alura.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)

public record BookData (
    @JsonAlias("id") Number id,
    @JsonAlias("title") String titulo,
    @JsonAlias("subjects") String[] assuntos,
    @JsonAlias("authors") PersonData[] autores,
    @JsonAlias("languages") String[] idiomas,
    @JsonAlias("download_count")Number numeroDeDownloads
//    @JsonProperty("translators")
//    Person[] translators,
//    @JsonProperty("bookshelves")
//    String[] bookshelves,

//    @JsonProperty("copyright")
//    boolean copyright,
//    @JsonProperty("media_type")
//    String media_type,
    //    @JsonProperty("formats")
//    Format formats;

){

}