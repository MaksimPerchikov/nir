package ru.nir.view;

import com.vaadin.flow.router.Route;
import javax.annotation.security.RolesAllowed;

@RolesAllowed("ADMIN")
@Route("/")
public class TwoLoginView {

}
