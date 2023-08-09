package com.MundoSenaiNot.ListaParticipantes.Service;

import com.MundoSenaiNot.ListaParticipantes.Model.M_Pessoa;
import com.MundoSenaiNot.ListaParticipantes.Repository.R_Pessoa;
import org.springframework.stereotype.Service;

@Service
public class S_Pessoa {
    private static R_Pessoa r_pessoa;

    public S_Pessoa(R_Pessoa r_pessoa) {
        this.r_pessoa = r_pessoa;
    }

    public static String cadastrarPessoa(String nome, String cpf, String telefone, String email, String senha, String conf_senha) {

        String mensagem = "";
        boolean podeSalvar = true;

        if (!senha.equals(conf_senha) || senha == null || senha.trim().equals("")) {
            mensagem += "Senha e confirmação devem ser iguais, e a senha deve ser informada";
            podeSalvar = false;
        }
        if (!S_ValidarCpf.validarCPF(cpf)) {
            mensagem += "CPF inválido";
            podeSalvar = false;
        }
        if (nome == null || nome.trim().equals("")) {
            mensagem += " O nome precisa ser informado";
            podeSalvar = false;
        }
        if ((email == null || email.trim().equals("")) && (telefone == null || email.trim().equals(""))) {
            mensagem += "e-Mail ou telefone precisa ser informado";
            podeSalvar = false;
        }
    String teste = S_LimpaNumero.limpar(cpf);
        M_Pessoa m_pessoa = new M_Pessoa();
        m_pessoa.setNome(nome);
        m_pessoa.setEmail(email);
        m_pessoa.setSenha(senha);
        m_pessoa.setCpf(Long.valueOf(S_LimpaNumero.limpar(cpf)));
        m_pessoa.setTelefone(Long.valueOf(S_LimpaNumero.limpar(telefone)));
        r_pessoa.save(m_pessoa);
        mensagem += "Pessoa Cadastrada Com Sucesso";

        return "Pessoa Cadastrada com Sucesso!!!";
    }
}
