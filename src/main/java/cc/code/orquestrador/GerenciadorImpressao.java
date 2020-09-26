package cc.code.orquestrador;

import cc.code.dominio.Pessoa;
import cc.code.validador.ValidadorRegistros;

import java.util.Arrays;
import java.util.List;

/**
 * Gerenciador de impressao do relatorio de pessoas
 *
 * @author Everton Oliveira Fernandes
 */
public class GerenciadorImpressao {

    /**
     * Popula relatorio de pessoas com suas devidas informacoes pessoais .
     */
    public static void relatorioPessoas() {
        List<Pessoa> listaPessoas = Arrays.asList(
                new Pessoa("Everton", "Fernandes", "33221122", "11988997766", "9094469979"),
                new Pessoa("Fulano", "Da Silva", "33221122", "988997766", "9094469979"),
                new Pessoa("Daniel", "Width", "33221122", "11988997766", "9094469979"),
                new Pessoa("Guilherme", "Elias", "33221122", "11941728234", "9094469979")
        );

        for (Pessoa pessoa : listaPessoas) {
            try {
                ValidadorRegistros.imprimirPessoasValidadasComSucesso(pessoa);
            } catch (Exception e) {
                continue;
            }
        }
    }

}

