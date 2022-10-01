package ru.nir.service.interfaceserv;

import ru.nir.dto.CustomerDTO;
import ru.nir.dto.CustomerTaskDTO;
import ru.nir.model.Customer;
import ru.nir.model.Task;

import java.util.List;

public interface MethodsInterface {

    List<Customer> showMeAllCustomers();
    List<Task> showMeAllTasks();
    Task getTaskById(Long id);
    Customer getCustomerById(Long id);
    Task addTask(CustomerTaskDTO taskDTO);
    Customer addCustomer(CustomerDTO customerDTO);
    void removeTaskById(Long id);

}
