package cc.code.validador;

import cc.code.dominio.Pessoa;
import cc.code.exception.ValidadorRegistrosException;

import java.util.Objects;

import static sun.util.locale.LocaleUtils.isEmpty;

/**
 * Classe responsavel por validar os registros do usuario antes da impressao do relatorio de pessoas .
 *
 * @author Everton Oliveira Fernandes .
 */
public class ValidadorRegistros {

    /**
     * Atributo constante da classe, usada quando o nome de uma pessoa e invalido .
     */
    public static final String MSG_NOME_INVALIDO = "Nome inválido!";

    /**
     * Atributo constante da classe, usada quando o telefone celular de uma pessoa e invalido .
     */
    public static final String MSG_TELEFONE_CELULAR_INVALIDO = "Telefone celular inválido!";

    /**
     * Atributo constante da classe, usada quando o CPF de uma pessoa e invalido .
     */
    public static final String MSG_CPF_INVALIDO = "CPF inválido!";

    /**
     * Metodo responsavel por imprimir o relatorio de pessoas, cuja elas sao validas .
     * @param pessoa .
     * @throws ValidadorRegistrosException .
     */
    public static void imprimirPessoasValidadasComSucesso(Pessoa pessoa) throws ValidadorRegistrosException {

        validarNome(pessoa.getNome());
        validarCpf(pessoa.getCpf());
        validarTelefoneCelular(pessoa.getTelefoneCelular());

        imprimirRelatorioDePessoas(pessoa);
    }

    /**
     * Metodo responsavel pela validacao do nome da pessoa .
     *
     * @param nome .
     * @throws ValidadorRegistrosException .
     */
    private static void validarNome(String nome) throws ValidadorRegistrosException {
        if (Objects.isNull(nome) || isEmpty(nome)) {
            System.err.println(MSG_NOME_INVALIDO);
            throw new ValidadorRegistrosException(MSG_NOME_INVALIDO);
        }
    }

    /**
     * Metodo responsavel por verificar se o cpf da pessoa e valido .
     *
     * @param cpf .
     * @throws ValidadorRegistrosException .
     */
    private static void validarCpf(String cpf) throws ValidadorRegistrosException {
        if (!ValidadorCpf.CpfValido(cpf)) {
            System.err.println(MSG_CPF_INVALIDO);
            throw new ValidadorRegistrosException(MSG_CPF_INVALIDO);
        }
    }

    /**
     * Metodo responsavel por validar o telefone celular da pessoa .
     *
     * @param telefoneCelular .
     * @throws ValidadorRegistrosException .
     */
    private static void validarTelefoneCelular(String telefoneCelular) throws ValidadorRegistrosException {
        if (telefoneCelular.length() < 10) {
            System.err.println(MSG_TELEFONE_CELULAR_INVALIDO);
            throw new ValidadorRegistrosException(MSG_TELEFONE_CELULAR_INVALIDO);
        }
    }

    /**
     * Metodo responsavel por imprimir o relatorio de pessoas .
     * @param pessoa .
     */
    private static void imprimirRelatorioDePessoas(Pessoa pessoa){
        StringBuilder linhaBuilder = new StringBuilder();
        linhaBuilder.append(String.format("Nome: %s %s", pessoa.getNome(), pessoa.getSobrenome()));
        linhaBuilder.append(System.getProperty("line.separator"));
        linhaBuilder.append(String.format("Fone: %s", pessoa.getTelefoneCelular()));
        linhaBuilder.append(System.getProperty("line.separator"));
        linhaBuilder.append(String.format("CPF: %s", pessoa.getCpf()));
        linhaBuilder.append(System.getProperty("line.separator"));

        System.out.print(linhaBuilder.toString());
    }
}
