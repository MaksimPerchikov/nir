package ru.nir.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nir.dto.CustomerDTO;
import ru.nir.dto.TaskDTO;
import ru.nir.exceptions.MyClassExceptions;
import ru.nir.model.Customer;
import ru.nir.model.Task;

import java.util.List;
import ru.nir.operations.CheckWord;
import ru.nir.service.interfaceserv.MethodsInterfaceByService;
import ru.nir.service.operationsOverDb.OperationsWithRepository;

@Service
public class ServiceClass implements MethodsInterfaceByService {

    private final MyClassExceptions myClassExceptions;
    private final CheckWord checkWord;

    private final OperationsWithRepository operations;

    @Autowired
    public ServiceClass(MyClassExceptions myClassExceptions,
        OperationsWithRepository operations,
        CheckWord checkWord) {
        this.myClassExceptions = myClassExceptions;
        this.operations = operations;
        this.checkWord = checkWord;
    }


    @Override
    public List<Customer> showMeAllCustomersService() {
        if (operations.showMeAllCustomers().isEmpty()) {
            myClassExceptions.showMeThisException("Пользователей нет!", new Exception());
            //log.info("My some text.");
        }
        return operations.showMeAllCustomers();
    }

    @Override
    public List<Task> showMeAllTasksService() {
        if (operations.showMeAllTasks().isEmpty()) {
            myClassExceptions.showMeThisException("Задач нет!", new Exception());
        }
        return operations.showMeAllTasks();
    }

    @Override
    public Task getTaskByIdService(Long id) {
        List<Task> listTask =
            operations.showMeAllTasks();

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
    public Customer getCustomerByIdService(Long id) {
        List<Customer> customersList =
            operations.showMeAllCustomers();
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

    @Override//проверить, существует ли в базе такое значение
    public Task addTaskService(TaskDTO taskDTO) {

      /*  boolean resultCheck =
            checkWord.checkWordToString(myClassExceptions, taskDTO.getNameTask(), taskDTO.getText());
        if (resultCheck) {*/

        //TODO checkWord доделать проверку орфографии
        //checkWord.chekWordToString(taskDTO);//тру,если содержит некрректные значения
        if (taskDTO.getNameTask() == null ||
            taskDTO.getText() == null) {
            myClassExceptions.showMeThisException("Некорректное значение!",
                new RuntimeException());
        }
        Task task = new Task();
        task.setNameTask(taskDTO.getNameTask());
        task.setText(taskDTO.getText());
        operations.addTask(task);
        return task;
   // }
     //   return null;

}

    @Override
    public Task addTaskWithoutDTOService(Task task) {
        /*CheckWord<TaskDTO> check = new CheckWord<>(myClassExceptions);
        check.chekWordToString(taskDTO);*/
        //TODO checkWord доделать проверку орфографии
        //checkWord.chekWordToString(taskDTO);//тру,если содержит некрректные значения
        if (task.getNameTask() == null ||
            task.getText() == null) {
            myClassExceptions.showMeThisException("Некорректное значение!",
                new RuntimeException());
        }
        ;
        operations.addTask(task);
        return task;
    }

    @Override
    public Customer addCustomerService(CustomerDTO customerDTO) {
        //boolean check = checkWord.chekWordToString(customerDTO);//тру,если содержит некрректные значения
        // CheckWord<CustomerDTO> check = new CheckWord<>(myClassExceptions);
        // check.chekWordToString(customerDTO);
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
    public void removeTaskByIdService(Long id) {
        List<Task> taskList =
            operations.showMeAllTasks();
        //TODO дописать, сначала нужно найти пользователя, и если его не существует - выдать ошибку, иначе - удалить
        if (taskList.isEmpty()) {
            myClassExceptions.showMeThisException("Задания с id " + id + " не найден.",
                new RuntimeException());
        }
        operations.removeTaskById(id);
    }

    @Override
    public void removeTaskByFieldService(TaskDTO taskDTO) {
        List<Task> taskList = operations.showMeAllTasks();
        Optional<Task> searchTask = taskList.stream()
            .filter(e -> e.getNameTask().equals(taskDTO.getNameTask()) && e.getText().equals(taskDTO.getText()))
            .findFirst();
        if(!searchTask.isEmpty()){
            operations.removeTaskById(searchTask.get().getId());
        }else {
            myClassExceptions.showMeThisException("Такого таска не существует",new RuntimeException());
        }
    }
}
