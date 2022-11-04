package ru.nir.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Repository;
import ru.nir.model.Task;
import ru.nir.repository.NewRepositoryInMemoryInterface;

public class NewRepositoryInMemory implements NewRepositoryInMemoryInterface {

    private List<Task> newRepository = new ArrayList<>();

    public List<Task> showAllValueNew() {
        return newRepository;
    }

    public Task getTaskByIdServiceNew(Long id) {
        Optional<Task> optionalTask = newRepository.stream()
            .filter(e -> e.getId().equals(id))
            .findFirst();
        return optionalTask.get();
    }
    public Task getTaskByNameServiceNew(String name) {
        Optional<Task> optionalTask = newRepository.stream()
            .filter(e -> e.getNameTask().equals(name))
            .findFirst();
        return optionalTask.get();
    }

    public Task addTaskServiceNew(Task task) {
        Random random = new Random();
        long id = random.nextLong();
        List<Task> list = showAllValueNew();
        Optional<Task> optionalTask = list.stream()
                .filter(e -> e.getId().equals(id))
                    .findFirst();
        if(optionalTask.isPresent()){
            long idNew = random.nextLong();
            long idResult = id + idNew;
            task.setId(idResult);
        }else task.setId(id);
        newRepository.add(task);
        return task;

    }

    public void removeTaskByIdServiceNew(Long id) {

    }

    public void removeTaskByFieldServiceNew(Task task) {
        Optional<Task> result = newRepository.stream()
            .filter(e ->e.getNameTask().equals(task.getNameTask()))
            .findFirst();
        newRepository.remove(result.get());
    }

}
