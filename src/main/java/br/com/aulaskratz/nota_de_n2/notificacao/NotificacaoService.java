package br.com.aulaskratz.nota_de_n2.notificacao;

import org.springframework.stereotype.Service;

import br.com.aulaskratz.nota_de_n2.transacao.Transacao;

/**
 * Serviço para notificar transações.
 */
@Service
public class NotificacaoService {

    /**
     * Método para notificar uma transação.
     *
     * @param transacao a transação a ser notificada.
     */
    public void notificar(Transacao transacao) {
        // Lógica para notificar a transação (ainda não implementada)
    }
}
