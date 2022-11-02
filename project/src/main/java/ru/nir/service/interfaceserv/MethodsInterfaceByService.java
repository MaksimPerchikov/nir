package ru.nir.service.interfaceserv;

import ru.nir.model.Task;

import java.util.List;

public interface MethodsInterfaceByService {

    List<Task> showMeAllTasksService();
    Task getTaskByIdService(Long id);
    Task addTaskService(Task task);
    void removeTaskByIdService(Long id);
    void removeTaskByFieldService(Task task);


}
