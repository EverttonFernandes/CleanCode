package cc.code.validador;

import cc.code.dominio.Pessoa;
import cc.code.exception.ValidadorRegistrosException;

import java.util.Objects;

import static sun.util.locale.LocaleUtils.isEmpty;

public class ValidadorRegistros {

    public static final String MSG_NOME_INVALIDO = "Nome inválido!";
    public static final String MSG_TELEFONE_CELULAR_INVALIDO = "Telefone celular inválido!";
    public static final String MSG_CPF_INVALIDO = "CPF inválido!";

    public static void validarPessoa(Pessoa pessoa) throws ValidadorRegistrosException {
        
        validarNome(pessoa.getNome());
        validarCpf(pessoa.getCpf());
        validarTelefoneCelular(pessoa.getTelefoneCelular());

    }

    private static void validarNome(String nome) throws ValidadorRegistrosException {
        if(Objects.isNull(nome) || isEmpty(nome)){
            System.err.println(MSG_NOME_INVALIDO);
            throw new ValidadorRegistrosException(MSG_NOME_INVALIDO);
        }
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
