package ru.nir.service.operationsOver;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.nir.dto.CustomerDTO;
import ru.nir.dto.TaskDTO;
import ru.nir.model.Customer;
import ru.nir.model.Task;
import ru.nir.repository.CustomerRepository;
import ru.nir.repository.TaskRepository;
import ru.nir.service.operationsOver.interfaces.OperationByOperationsWithRepository;

@Service
public class OperationsWithRepository implements OperationByOperationsWithRepository {

    private final CustomerRepository customerRepository;

    private final TaskRepository taskRepository;


    public OperationsWithRepository(CustomerRepository customerRepository,
        TaskRepository taskRepository){
        this.customerRepository = customerRepository;
        this.taskRepository = taskRepository;
    }


    @Override
    public List<Customer> showMeAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Task> showMeAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.getById(id);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.getById(id);
    }

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void removeTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}
