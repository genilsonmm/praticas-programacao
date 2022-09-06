package com.todoapi;

import com.todoapi.entity.Atividade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoApiApplication {

    public static void main(String[] args) {

        Atividade atv = new Atividade();


        SpringApplication.run(ToDoApiApplication.class, args);
    }

}
