package br.com.cesjf.trabalhomobile.Repository;

import br.com.cesjf.trabalhomobile.Model.Compartilhamento;
import br.com.cesjf.trabalhomobile.Model.Dto.RecebidoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CompartilhamentoRepository extends JpaRepository<Compartilhamento, Long> {

    @Query("select new br.com.cesjf.trabalhomobile.Model.Dto.RecebidoDto"
            + "(c.usuarioEnvio.id, u.nomeCompleto, c.dataOperação, h.id, h.idApi, h.nome, h.alterEgo, h.urlImagem, s.altura, s.peso, s.inteligencia, s.forca, s.velocidade, s.resistencia, s.poder, s.combate) "
            + "from Compartilhamento c "
            + "inner join Heroi h "
            + "on c.heroi.id = h.id "
            + "inner join Status s "
            + "on s.id = h.status.id "
            + "inner join Usuario u "
            + "on u.id = c.usuarioEnvio.id "
            + "where c.usuarioRecebimento.id = :usuarioId "
            + "order by c.dataOperação desc"
    )
    List<RecebidoDto> recebidos(Long usuarioId);
}
