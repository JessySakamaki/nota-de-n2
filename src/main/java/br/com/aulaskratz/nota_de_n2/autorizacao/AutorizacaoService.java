package br.com.aulaskratz.nota_de_n2.autorizacao;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import br.com.aulaskratz.nota_de_n2.exception.TransacaoNaoAutorizadaException;
import br.com.aulaskratz.nota_de_n2.transacao.Transacao;

/**
 * Serviço responsável por autorizar transações utilizando uma API externa.
 */
@Service
public class AutorizacaoService {
    private final RestClient restClient;

    /**
     * Construtor do serviço de autorização.
     *
     * @param builder um construtor de {@link RestClient} usado para configurar o
     *                cliente REST.
     */
    public AutorizacaoService(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://util.devi.tools/api/v2/authorize")
                .build();
    }

    /**
     * Autoriza uma transação utilizando uma API externa.
     *
     * @param transacao a transação a ser autorizada.
     * @throws TransacaoNaoAutorizadaException se a transação não for autorizada.
     */
    @SuppressWarnings("null")
    public void autorizar(Transacao transacao) {
        var resposta = restClient.get()
                .retrieve()
                .toEntity(Autorizacao.class);

        if (resposta.getStatusCode().isError() || !resposta.getBody().autorizado()) {
            throw new TransacaoNaoAutorizadaException("Transação não autorizada");
        }
    }
}
