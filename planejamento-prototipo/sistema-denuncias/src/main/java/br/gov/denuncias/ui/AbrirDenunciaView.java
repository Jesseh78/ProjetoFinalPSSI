package br.gov.denuncias.ui;

import br.gov.denuncias.domain.Denuncia;
import br.gov.denuncias.domain.Usuario;
import br.gov.denuncias.repository.DenunciaRepository;
import br.gov.denuncias.repository.UsuarioRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.data.binder.Binder;

@PageTitle("Abrir Denúncia")
@Route(value = "", layout = MainLayout.class)
public class AbrirDenunciaView extends VerticalLayout {
    private final Binder<Denuncia> binder = new Binder<>(Denuncia.class);

    public AbrirDenunciaView(DenunciaRepository denunciaRepo, UsuarioRepository usuarioRepo) {
        TextField titulo = new TextField("Título");
        TextArea descricao = new TextArea("Descrição");
        TextField endereco = new TextField("Endereço (opcional)");
        Button salvar = new Button("Enviar");

        titulo.setRequired(true);
        descricao.setRequired(true);
        descricao.setHeight("150px");

        binder.forField(titulo).asRequired("Informe o título").bind(Denuncia::getTitulo, Denuncia::setTitulo);
        binder.forField(descricao).asRequired("Informe a descrição").bind(Denuncia::getDescricao, Denuncia::setDescricao);
        binder.forField(endereco).bind(Denuncia::getEndereco, Denuncia::setEndereco);

        salvar.addClickListener(e -> {
            Denuncia d = new Denuncia();
            if (binder.writeBeanIfValid(d)) {
                Usuario cidadao = usuarioRepo.findByEmail("cidadao@demo.local")
                        .orElseGet(() -> {
                            Usuario u = new Usuario();
                            u.setNome("Cidadão Demo");
                            u.setEmail("cidadao@demo.local");
                            u.setSenhaHash("{noop}demo");
                            return usuarioRepo.save(u);
                        });
                d.setUsuario(cidadao);
                denunciaRepo.save(d);
                Notification.show("Denúncia enviada com sucesso.", 3000, Notification.Position.MIDDLE);
                binder.readBean(new Denuncia());
            }
        });

        FormLayout form = new FormLayout(titulo, descricao, endereco, salvar);
        add(form);
        setWidthFull();
    }
}


