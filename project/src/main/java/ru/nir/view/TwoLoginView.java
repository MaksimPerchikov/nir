package ru.nir.view;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import javax.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import ru.nir.components.TwoLoginEdit;
@Route("/")
@PageTitle("Two login")
@PermitAll
public class TwoLoginView extends AppLayout {

    private final TwoLoginEdit twoLoginEdit;

    @Autowired
    public TwoLoginView(TwoLoginEdit twoLoginEdit) {
        this.twoLoginEdit = twoLoginEdit;
        addToNavbar(new H1("Второй этап авторизации."), twoLoginEdit);
    }

}
