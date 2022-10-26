package ru.nir.service.operationsOverDb;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.nir.model.Customer;
import ru.nir.model.Task;
import ru.nir.repository.CustomerRepository;
import ru.nir.repository.TaskRepository;
import ru.nir.service.operationsOverDb.interfaces.OperationByOperationsWithRepository;

@Service
public class OperationsWithRepository implements OperationByOperationsWithRepository {

    private CustomerRepository customerRepository;

    private TaskRepository taskRepository;

    @Autowired
    public OperationsWithRepository(
        CustomerRepository customerRepository,
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
