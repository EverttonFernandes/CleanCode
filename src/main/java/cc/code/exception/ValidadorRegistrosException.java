package cc.code.exception;

/**
 * Classe de excessoes da aplicacao .
 *
 * @author Everton Oliveira Fernandes .
 */
public class ValidadorRegistrosException extends Exception {

    /**
     * Metodo de excessoes da aplicacao .
     * @param mensagem .
     */
    public ValidadorRegistrosException(String mensagem) {
        super(mensagem);
    }
}
