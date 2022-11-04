package ru.nir.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.userdetails.User;
import ru.nir.model.Users;

public class RepositoryUsersInMemory {
    private static List<Users> newRepository = new ArrayList<>();

    static{
        Users users = new Users();
        users.setName("user");
        users.setPassword("password");
        users.setRole("USER");
        newRepository.add(users);
    }

    public List<Users> showAllUser(){
        return newRepository;
    }

    public Users roleChangeOnAdmin(){
        newRepository.get(0)
            .setRole("ADMIN");
        return newRepository.get(0);
    }
    public void roleChangeOnUser(){
        newRepository.get(0)
            .setRole("USER");
    }

}
