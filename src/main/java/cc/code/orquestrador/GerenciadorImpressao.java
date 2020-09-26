package cc.code.orquestrador;
import cc.code.dominio.Pessoa;
import cc.code.validador.Validador;

import java.util.Arrays;
import java.util.List;

/**
 * Relatório de pessoas
 * @author Deus
 */
public class GerenciadorImpressao {
	
	/**
	 * imprime a lista de pessoas
	 */
	public static void relatorioPessoas() {
		List<Pessoa> listaPessoas = Arrays.asList(
				new Pessoa("Everton", "9094469979", 27, "11988997766", ""),
				new Pessoa("Fulanao", "9094469979", 34, "988997766", ""),
				new Pessoa("Daniel", "9094469979", 29, "11988997766", ""),
				new Pessoa("Guilherme", "9094469979", 30, "11941728234", "")
		);

		for(Pessoa pessoa : listaPessoas) {
			try {
				Validador.validarPessoa(pessoa);
			} catch(Exception e){
				continue;
			}
		}
	}

}

