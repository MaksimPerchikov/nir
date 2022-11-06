package ru.nir.view;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import javax.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import ru.nir.components.LinkMailEdit;

@Route("/linkMail")
@PageTitle("Link mail")
@PermitAll
public class LinkMail extends AppLayout {

    private final LinkMailEdit linkMailEdit;

    @Autowired
    public LinkMail(LinkMailEdit linkMailEdit){
        this.linkMailEdit = linkMailEdit;
        addToNavbar(linkMailEdit);
    }
}
