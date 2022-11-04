package ru.nir.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import ru.nir.components.TwoLoginEdit;
@Route("/")
@PageTitle("Two login")
@PermitAll
public class TwoLoginView extends AppLayout {

    private final TwoLoginEdit twoLoginEdit;

    private Button sendEmail = new Button("Enter");

    @Autowired
    public TwoLoginView(TwoLoginEdit twoLoginEdit) {
        this.twoLoginEdit = twoLoginEdit;
        addToNavbar(new H1("Второй этап авторизации."), twoLoginEdit);
    }

}
