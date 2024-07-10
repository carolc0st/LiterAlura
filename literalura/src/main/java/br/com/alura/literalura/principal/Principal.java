package br.com.alura.literalura.principal;

import br.com.alura.literalura.models.BookData;
import br.com.alura.literalura.models.BookEntity;
import br.com.alura.literalura.models.GutendexResponse;
import br.com.alura.literalura.models.PersonEntity;
import br.com.alura.literalura.services.BookService;
import br.com.alura.literalura.services.GutendexApi;
import br.com.alura.literalura.services.PersonService;

import java.io.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);

    private BookService bookService;
    private PersonService personService;

    public Principal(BookService bookService, PersonService personService){
        this.bookService = bookService;
        this.personService = personService;
    }

    public void exibeMenu() {
        int opcao = -1;

        while (opcao != 0) {
            var menu = """
                            Escolha a número da sua opção:
                            1 -Buscar livro pelo título
                            2 -Listar livros registrados
                            3 -Listar autores registrados
                            4 -Listar autores vivos em um determinado ano
                            5 -Listar livros em um determinado idioma
                            0 -Sair
                            """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            escolhaMenu(opcao);
        }

    }

    private void escolhaMenu(int opcao) {
        switch (opcao){
            case 0:
                System.out.println("Saindo...");
                break;
            case 1:
                buscarLivroPeloTitulo();
                break;
            case 2:
                listarLivrosRegistrados();
                break;
            case 3:
                listarAutoresRegistrados();
                break;
            case 4:
                System.out.println("Digite o ano a ser pesquisado:");
                int ano = leitura.nextInt();
                ListarAutoresVivosNumDeterminadoAno(ano);
                leitura.nextLine();
                break;
            case 5:
                System.out.println("Digite o idioma a ser pesquisado:");
                String idioma = leitura.next();
                listarLivrosNoIdioma(idioma);
                leitura.nextLine();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void buscarLivroPeloTitulo()
    {
        System.out.println("Digite o nome do livro: ");
        var nomeLivro = leitura.nextLine();

        String nomeLivroFormatado = nomeLivro.replace(" ", "%20");

        GutendexApi gutendexApi = new GutendexApi();
        String metodo = "books/?search=" + nomeLivroFormatado;
        GutendexResponse resultado = gutendexApi.RequestApi(metodo);

        Arrays.stream(resultado.books).forEach(this::saveBook);

    }

    private void saveBook(BookData bookData)
    {
        System.out.println("SAVE::" + bookData);
        BookEntity bookEntity = new BookEntity(bookData);
        bookService.save(bookEntity);

        System.out.println(bookEntity);
    }

    private void listarLivrosRegistrados() {
        List<BookEntity> books = bookService.getAll();
        books.forEach(System.out::println);
    }

    private void listarAutoresRegistrados(){
        List<PersonEntity> persons = personService.getAll();
        persons.forEach(System.out::println);
    }

    private void ListarAutoresVivosNumDeterminadoAno(int ano){
        List<PersonEntity> persons = personService.getAllAlive(ano);
        persons.forEach(System.out::println);
    }

    private void listarLivrosNoIdioma(String idioma){
        List<BookEntity> books = bookService.findAllByLanguage(idioma);
        books.forEach(System.out::println);
    }
}
