package br.gov.denuncias.repository;

import br.gov.denuncias.domain.Denuncia;
import br.gov.denuncias.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {
    List<Denuncia> findByUsuarioOrderByCriadoEmDesc(Usuario usuario);
}


