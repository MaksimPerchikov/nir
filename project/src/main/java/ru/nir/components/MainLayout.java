package ru.nir.components;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import javax.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import ru.nir.security.SecurityService;
import com.vaadin.flow.component.applayout.*;
@Route("logout")
@PermitAll
public class MainLayout extends AppLayout {

    private SecurityService securityService;

    @Autowired
    public MainLayout(@Autowired SecurityService securityService) {
        this.securityService = securityService;

        H1 logo = new H1("Уже уходишь?");
        HorizontalLayout header;
        if (securityService.getAuthenticatedUser() != null) {
            Button logout = new Button("Выйти", click ->
                securityService.logout());
            header = new HorizontalLayout(logo, logout);
        } else {
            header = new HorizontalLayout(logo);
        }
        addToNavbar(header);
    }
}
