package ru.nir.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nir.dto.CustomerDTO;
import ru.nir.dto.TaskDTO;
import ru.nir.model.Customer;
import ru.nir.model.Task;
import ru.nir.service.ServiceClass;

@RestController
@RequestMapping("/api")
public class CustomerTaskController {

    private final ServiceClass serviceClass;

    @Autowired
    public CustomerTaskController(ServiceClass serviceClass){
        this.serviceClass = serviceClass;
    }

    //получить всех пользоавтелей
    @GetMapping("/customers")
    public List<Customer> showAllCustomers(){
        return serviceClass.showMeAllCustomersService();
    }

    //получить все задачи
    @GetMapping("/tasks")
    public List<Task> showAllTasks(){
        return serviceClass.showMeAllTasksService();
    }

    //найти задачу пой айди
    @GetMapping("/task/{id}")
    public Task showTaskById(@PathVariable("id") Long id){
        return serviceClass.getTaskByIdService(id);
    }

    //найти пользователя по айди
    @GetMapping("/customer/{id}")
    public Customer showCustomerById(@PathVariable("id") Long id){
        return serviceClass.getCustomerByIdService(id);
    }

    //добавить задачу
    @PostMapping("/task")
    public Task addTaskMethod(@RequestBody TaskDTO taskDTO){
        return serviceClass.addTaskService(taskDTO);
    }

    //добавить пользователя
    @PostMapping("/customer")
    public Customer addCustomerMethod(@RequestBody CustomerDTO customerDTO){
        return serviceClass.addCustomerService(customerDTO);
    }

    //удалить задачу по айди
    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable("id") Long id){
        serviceClass.removeTaskByIdService(id);
    }

    @DeleteMapping("/delete")
    public void deleteTaskByField(@RequestBody TaskDTO taskDTO){
        serviceClass.removeTaskByFieldService(taskDTO);
    }


    /*@GetMapping(value = "/hi")
    public String calcul(){
        return serviceClass.hiMethod();
    }

    @GetMapping("/")
    public String restricted(){
        return "to see this text you need to be logged in!";
    }*/
}
