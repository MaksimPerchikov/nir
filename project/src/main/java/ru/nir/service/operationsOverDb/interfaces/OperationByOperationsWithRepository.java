package ru.nir.service.operationsOverDb.interfaces;

import java.util.List;
import ru.nir.model.Task;

public interface OperationByOperationsWithRepository {

    List<Task> showMeAllTasks();
    Task getTaskById(Long id);
    Task addTask(Task task);
    void removeTaskById(Long id);

}
