package ru.nir.service.interfaceserv;

import org.springframework.data.repository.query.Param;
import ru.nir.dto.CustomerDTO;
import ru.nir.dto.TaskDTO;
import ru.nir.model.Customer;
import ru.nir.model.Task;

import java.util.List;

public interface MethodsInterfaceByService {

    List<Customer> showMeAllCustomersService();
    List<Task> showMeAllTasksService();
    Task getTaskByIdService(Long id);
    Customer getCustomerByIdService(Long id);
    Task addTaskService(TaskDTO taskDTO);
    Task addTaskWithoutDTOService(Task task);
    Customer addCustomerService(CustomerDTO customerDTO);
    void removeTaskByIdService(Long id);
    void removeTaskByFieldService(TaskDTO taskDTO);


}
