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

    private GerenciadorImpressao() {
    }

    /**
     * Popula relatorio de pessoas com suas devidas informacoes pessoais .
     */
    public static void relatorioPessoas() {
        List<Pessoa> listaPessoas = Arrays.asList(
                new Pessoa("Everton", "Fernandes", "33221122", "1988997766", "04624193806"),
                new Pessoa("Fulano", "Da Silva", "33221124", "11988997766", "9094469979"),
                new Pessoa("Daniel", "Wildt", "33221121", "988997766", "61473662036"),
                new Pessoa("Guilherme", "Elias", "33221129", "11941728234", "72453228056")
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

