package ru.nir.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Users {

    private Long id;
    private String name;
    private String password;
    private String role;

}
