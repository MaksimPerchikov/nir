package ru.nir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nir.dto.CustomerDTO;
import ru.nir.dto.CustomerTaskDTO;
import ru.nir.exceptions.MyClassExceptions;
import ru.nir.model.Customer;
import ru.nir.model.Task;
import ru.nir.operations.CheckWord;
import ru.nir.repository.CustomerRepository;
import ru.nir.repository.TaskRepository;

import java.util.List;
import ru.nir.service.interfaceserv.MethodsInterface;

@Service
public class ServiceClass implements MethodsInterface {

    private final CustomerRepository customerRepository;
    private final TaskRepository taskRepository;
    private final MyClassExceptions myClassExceptions;
    private final CheckWord checkWord;

    @Autowired
    public ServiceClass(CustomerRepository customerRepository,
        TaskRepository taskRepository,
        MyClassExceptions myClassExceptions,
        CheckWord checkWord) {
        this.customerRepository = customerRepository;
        this.taskRepository = taskRepository;
        this.myClassExceptions = myClassExceptions;
        this.checkWord = checkWord;
    }

    @Override
    public List<Customer> showMeAllCustomers() {
        if (customerRepository.findAll().isEmpty()) {
            myClassExceptions.showMeThisException("Пользователей нет!", new Exception());
        }
        return customerRepository.findAll();
    }

    @Override
    public List<Task> showMeAllTasks() {
        if (taskRepository.findAll().isEmpty()) {
            myClassExceptions.showMeThisException("Задач нет!", new Exception());
        }
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        List<Task> listTask =
            taskRepository.findAll();

        if (listTask.isEmpty()) {
            myClassExceptions.showMeThisException("Задач нет, добавьте сначала задачу!",
                new RuntimeException());
        }
        Task task = new Task();
        if (id != null) {
            task = listTask.stream()
                .filter(element -> element.getId().equals(id))
                .findFirst()
                .orElse(null);
        }
        if (task == null) {
            myClassExceptions.showMeThisException("Задача с id " + id + " не найден.",
                new RuntimeException());
        }

        return task;

    }

    @Override
    public Customer getCustomerById(Long id) {
        List<Customer> customersList =
            customerRepository.findAll();
        if (customersList.isEmpty()) {
            myClassExceptions.showMeThisException("Пользователи не существуют!",
                new RuntimeException());
        }
        Customer customer = new Customer();
        if (id != null) {
            customer = customersList
                .stream()
                .filter(element -> element.getId().equals(id))
                .findFirst()
                .orElse(null);
        }
        if (customer == null) {
            myClassExceptions.showMeThisException("Пользователь с id " + id + " не найден.",
                new RuntimeException());
        }
        return customer;
    }

    @Override
    public Task addTask(CustomerTaskDTO taskDTO) {
        CheckWord<CustomerTaskDTO> check = new CheckWord<>(myClassExceptions);
        check.chekWordToString(taskDTO);
        //checkWord.chekWordToString(taskDTO);//тру,если содержит некрректные значения
        if (taskDTO.getNameTask() == null ||
            taskDTO.getText() == null ) {
            myClassExceptions.showMeThisException("Некорректное значение!",
                new RuntimeException());
        }
        Task task = new Task();
        task.setNameTask(taskDTO.getNameTask());
        task.setText(taskDTO.getText());
        taskRepository.save(task);
        return task;
    }

    @Override
    public Customer addCustomer(CustomerDTO customerDTO) {
        //boolean check = checkWord.chekWordToString(customerDTO);//тру,если содержит некрректные значения
        CheckWord<CustomerDTO> check = new CheckWord<>(myClassExceptions);
        check.chekWordToString(customerDTO);
        if (customerDTO.getFirstName() == null ||
            customerDTO.getSecondName() == null) {
            myClassExceptions.showMeThisException("Поле имени или фамилии не введено или введено некорректно!",
                new RuntimeException());
        }
        Customer customer = new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setSecondName(customerDTO.getSecondName());
        //TODO сделать дату создания пользователя
        return customer;
    }

    @Override
    public void removeTaskById(Long id) {
        List<Task> taskList =
            taskRepository.findAll();
        if(taskList.isEmpty()){
            myClassExceptions.showMeThisException("Пользователь с id " + id + " не найден.",
                new RuntimeException());
        }
        taskRepository.deleteById(id);
    }
}
