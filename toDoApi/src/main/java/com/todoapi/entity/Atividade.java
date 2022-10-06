package com.todoapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
//@Table(name = "atividade")
public class Atividade {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(name = "finalizada", nullable = false)
    private boolean feita;
}
