package cc.code.validador;

import cc.code.dominio.Pessoa;
import cc.code.exception.ValidadorRegistrosException;

public class ValidadorRegistros {

    public static final String MSG_NOME_INVALIDO = "Nome inválido!";
    public static final String MSG_TELEFONE_CELULAR_INVALIDO = "Telefone celular inválido!";
    public static final String MSG_CPF_INVALIDO = "CPF inválido!";

    public static void validarPessoa(Pessoa pessoa) throws ValidadorRegistrosException {
        
        validarNome(pessoa.getNome());
        validarCpf(pessoa.getCpf());
        validarTelefoneCelular(pessoa.getTelefoneCelular());

    }

    private static void validarNome(String name) {
    }

    private static void validarCpf(String cpf) throws ValidadorRegistrosException{

    }

    private static void validarTelefoneCelular(String telefoneCelular) throws ValidadorRegistrosException {
        if(telefoneCelular.length() < 10){
            System.err.println(MSG_TELEFONE_CELULAR_INVALIDO);
            throw new ValidadorRegistrosException(MSG_TELEFONE_CELULAR_INVALIDO);
        }
    }
}
