package ru.nir.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.login.LoginI18n.Form;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.beans.factory.annotation.Autowired;

@Route("/greeting")
@AnonymousAllowed
@PageTitle("Greeting")
public class GreetingView extends VerticalLayout {

    private Button button = new Button();

    @Autowired
    public GreetingView() {
        Paragraph p = new Paragraph("para");
        button.setText("войти");
        Anchor a = new Anchor("http://localhost:8080/login", button);
        p.add(a);
        p.addClickListener(e-> UI.getCurrent().navigate(a.getHref()));
        add(new H1("Приветствую! Для продолжения нужно авторизоваться!"), a);

    }

}
