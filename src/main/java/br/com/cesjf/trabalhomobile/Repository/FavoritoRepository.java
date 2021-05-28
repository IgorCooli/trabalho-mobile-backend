package br.com.cesjf.trabalhomobile.Repository;

import br.com.cesjf.trabalhomobile.Model.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FavoritoRepository extends JpaRepository<Favorito, Long> {
}
