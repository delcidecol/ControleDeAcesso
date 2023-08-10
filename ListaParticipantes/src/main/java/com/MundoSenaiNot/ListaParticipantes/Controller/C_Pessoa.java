package com.MundoSenaiNot.ListaParticipantes.Controller;

import com.MundoSenaiNot.ListaParticipantes.Model.M_Resposta;
import com.MundoSenaiNot.ListaParticipantes.Service.S_Pessoa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Pessoa {
    @GetMapping("/")
    public String landPage() {
        return "Login/Login";
    }

    @PostMapping("/")
    public String loginPessoa(@RequestParam("usuario") String usuario,
                              @RequestParam("senha") String senha) {
        return "Home/home";
    }

    @GetMapping("/cadastro")
    public String getCadastro() {
        return "Login/Cadastro";
    }

    @PostMapping("/cadastro")
    public String postCadastro(@RequestParam("nome") String nome,
                               @RequestParam("cpf") String cpf,
                               @RequestParam("telefone") String telefone,
                               @RequestParam("email") String email,
                               @RequestParam("senha") String senha,
                               @RequestParam("confirmaSenha") String confirmaSenha, Model model) {
        M_Resposta m_resposta = S_Pessoa.cadastrarPessoa(nome, cpf, telefone, email, senha, confirmaSenha);
        if (m_resposta.getStatus()) {
            model.addAttribute("mensagem", m_resposta.getMensagem());
            return "Login/Login";
        } else {
            model.addAttribute("mensagem", m_resposta.getMensagem());
            return "Login/Cadastro";
        }
    }
}

// REgra de desenvolvimento:  View >> Controller >> Service >> Repository >> Branco de Dados