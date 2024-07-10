package br.com.alura.literalura.services;

import br.com.alura.literalura.models.PersonEntity;
import br.com.alura.literalura.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonEntity> getAll() {
        return personRepository.findAll();
    }

    public PersonEntity save(PersonEntity person) {
        PersonEntity personEntity = this.findByName(person.getNome());
        if (personEntity.getId() > 0 && person.getAnoDeNascimento().equals(personEntity.getAnoDeNascimento())){
            return personEntity;
        }
        else {
            return personRepository.save(person);
        }
    }

    public PersonEntity findByName(String name){
        return personRepository.findyByName(name);
    }

    public List<PersonEntity> getAllAlive(int dateBirth){
        return personRepository.getAllAlive(dateBirth);
    }
}
