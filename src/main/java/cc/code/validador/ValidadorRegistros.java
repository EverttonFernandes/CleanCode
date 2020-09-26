package cc.code.validador;

import cc.code.dominio.Pessoa;

public class ValidadorRegistros {

    public static void validarPessoa (Pessoa pessoa) {

        validarCpf(pessoa.getCpf());
        validarTelefoneCelular(pessoa.getTelefoneCelular());

    }

    private static void validarCpf (String cpf) {

    }

    private static void validarTelefoneCelular(String telefone) {

    }
}
