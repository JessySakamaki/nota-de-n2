package br.com.aulaskratz.nota_de_n2;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import br.com.aulaskratz.nota_de_n2.transacao.Transacao;

/**
 * Testes para a classe Transacao.
 */
public class TransacaoTest {

    /**
     * Teste para garantir que a criação de uma transação funcione corretamente.
     */
    @Test
    void testTransacaoCreation() {
        Long id = 1L;
        Long pagante = 100L;
        Long recebedor = 200L;
        BigDecimal valor = new BigDecimal("123.456");
        LocalDateTime criadoEm = LocalDateTime.now();

        Transacao transacao = new Transacao(id, pagante, recebedor, valor, criadoEm);

        assertThat(transacao.id()).isEqualTo(id);
        assertThat(transacao.pagante()).isEqualTo(pagante);
        assertThat(transacao.recebedor()).isEqualTo(recebedor);
        assertThat(transacao.valor()).isEqualTo(valor.setScale(2));
        assertThat(transacao.criadoEm()).isEqualTo(criadoEm);
    }

    /**
     * Teste para garantir que o valor de uma transação seja arredondado para duas
     * casas decimais.
     */
    @Test
    void testValorScale() {
        Long id = 1L;
        Long pagante = 100L;
        Long recebedor = 200L;
        BigDecimal valor = new BigDecimal("123.456");
        LocalDateTime criadoEm = LocalDateTime.now();

        Transacao transacao = new Transacao(id, pagante, recebedor, valor, criadoEm);

        assertThat(transacao.valor()).isEqualByComparingTo(new BigDecimal("123.46"));
    }

    /**
     * Teste para garantir que a criação de uma transação padrão funcione
     * corretamente.
     */
    @Test
    void testTransacaoDefaultCreation() {
        Long pagante = 100L;
        Long recebedor = 200L;
        BigDecimal valor = new BigDecimal("50.00");

        Transacao transacao = new Transacao(null, pagante, recebedor, valor, null);

        assertThat(transacao.id()).isNull();
        assertThat(transacao.pagante()).isEqualTo(pagante);
        assertThat(transacao.recebedor()).isEqualTo(recebedor);
        assertThat(transacao.valor()).isEqualTo(valor.setScale(2));
        assertThat(transacao.criadoEm()).isNull();
    }
}
