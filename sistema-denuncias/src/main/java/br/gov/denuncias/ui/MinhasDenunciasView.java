package br.gov.denuncias.ui;

import br.gov.denuncias.domain.Denuncia;
import br.gov.denuncias.domain.Usuario;
import br.gov.denuncias.repository.DenunciaRepository;
import br.gov.denuncias.repository.UsuarioRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@PageTitle("Minhas Denúncias")
@Route(value = "minhas-denuncias", layout = MainLayout.class)
public class MinhasDenunciasView extends VerticalLayout {
    public MinhasDenunciasView(DenunciaRepository denunciaRepo, UsuarioRepository usuarioRepo) {
        Usuario cidadao = usuarioRepo.findByEmail("cidadao@demo.local").orElse(null);
        List<Denuncia> data = cidadao == null ? List.of() : denunciaRepo.findByUsuarioOrderByCriadoEmDesc(cidadao);

        Grid<Denuncia> grid = new Grid<>(Denuncia.class, false);
        grid.addColumn(Denuncia::getId).setHeader("ID").setAutoWidth(true);
        grid.addColumn(Denuncia::getTitulo).setHeader("Título").setAutoWidth(true);
        grid.addColumn(Denuncia::getStatus).setHeader("Status").setAutoWidth(true);

        grid.setItems(data);
        add(grid);
        setSizeFull();
    }
}


