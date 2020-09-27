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
    public static final String MSG_NOME_INVALIDO = "Nome invalido!";

    /**
     * Atributo constante da classe, usada quando o telefone celular de uma pessoa e invalido .
     */
    public static final String MSG_TELEFONE_CELULAR_INVALIDO = "Telefone celular invalido!";

    /**
     * Atributo constante da classe, usada quando o CPF de uma pessoa e invalido .
     */
    public static final String MSG_CPF_INVALIDO = "CPF invalido!";

    private ValidadorRegistros() {
    }

    /**
     * Metodo responsavel por imprimir o relatorio de pessoas, cuja elas sao validas .
     *
     * @param pessoa .
     * @throws ValidadorRegistrosException .
     */
    public static void imprimirPessoasValidadasComSucesso(Pessoa pessoa) throws ValidadorRegistrosException {

        if (validarNome(pessoa.getNome()) &&
                validarCpf(pessoa) &&
                validarTelefoneCelular(pessoa)) {
            imprimirRelatorioDePessoas(pessoa);
        }
    }

    /**
     * Metodo responsavel pela validacao do nome da pessoa .
     *
     * @param nome .
     * @throws ValidadorRegistrosException .
     */
    private static boolean validarNome(String nome) throws ValidadorRegistrosException {
        if (Objects.isNull(nome) || isEmpty(nome)) {
            System.err.println(MSG_NOME_INVALIDO);
            throw new ValidadorRegistrosException(MSG_NOME_INVALIDO);
        }
        return true;
    }

    /**
     * Metodo responsavel por verificar se o cpf da pessoa e valido .
     *
     * @param pessoa .
     * @throws ValidadorRegistrosException .
     */
    private static boolean validarCpf(Pessoa pessoa) throws ValidadorRegistrosException {
        if (!ValidadorCpf.CpfValido(pessoa.getCpf())) {
            System.err.println("Nao foi possivel imprimir os dados da pessoa " + pessoa.getNome() + " por motivos de " + MSG_CPF_INVALIDO);
            throw new ValidadorRegistrosException(MSG_CPF_INVALIDO);
        }
        return true;
    }

    /**
     * Metodo responsavel por validar o telefone celular da pessoa .
     *
     * @param pessoa .
     * @throws ValidadorRegistrosException .
     */
    private static boolean validarTelefoneCelular(Pessoa pessoa) throws ValidadorRegistrosException {
        if (pessoa.getTelefoneCelular().length() < 10) {
            System.err.println("Nao foi possivel imprimir os dados da pessoa " + pessoa.getNome() + " por movitos de " + MSG_TELEFONE_CELULAR_INVALIDO);
            throw new ValidadorRegistrosException(MSG_TELEFONE_CELULAR_INVALIDO);
        }
        return true;
    }

    /**
     * Metodo responsavel por imprimir o relatorio de pessoas .
     *
     * @param pessoa .
     */
    private static void imprimirRelatorioDePessoas(Pessoa pessoa) {
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
