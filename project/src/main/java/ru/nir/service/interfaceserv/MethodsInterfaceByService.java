package ru.nir.service.interfaceserv;

import ru.nir.dto.CustomerDTO;
import ru.nir.dto.TaskDTO;
import ru.nir.model.Customer;
import ru.nir.model.Task;

import java.util.List;

public interface MethodsInterface {

    List<Customer> showMeAllCustomersService();
    List<Task> showMeAllTasksService();
    Task getTaskByIdService(Long id);
    Customer getCustomerByIdService(Long id);
    Task addTaskService(TaskDTO taskDTO);
    Customer addCustomerService(CustomerDTO customerDTO);
    void removeTaskByIdService(Long id);

}
