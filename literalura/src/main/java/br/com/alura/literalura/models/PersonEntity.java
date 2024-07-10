package br.com.alura.literalura.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pessoas")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int anoDeNascimento;
    private int anoDeMorte;

//    @ManyToMany(cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BookEntity> livros = new ArrayList<>();

    public PersonEntity(){}

    public PersonEntity(PersonData personData){
        this.nome = personData.nome();
        this.anoDeNascimento = personData.anoDeNascimento().intValue();
        this.anoDeMorte = personData.anoDeMorte().intValue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Number getAnoDeNascimento() {
        return anoDeNascimento;
    }

    public void setAnoDeNascimento(int anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

    public Number getAnoDeMorte() {
        return anoDeMorte;
    }

    public void setAnoDeMorte(int anoDeMorte) {
        this.anoDeMorte = anoDeMorte;
    }

    public void setBooks(List<BookEntity> bookEntities)
    {
        this.livros = bookEntities;
    }

    public List<BookEntity> getBooks()
    {
        return this.livros;
    }

    @Override
    public String toString(){
        return this.nome;
    }

}
