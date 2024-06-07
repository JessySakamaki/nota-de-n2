package br.com.aulaskratz.nota_de_n2.exception;

/**
 * Exceção lançada quando uma transação não é autorizada.
 */
public class TransacaoNaoAutorizadaException extends RuntimeException {

    /**
     * Construtor da exceção com uma mensagem de erro.
     *
     * @param mensagem a mensagem de erro associada à exceção.
     */
    public TransacaoNaoAutorizadaException(String mensagem) {
        super(mensagem);
    }
}
