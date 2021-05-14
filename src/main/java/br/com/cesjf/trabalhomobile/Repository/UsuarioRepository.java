package br.com.cesjf.trabalhomobile.Repository;

import br.com.cesjf.trabalhomobile.Model.Dto.LoginDto;
import br.com.cesjf.trabalhomobile.Model.Dto.UsuarioDto;
import br.com.cesjf.trabalhomobile.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select new br.com.cesjf.trabalhomobile.Model.Dto.UsuarioDto"
            + "(u.id, u.nomeCompleto,u.nomeUsuario) "
            + "from Usuario u "
            + "where u.email = :email "
            + "and u.senha = :senha"
    )
    public UsuarioDto logar(@Param("email") String email, @Param("senha") String senha);
}
