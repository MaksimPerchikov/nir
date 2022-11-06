package ru.nir.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import javax.mail.MessagingException;
import ru.nir.gmail.EmailSender;
import ru.nir.repository.RepositoryUsersInMemory;

@SpringComponent
@UIScope
public class LinkMailEdit extends VerticalLayout {

    TextField yourEmail = new TextField("your email");
    private Button saveEmail = new Button("Save email");
    private Button back = new Button("Back");

    private final RepositoryUsersInMemory repositoryUsersInMemory;
    private final EmailSender emailSender;

    public LinkMailEdit(RepositoryUsersInMemory repositoryUsersInMemory,
        EmailSender emailSender) {
        this.repositoryUsersInMemory = repositoryUsersInMemory;
        this.emailSender = emailSender;
        add(yourEmail, saveEmail, back);
        saveEmail.addClickListener(e -> {
            enterMethod(yourEmail.getValue());
        });

        back.addClickListener(e -> {
            getUI().get().getPage().open("http://localhost:8080/");
        });




    }

    public void enterMethod(String email) {
        repositoryUsersInMemory.saveEmailInUser(email);
        Notification notification = Notification
            .show("Почта присоединена к вашему аккаунту.");
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    }
}

