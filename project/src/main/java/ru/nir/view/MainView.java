package ru.nir.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import ru.nir.components.TaskEdit;
import ru.nir.dto.TaskDTO;
import ru.nir.model.Task;
import ru.nir.service.ServiceClass;

@Route
public class MainView extends VerticalLayout {

    private final ServiceClass serviceClass;

    private Grid<Task> gridTasks = new Grid<>(Task.class);
    private final TextField filter = new TextField(" ","Type to filter");
    private final Button buttonAddNew = new Button("Add new ");
    private final TaskEdit taskEdit;
    private final HorizontalLayout horizontalLayout = new HorizontalLayout(filter,buttonAddNew);

    @Autowired
    public MainView(ServiceClass serviceClass,TaskEdit edit){
        this.serviceClass = serviceClass;
        this.taskEdit = edit;
        add(horizontalLayout,gridTasks,edit);
        filter.setValueChangeMode(ValueChangeMode.EAGER);//фильтр обновляет статус после каждого нажатия кнопки
        filter.addValidationStatusChangeListener(e -> showAllTasks());

        /*gridTasks.asSingleSelect().addValueChangeListener(e-> {
            edit.editTask(e.g);
        })*/
        buttonAddNew.addClickListener(e -> taskEdit.editTask(new TaskDTO()));
        add(gridTasks);
        showAllTasks();

        edit.setChangeHandler(() -> {
            edit.setVisible(false);
            showAllTasks();
        });

    }
    public void showAllTasks() {
        serviceClass.showMeAllTasksService();
    }
}
