package com.tex.contextcache;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Todo {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    Integer id;
    String title;
    String quote;
}
