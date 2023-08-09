package com.MundoSenaiNot.ListaParticipantes.Model;

import jakarta.persistence.*;

@Entity
@Table(name="pessoa")
public class M_Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private String email;
    private Long cpf;
    private Long telefone;
    private String senha;

    public Long getId() {
        return Id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail(String email) {
        return this.email;
    }

    public Long getCpf(Long aLong) {
        return cpf;
    }

    public Long getTelefone() {
        return telefone;
    }

    public String getSenha(String senha) {
        return this.senha;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
