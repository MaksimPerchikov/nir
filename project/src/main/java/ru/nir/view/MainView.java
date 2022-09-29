package ru.nir.view;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import ru.nir.model.Task;
import ru.nir.repository.TaskRepository;

//@Route
public class MainView extends VerticalLayout {

    /*private final TaskRepository taskRepository;

    private Grid<Task> grid = new Grid<>(Task.class);

    @Autowired
    public MainView(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
        add(grid);

        grid.setItems(taskRepository.findAll());
    }*/



}
