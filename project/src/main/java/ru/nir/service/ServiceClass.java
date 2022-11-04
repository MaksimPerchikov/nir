package ru.nir.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceClass extends NewRepositoryInMemory/* implements MethodsInterfaceByService */ {

    /*private final MyClassExceptions myClassExceptions;
    private final CheckWord checkWord;
    private final OperationsWithRepository operations

    @Autowired
    public ServiceClass(MyClassExceptions myClassExceptions,
        OperationsWithRepository operations,
        CheckWord checkWord) {
        this.myClassExceptions = myClassExceptions;
        this.operations = operations;
        this.checkWord = checkWord;
    }*/
/*
    @Override
    public List <Task> showAllValueNew() {
        return super.showAllValueNew();
    }

    @Override
    public Task getTaskByIdServiceNew(Long id) {
        return super.getTaskByIdServiceNew(id);
    }

    @Override
    public Task addTaskServiceNew(Task task) {
        return super.addTaskServiceNew(task);
    }

    @Override
    public void removeTaskByIdServiceNew(Long id) {
        super.removeTaskByIdServiceNew(id);
    }

    @Override
    public void removeTaskByFieldServiceNew(Task task) {
        super.removeTaskByFieldServiceNew(task);
    }*/



/*
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
    public Task getTaskByNameService(String name) {
        List<Task> listTask =
            operations.showMeAllTasks();

        if (listTask.isEmpty()) {
            myClassExceptions.showMeThisException("Задач нет, добавьте сначала задачу!",
                new RuntimeException());
        }
        Task task = new Task();
        if (name != null) {
            task = listTask.stream()
                .filter(element -> element.getNameTask().equals(name))
                .findFirst()
                .orElse(null);
        }
        if (task == null) {
            myClassExceptions.showMeThisException("Задача с name " + name + " не найдена.",
                new RuntimeException());
        }

        return task;

    }

    @Override//проверить, существует ли в базе такое значение
    public Task addTaskService(Task task) {

        //TODO checkWord доделать проверку орфографии
        //checkWord.chekWordToString(taskDTO);//тру,если содержит некрректные значения
        if (task.getNameTask() == null ||
            task.getText() == null) {
            myClassExceptions.showMeThisException("Некорректное значение!",
                new RuntimeException());
        }
        operations.addTask(task);
        return task;
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
    public void removeTaskByFieldService(Task task) {
        List<Task> taskList = operations.showMeAllTasks();
        Optional<Task> searchTask = taskList.stream()
            .filter(e -> e.getNameTask().equals(task.getNameTask()) && e.getText().equals(task.getText()))
            .findFirst();
        if (!searchTask.isEmpty()) {
            operations.removeTaskById(searchTask.get().getId());
        } else {
            myClassExceptions.showMeThisException("Такого таска не существует", new RuntimeException());
        }
    }*/
}
