package ru.nir.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nir.model.Task;
import ru.nir.service.ServiceClass;

@RestController
@RequestMapping("/api")
public class TaskController {

    private final ServiceClass serviceClass;

    @Autowired
    public TaskController(ServiceClass serviceClass){
        this.serviceClass = serviceClass;
    }

    //получить все задачи
    @GetMapping("/tasks")
    public List<Task> showAllTasks(){
        return serviceClass.showAllValueNew();
    }

    //найти задачу пой айди
    @GetMapping("/task/{id}")
    public Task showTaskById(@PathVariable("id") Long id){
        return serviceClass.getTaskByIdServiceNew(id);
    }


    //добавить задачу
    @PostMapping("/task")
    public Task addTaskMethod(@RequestBody Task task){
        return serviceClass.addTaskServiceNew(task);
    }


    //удалить задачу по айди
    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable("id") Long id){
        serviceClass.removeTaskByIdServiceNew(id);
    }

    @DeleteMapping("/delete")
    public void deleteTaskByField(@RequestBody Task task){
        serviceClass.removeTaskByFieldServiceNew(task);
    }

}
