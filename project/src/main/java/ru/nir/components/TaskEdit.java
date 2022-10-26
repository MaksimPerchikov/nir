package ru.nir.components;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import ru.nir.dto.TaskDTO;
import ru.nir.model.Task;
import ru.nir.service.ServiceClass;

@SpringComponent
@UIScope
public class TaskEdit extends VerticalLayout implements KeyNotifier {

    private final ServiceClass service;

    private TaskDTO taskDTO;

    Binder<TaskDTO> binder = new Binder<>(TaskDTO.class);
    @Setter
    private ChangeHandler changeHandler;

    TextField nameTask = new TextField("Task name");
    TextField text = new TextField("Text");

    private Button save = new Button("Save",VaadinIcon.CHECK.create());
    private Button cancel = new Button("Cancel");
    private Button delete = new Button("Delete",VaadinIcon.TRASH.create());
    private HorizontalLayout actions = new HorizontalLayout(save,cancel,delete);

    private Binder<TaskDTO> taskBinder = new Binder<>(TaskDTO.class);
    public interface ChangeHandler{
        void onChange();
    }

    @Autowired
    public TaskEdit(ServiceClass service){
        this.service = service;
        add(nameTask, text,actions);
        binder.bindInstanceFields(this);
        setSpacing(true);//добавляет интервалы между филдами

        //берутся кнопочки, берутся их темы и добавляются маркеры(короч изменится внешний вид)
        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");

        addKeyPressListener(Key.ENTER, e-> save());//слушает, что будет на энтр выполняться

        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editTask(taskDTO));
        setVisible(false);//сделай формочку невидимой

    }
    private void save(){
        service.addTaskService(taskDTO);
        changeHandler.onChange();
    }
    private void delete(){
        service.removeTaskByFieldService(taskDTO);
        changeHandler.onChange();
    }

    public void editTask(TaskDTO taskDTO){
        if (taskDTO == null){
            setVisible(false);//формочка становится невидимая
            return;
        }
       binder.setBean(taskDTO);
        setVisible(true);
        text.focus();
    }

}
