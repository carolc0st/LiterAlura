package br.com.alura.literalura.repository;

import br.com.alura.literalura.models.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    @Query("SELECT b FROM Livros b WHERE b.titulo = ?1")
    BookEntity findByTitle(String titulo);

    @Query("SELECT b FROM Livros b WHERE b.idiomas LIKE CONCAT('%',:language,'%')")
    List<BookEntity> findAllByLanguage(@Param("language") String language);
}
