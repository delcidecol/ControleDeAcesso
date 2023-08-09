package com.MundoSenaiNot.ListaParticipantes.Repository;

import com.MundoSenaiNot.ListaParticipantes.Model.M_Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface R_Pessoa extends JpaRepository<M_Pessoa, Long> {
    @Query(value = "select * from pessoa where id =  :Id",  nativeQuery = true)
            M_Pessoa findById(@Param("Id")String Id);
}
