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
	static String _s;
	
	/**
	 * imprime a lista de pessoas
	 * @param paramL
	 */
	public static void print_e_vai(Vector paramL){
		
		for (int i = 0; i < paramL.size(); i++) {
			
			Pessoa p = (Pessoa) paramL.get(i);
			Validation validador = new Validation();
			List<String> erro = validador.validaPessoa(p);
			
			if(!erro.isEmpty())
				continue;
			
		    _s += ", " + p.name;			
		}

		_s = _s.substring(2); 
		System.out.print(_s);
	}

}

