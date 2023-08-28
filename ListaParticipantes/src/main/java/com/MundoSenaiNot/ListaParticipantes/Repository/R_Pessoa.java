package com.MundoSenaiNot.ListaParticipantes.Repository;

import com.MundoSenaiNot.ListaParticipantes.Model.M_Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Pessoa extends JpaRepository<M_Pessoa, Long> {
    @Query(value = "select * from pessoa where id =  :Id",  nativeQuery = true)
            M_Pessoa findById(@Param("Id")String Id);

    @Query(value = "select * from pessoa where cpf =  :cpf and senha = :senha",  nativeQuery = true)
    M_Pessoa findByCpfESenha(@Param("cpf")Long cpf, @Param("senha") String senha);
}
