package br.com.aulaskratz.nota_de_n2.notificacao;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.aulaskratz.nota_de_n2.transacao.Transacao;

/**
 * Serviço para produzir e enviar notificações de transações para o Kafka.
 */
@Service
public class ProdutorNotificacao {
    private final KafkaTemplate<String, Transacao> kafkaTemplate;

    /**
     * Construtor do serviço de produtor de notificações.
     *
     * @param kafkaTemplate o {@link KafkaTemplate} usado para enviar mensagens para
     *                      o Kafka.
     */
    public ProdutorNotificacao(KafkaTemplate<String, Transacao> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Envia uma notificação de transação para o Kafka.
     *
     * @param transacao a transação a ser notificada.
     */
    public void enviarNotificacao(Transacao transacao) {
        kafkaTemplate.send("notificacao-transacao", transacao);
    }

}
