package ru.nir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nir.dto.CustomerDTO;
import ru.nir.dto.CustomerTaskDTO;
import ru.nir.model.Customer;
import ru.nir.model.Task;
import ru.nir.service.ServiceClass;

import java.util.List;

@RestController
public class CustomerTaskController {

    private final ServiceClass serviceClass;

    @Autowired
    public CustomerTaskController(ServiceClass serviceClass){
        this.serviceClass = serviceClass;
    }

    //получить всех пользоавтелей
    //@GetMapping("/customers")
    public List<Customer> showAllCustomers(){
        return serviceClass.showMeAllCustomers();
    }

    //получить все задачи
    //@GetMapping("/tasks")
    public List<Task> showAllTasks(){
        return serviceClass.showMeAllTasks();
    }

    //найти задачу пой айди
    //@GetMapping("task/{id}")
    public Task showTaskById(@PathVariable("id") Long id){
        return serviceClass.getTaskById(id);
    }

    //найти пользователя по айди
    //@GetMapping("customer/{id}")
    public Customer showCustomerById(@PathVariable("id") Long id){
        return serviceClass.getCustomerById(id);
    }

    //добавить задачу
    //@PostMapping("/task")
    public Task addTaskMethod(@RequestBody CustomerTaskDTO taskDTO){
        return serviceClass.addTask(taskDTO);
    }

    //добавить пользователя
    //@PostMapping("/customer")
    public Customer addCustomerMethod(@RequestBody CustomerDTO customerDTO){
        return serviceClass.addCustomer(customerDTO);
    }

    //удалить задачу по айди
    //@DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable("id") Long id){
        serviceClass.removeTaskById(id);
    }

}
