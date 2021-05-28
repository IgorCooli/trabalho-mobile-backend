package br.com.cesjf.trabalhomobile.Repository;

import br.com.cesjf.trabalhomobile.Model.Heroi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface HeroiRepository extends JpaRepository<Heroi, Long> {

    Optional<Heroi> findByIdApi(Long idApi);

}
