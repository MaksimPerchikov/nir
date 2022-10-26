package ru.nir.model;

import javax.persistence.GenerationType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@ToString
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameTask;

    private String text;


    public Task(Long id, String nameTask, String text) {
        this.id = id;
        this.nameTask = nameTask;
        this.text = text;
    }

    public Task(){}
    @Override
    public String toString() {
        return String.format("Task[id=%d, nameTask='%s', text='%s']", id,
            nameTask, text);
    }
}
