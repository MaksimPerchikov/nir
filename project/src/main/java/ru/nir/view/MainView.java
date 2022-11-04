package ru.nir.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nir.components.TaskEdit;
import ru.nir.model.Task;
import ru.nir.repository.RepositoryUsersInMemory;
import ru.nir.service.NewRepositoryInMemory;
@Route("/main")
@AnonymousAllowed
public class MainView extends VerticalLayout {

    private final NewRepositoryInMemory newRepositoryInMemory;
    final Grid<Task> grid;
    private final TextField filter = new TextField(" ","Type to filter");
    private final Button buttonAddNew = new Button("Add new ");
    private final HorizontalLayout toolbar = new HorizontalLayout(filter,buttonAddNew);
    private final TaskEdit editor;
    private Button button = new Button();
    private final RepositoryUsersInMemory repositoryUsersInMemory;

    @Autowired
    public MainView(NewRepositoryInMemory newRepositoryInMemory,
        TaskEdit editor,RepositoryUsersInMemory repositoryUsersInMemory) {
        this.grid = new Grid<>(Task.class);
        this.newRepositoryInMemory = newRepositoryInMemory;
        this.editor = editor;
        this.repositoryUsersInMemory = repositoryUsersInMemory;
        add(toolbar,grid,editor);

        filter.setValueChangeMode(ValueChangeMode.EAGER);//фильтр обновляет статус после каждого нажатия кнопки
        filter.addValueChangeListener(e -> showTask(e.getValue()));

        grid.asSingleSelect().addValueChangeListener(e-> {
            editor.editTask(e.getValue());
        });
        buttonAddNew.addClickListener(e ->editor.editTask(new Task()));
        editor.setChangeHandler(()-> {
            editor.setVisible(false);
            showTask(filter.getValue());
        });
        Paragraph p = new Paragraph("para");
        button.setText("Выйти");
        Anchor a = new Anchor("http://localhost:8080/logout", button);
        repositoryUsersInMemory.roleChangeOnUser();
        p.add(a);
        p.addClickListener(e-> UI.getCurrent().navigate(a.getHref()));
        add(a);

        showTask("");
    }

    private void showTask(String name) {
        if(name.isEmpty()){
            grid.setItems(newRepositoryInMemory.showAllValueNew());
        }else {
            grid.setItems(newRepositoryInMemory.getTaskByNameServiceNew(name));
        }

    }
}
