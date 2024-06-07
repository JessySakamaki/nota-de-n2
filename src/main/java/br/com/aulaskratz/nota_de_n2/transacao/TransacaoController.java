package br.com.aulaskratz.nota_de_n2.transacao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Controlador REST para operações relacionadas a transações.
 */
@RestController
@RequestMapping("transacao")
public class TransacaoController {
    private final TransacaoService transacaoService;

    /**
     * Construtor do controlador de transações.
     *
     * @param transacaoService o serviço de transações a ser injetado.
     */
    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    /**
     * Endpoint para criar uma nova transação.
     *
     * @param transacao a transação a ser criada.
     * @return a transação criada.
     */
    @PostMapping
    public Transacao criarTransacao(@RequestBody Transacao transacao) {
        return transacaoService.create(transacao);
    }

    /**
     * Endpoint para listar todas as transações.
     *
     * @return uma lista de todas as transações.
     */
    @GetMapping
    public List<Transacao> lista() {
        return transacaoService.lista();
    }
}
