package br.com.aulaskratz.nota_de_n2.notificacao;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import br.com.aulaskratz.nota_de_n2.exception.NotificacaoException;
import br.com.aulaskratz.nota_de_n2.transacao.Transacao;

/**
 * Serviço para consumir notificações de transações através do Kafka.
 */
@Service
public class ConsumidorNotificacao {
    private RestClient restClient;

    /**
     * Construtor do serviço de consumidor de notificações.
     *
     * @param builder um construtor de {@link RestClient} usado para configurar o
     *                cliente REST.
     */
    public ConsumidorNotificacao(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://util.devi.tools/api/v1/notify")
                .build();
    }

    /**
     * Método para receber e processar notificações de transações.
     *
     * @param transacao a transação recebida através do Kafka.
     */
    @SuppressWarnings("null")
    @KafkaListener(topics = "notificacao-transacao", groupId = "picpay-desafio-backend")
    public void receberNotificacao(Transacao transacao) {
        var resposta = restClient.get()
                .retrieve()
                .toEntity(Notificacao.class);

        if (resposta.getStatusCode().isError() || !resposta.getBody().message()) {
            throw new NotificacaoException("Erro ao enviar a notificação");
        }
    }

}
