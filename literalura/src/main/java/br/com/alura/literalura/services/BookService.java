package br.com.alura.literalura.services;

import br.com.alura.literalura.models.BookEntity;
import br.com.alura.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookEntity> getAll() {
        return bookRepository.findAll();
    }

    public BookEntity save(BookEntity book) {
        BookEntity bookEntity = this.findByTitle(book.getTitulo());
        if (bookEntity.getId() > 0 ){
            return bookEntity;
        }
        else {
            return bookRepository.save(book);
        }
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public BookEntity findByTitle(String titulo){
        return bookRepository.findByTitle(titulo);
    }

    public List<BookEntity> findAllByLanguage(String language){
        return  bookRepository.findAllByLanguage(language);
    }

}
