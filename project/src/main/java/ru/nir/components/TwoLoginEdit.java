package ru.nir.components;

import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import java.util.concurrent.TimeUnit;
import javax.mail.MessagingException;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import ru.nir.gmail.EmailSender;
import ru.nir.repository.RepositoryUsersInMemory;

@SpringComponent
@UIScope
public class TwoLoginEdit extends VerticalLayout implements KeyNotifier {


    private Binder<String> binder = new Binder<>(String.class);
    private String someText;
    private final RepositoryUsersInMemory repositoryUsersInMemory;

    @Setter
    private ChangeHandler changeHandler;
    private Button sendEmail = new Button("Send email");
    TextField code = new TextField("Code with mess");
    private Button check = new Button("Check code");
    private Button linkMail = new Button("Link mail.");



    public interface ChangeHandler {
        void onChange();
    }

    private final EmailSender emailSender;

    @Autowired
    public TwoLoginEdit(RepositoryUsersInMemory repositoryUsersInMemory,EmailSender emailSender) {
        this.repositoryUsersInMemory = repositoryUsersInMemory;
        this.emailSender = emailSender;
        add(sendEmail, code, check,linkMail);

        sendEmail.addClickListener(e -> {

            if(repositoryUsersInMemory.getEmail().equals("")){
                Notification notification = Notification.show("К вашему аккаунту не привязана почта");
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            }else {
                enterMethod(repositoryUsersInMemory.getEmail());
                Notification notification = Notification.show("На вашу почту отправлен код, проверьте почту.");
                notification.addThemeVariants(NotificationVariant.LUMO_PRIMARY);
            }
        });

        check.addClickListener(e -> {
            try {
                checkCode(code.getValue());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        linkMail.addClickListener(e -> {
            getUI().get().getPage().open("http://localhost:8080/linkMail");
        });

    }

    public void enterMethod(String email) {
        try {
            emailSender.sendEmailMain(email);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void checkCode(String code) throws InterruptedException {
        if (emailSender.getIntCode().toString().equals(code)) {
            Notification notification = Notification
                .show("Доступ получен!");
            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            TimeUnit.SECONDS.sleep(
                5
            );
            getUI().get().getPage().open("http://localhost:8080/main");
        }else {
            Notification notification = Notification
                .show("Код неверный, попробуйте снова.");
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        }
    }
}

