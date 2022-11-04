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
import ru.nir.model.Task;
import ru.nir.service.NewRepositoryInMemory;

@SpringComponent
@UIScope
public class TaskEdit extends VerticalLayout implements KeyNotifier {

    private final NewRepositoryInMemory newRepositoryInMemory;

    private Task task;

    Binder<Task> binder = new Binder<>(Task.class);

    @Setter
    private ChangeHandler changeHandler;

    TextField nameTask = new TextField("Task name");
    TextField text = new TextField("Text");

    private final Button save = new Button("Save",VaadinIcon.CHECK.create());
    private final Button cancel = new Button("Cancel");
    private final Button delete = new Button("Delete",VaadinIcon.TRASH.create());
    private HorizontalLayout actions = new HorizontalLayout(save,cancel,delete);

    public interface ChangeHandler{
        void onChange();
    }

    @Autowired
    public TaskEdit(NewRepositoryInMemory newRepositoryInMemory){
        this.newRepositoryInMemory = newRepositoryInMemory;
        add(nameTask,text,actions);
        binder.bindInstanceFields(this);
        setSpacing(true);//добавляет интервалы между филдами

        //берутся кнопочки, берутся их темы и добавляются маркеры(короч изменится внешний вид)
        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");

        addKeyPressListener(Key.ENTER, e-> save());//слушает, что будет на энтр выполняться

        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editTask(task));
        setVisible(false);//сделай формочку невидимой

    }
    private void save(){
        newRepositoryInMemory.addTaskServiceNew(task);
        changeHandler.onChange();
    }
    private void delete(){
        newRepositoryInMemory.removeTaskByFieldServiceNew(task);
        changeHandler.onChange();
    }

    public void editTask(Task newTask){
        if (newTask == null){
            setVisible(false);//формочка становится невидимая
            return;
        }
        if(newTask.getId() != null){
            this.task = newRepositoryInMemory.getTaskByIdServiceNew(newTask.getId());
        }else {
            task = newTask;
        }
        binder.setBean(this.task);
        setVisible(true);
        text.focus();
    }

}
