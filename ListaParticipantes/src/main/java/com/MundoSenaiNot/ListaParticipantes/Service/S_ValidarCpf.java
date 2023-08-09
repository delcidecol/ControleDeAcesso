package com.MundoSenaiNot.ListaParticipantes.Service;

import org.springframework.stereotype.Service;

@Service
public class S_ValidarCpf {

    public static boolean validarCPF(String cpf) {
        // Remover caracteres não numéricos do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verificar se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }
        // Verificar se todos os dígitos são iguais (CPF inválido)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int resto = soma % 11;
        int digito1 = (resto < 2) ? 0 : 11 - resto;

        // Verifica o primeiro dígito verificador
        if (Character.getNumericValue(cpf.charAt(9)) != digito1) {
            return false;
        }
        // Calcula o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        resto = soma % 11;
        int digito2 = (resto < 2) ? 0 : 11 - resto;

        // Verifica o segundo dígito verificador
        if (Character.getNumericValue(cpf.charAt(10)) != digito2) {
            return false;
        }
        return true;
    }
}

