package cc.code;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Relatório de pessoas
 * @author Deus
 */
public class RelatorioPessoas {

	/**
	 * a string para somar todos os nomes na lista 
	 */
	private List<Pessoa> listaPessoas;
	
	/**
	 * imprime a lista de pessoas
	 * @param paramL
	 */
	public List<Pessoa> obterRelatorioPessoas(Pessoa pessoa){

		this.listaPessoas = new ArrayList<Pessoa>();

		Pessoa p;
		Validation validador = new Validation();
		List<String> erro;

		for (int i = 0; i < paramL.size(); i++) {

			p = (Pessoa) paramL.get(i);
			erro = validador.validaPessoa(p);

			if(!erro.isEmpty())
				continue;
			
		    listaPessoas.add(p);

		}

		return listaPessoas;
	}

}

