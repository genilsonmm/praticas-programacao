package com.todoapi.controller;

import com.todoapi.entity.Atividade;
import com.todoapi.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("atividade")
public class AtividadeController {

    @Autowired
    private AtividadeRepository repository;

    @GetMapping
    public ResponseEntity get(){
        //return new ResponseEntity(repository.findAll(), HttpStatus.OK);
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable long id){
        Optional<Atividade> optional = repository.findById(id);

        if(optional.isPresent()){
            Atividade atividade = optional.get();
            return ResponseEntity.ok(atividade);
        }

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Atividade atividade){
        try {
            atividade.setFeita(false);
            return new ResponseEntity(repository.save(atividade), HttpStatus.CREATED);
        } catch (Exception error){
            return new ResponseEntity("Não foi possível cadastrar à atividade",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity put(@RequestBody Atividade atividade){
        try {
            var optional = repository.findById(atividade.getId());

            if(optional.isPresent()) {
                return new ResponseEntity(repository.save(atividade), HttpStatus.OK);
            }

            return new ResponseEntity("Atividade inválida!", HttpStatus.NO_CONTENT);

        } catch (Exception error) {
            return new ResponseEntity("Não foi possível editar à atividade",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable long id){
        try {
            repository.deleteById(id);
            return ResponseEntity.ok("Atividade removida com sucesso!");
        }catch (EmptyResultDataAccessException error){
            return new ResponseEntity("Não existe atividade com o id: " + id,
                    HttpStatus.BAD_REQUEST);
        } catch (Exception error){
            return new ResponseEntity("Não foi possível remover à atividade!",
                    HttpStatus.BAD_REQUEST);
        }
    }
}
