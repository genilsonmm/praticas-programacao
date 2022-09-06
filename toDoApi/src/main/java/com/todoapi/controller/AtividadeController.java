package com.todoapi.controller;

import com.todoapi.entity.Atividade;
import com.todoapi.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("atividade")
public class AtividadeController {

    @Autowired
    private AtividadeRepository repository;

    @GetMapping
    public List<Atividade> get(){
        return repository.findAll();
    }
}
