package ru.nir.repository;

import java.util.List;
import java.util.Optional;
import ru.nir.model.Task;

public interface NewRepositoryInMemoryInterface {
    List<Task> showAllValueNew();

    Task getTaskByIdServiceNew(Long id);
    Task getTaskByNameServiceNew(String name);

    Task addTaskServiceNew(Task task);

    void removeTaskByIdServiceNew(Long id);

    void removeTaskByFieldServiceNew(Task task);

}
