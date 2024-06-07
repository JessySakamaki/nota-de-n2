package br.com.aulaskratz.nota_de_n2.exception;

/**
 * Exceção para notificação de erros específicos do sistema.
 */
public class NotificacaoException extends RuntimeException {

    /**
     * Construtor da exceção com uma mensagem de erro.
     *
     * @param mensagem a mensagem de erro associada à exceção.
     */
    public NotificacaoException(String mensagem) {
        super(mensagem);
    }
}
