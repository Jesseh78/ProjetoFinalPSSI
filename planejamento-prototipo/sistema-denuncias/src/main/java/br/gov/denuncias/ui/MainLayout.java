package br.gov.denuncias.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {
    public MainLayout() {
        H1 title = new H1("Sistema de Denúncias");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)").set("margin", "0 1rem");

        addToNavbar(title, new RouterLink("Abrir Denúncia", AbrirDenunciaView.class),
                new RouterLink("Minhas Denúncias", MinhasDenunciasView.class));
    }
}


