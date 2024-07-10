package br.com.alura.literalura.repository;

import br.com.alura.literalura.models.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    @Query("SELECT b FROM Pessoas b WHERE b.nome = ?1")
    PersonEntity findyByName(String name);

    @Query("SELECT b FROM Pessoas b WHERE b.ano_de_nascimento >= ?1 AND b.ano_de_morte <= ?1")
    List<PersonEntity> getAllAlive(int dateBirth);
}
