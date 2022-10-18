package com.tex.contextcache;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Task {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    Integer id;
    @Enumerated
    Status status;
    String description;

    public enum Status {
        UNFINISHED,
        FINISHED
    }
}
