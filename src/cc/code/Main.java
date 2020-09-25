package cc.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {

    /**
     * codigo principal
     * @param args
     */
    public static void main(String[] args) {
        RelatorioPessoas relatorio = new RelatorioPessoas();
        Validador validador = new Validador();

        Pessoa pessoa = new Pessoa();
        pessoa.setName("Everton");
        pessoa.setCpf("999.581.155-87");

        pessoa.setName("Jeferson");
        pessoa.setCpf("901.581.452-77");

        List<Pessoa> listaPessoas = relatorio.obterRelatorioPessoas(pessoa);

        for (pessoa : listaPessoas) {
            validador.validarPessoa(pessoa);
        }

    }
}
