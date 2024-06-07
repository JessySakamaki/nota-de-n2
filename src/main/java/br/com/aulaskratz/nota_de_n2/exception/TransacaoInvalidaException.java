package br.com.aulaskratz.nota_de_n2.exception;

/**
 * Exceção lançada quando uma transação é considerada inválida.
 */
public class TransacaoInvalidaException extends RuntimeException {

    /**
     * Construtor da exceção com uma mensagem de erro.
     *
     * @param mensagem a mensagem de erro associada à exceção.
     */
    public TransacaoInvalidaException(String mensagem) {
        super(mensagem);
    }

}
