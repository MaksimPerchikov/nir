package ru.nir.service.operationsOver.interfaces;

import java.util.List;
import ru.nir.dto.CustomerDTO;
import ru.nir.dto.TaskDTO;
import ru.nir.model.Customer;
import ru.nir.model.Task;

public interface OperationByOperationsWithRepository {

    List<Customer> showMeAllCustomers();
    List<Task> showMeAllTasks();
    Task getTaskById(Long id);
    Customer getCustomerById(Long id);
    Task addTask(Task task);
    Customer addCustomer(Customer customer);
    void removeTaskById(Long id);

}
