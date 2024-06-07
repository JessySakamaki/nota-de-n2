package br.com.aulaskratz.nota_de_n2.transacao;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.aulaskratz.nota_de_n2.autorizacao.AutorizacaoService;
import br.com.aulaskratz.nota_de_n2.carteira.Carteira;
import br.com.aulaskratz.nota_de_n2.carteira.CarteiraRepository;
import br.com.aulaskratz.nota_de_n2.carteira.TipoCarteira;
import br.com.aulaskratz.nota_de_n2.exception.TransacaoInvalidaException;
import br.com.aulaskratz.nota_de_n2.notificacao.NotificacaoService;

/**
 * Serviço para operações relacionadas a transações.
 */
@Service
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;
    private final CarteiraRepository carteiraRepository;
    private final AutorizacaoService autorizacaoService;
    private final NotificacaoService notificacaoService;

    /**
     * Construtor do serviço de transações.
     *
     * @param transacaoRepository o repositório de transações.
     * @param carteiraRepository  o repositório de carteiras.
     * @param autorizacaoService  o serviço de autorização.
     * @param notificacaoService  o serviço de notificação.
     */
    public TransacaoService(TransacaoRepository transacaoRepository,
            CarteiraRepository carteiraRepository,
            AutorizacaoService autorizacaoService,
            NotificacaoService notificacaoService) {
        this.transacaoRepository = transacaoRepository;
        this.carteiraRepository = carteiraRepository;
        this.autorizacaoService = autorizacaoService;
        this.notificacaoService = notificacaoService;
    }

    /**
     * Cria uma nova transação.
     *
     * @param transacao a transação a ser criada.
     * @return a transação criada.
     */
    @Transactional
    public Transacao create(Transacao transacao) {
        // Validar
        validar(transacao);

        // Criar a transação
        var newTransacao = transacaoRepository.save(transacao);

        // Debitar
        var carteira = carteiraRepository.findById(transacao.pagante()).get();
        carteiraRepository.save(carteira.debitar(transacao.valor()));

        // Serviços externos
        // Autorização
        autorizacaoService.autorizar(transacao);

        // Notificação
        notificacaoService.notificar(transacao);

        return newTransacao;
    }

    /**
     * Valida se uma transação é válida antes de ser criada.
     *
     * @param transacao a transação a ser validada.
     * @throws TransacaoInvalidaException se a transação não for válida.
     */
    private void validar(Transacao transacao) {
        carteiraRepository.findById(transacao.recebedor())
                .map(recebedor -> carteiraRepository.findById(transacao.pagante())
                        .map(pagante -> transacaoValida(transacao, pagante) ? transacao : null)
                        .orElseThrow(
                                () -> new TransacaoInvalidaException("Transação Inválida - %s".formatted(transacao))))
                .orElseThrow(() -> new TransacaoInvalidaException("Transação Inválida - %s".formatted(transacao)));
    }

    /**
     * Verifica se uma transação é válida.
     *
     * @param transacao a transação a ser verificada.
     * @param pagante   a carteira do pagante.
     * @return true se a transação for válida, false caso contrário.
     */
    private boolean transacaoValida(Transacao transacao, Carteira pagante) {
        return pagante.tipo() == TipoCarteira.COMUM.getValor() &&
                pagante.saldo().compareTo(transacao.valor()) >= 0 &&
                !pagante.id().equals(transacao.recebedor());
    }

    /**
     * Retorna uma lista de todas as transações.
     *
     * @return uma lista de transações.
     */
    public List<Transacao> lista() {
        return (List<Transacao>) transacaoRepository.findAll();
    }
}
