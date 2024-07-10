package br.com.alura.literalura.models;

import br.com.alura.literalura.repository.BookRepository;
import br.com.alura.literalura.services.ConverterDados;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.stream.Collectors;

@Entity
@Table(name = "livros")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Number numeroDeDownloads;

    private List<String> assuntos = new ArrayList<>();

//    @OneToMany(mappedBy = "livros", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PersonEntity autor;

    private List<String> idiomas = new ArrayList<>();

    public BookEntity() {
    }

    public BookEntity(BookData bookData){
        this.titulo = bookData.titulo();
        this.numeroDeDownloads = bookData.numeroDeDownloads();
        this.assuntos =  Arrays.asList(bookData.assuntos());
        this.idiomas =  Arrays.asList(bookData.idiomas());
        this.autor = new PersonEntity(Arrays.asList(bookData.autores()).get(0));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getAssuntos() {
        return assuntos;
    }

    public void setAssunto(List<String> assuntos) {
        this.assuntos = assuntos;
    }

    public Number getNumeroDeDownloads() {
        return numeroDeDownloads;
    }

    public void setNumeroDeDownloads(Number numeroDeDownloads) {
        this.numeroDeDownloads = numeroDeDownloads;
    }

    public PersonEntity getAutores() {
        return autor;
    }

    public void setAutores(PersonEntity personEntities) {
        this.autor = personEntities;
    }

    @Override
    public String toString(){
        return String.format("-----------------LIVRO-------------------------- \n Título: %s \n Autor: %s \n Idioma: %s \n Número de Downloads: %s \n-------------------------------------------------- ",
                titulo,
//                autores.stream().map(Object::toString).collect(Collectors.joining(", ")),
                autor,
                String.join(", ", idiomas),
                numeroDeDownloads.toString());

    }
}
