package br.com.cesjf.trabalhomobile.Repository;

import br.com.cesjf.trabalhomobile.Model.Dto.HeroiDto;
import br.com.cesjf.trabalhomobile.Model.Favorito;
import br.com.cesjf.trabalhomobile.Model.Heroi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FavoritoRepository extends JpaRepository<Favorito, Long> {

    @Query("select new br.com.cesjf.trabalhomobile.Model.Heroi"
            + "(h.id, h.idApi, h.nome, h.alterEgo, h.urlImagem, s) "
            + "from Heroi h "
            + "inner join Favorito f "
            + "on f.heroi.id = h.id "
            + "inner join Status s "
            + "on s.id = h.status.id "
            + "where f.usuario.id = :usuarioId "
    )
    public List<Heroi> listar(@Param("usuarioId") Long usuarioId);

    @Query("select new br.com.cesjf.trabalhomobile.Model.Favorito" +
            "(f.id,f.usuario, f.heroi) " +
            "from Favorito f " +
            "where f.usuario.id = :usuarioId " +
            "and f.heroi.id = :heroiId"
    )
    Favorito buscarPorUsuarioEHeroi(@Param("heroiId") Long heroiId, @Param("usuarioId") Long usuarioId);
}
