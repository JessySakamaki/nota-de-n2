package br.com.aulaskratz.nota_de_n2.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Representa uma transação financeira.
 */
@Table("TRANSACOES")
public record Transacao(
        @Id Long id,
        Long pagante,
        Long recebedor,
        BigDecimal valor,
        @CreatedDate LocalDateTime criadoEm) {

    /**
     * Construtor que ajusta a escala do valor para duas casas decimais.
     *
     * @param valor o valor da transação.
     */
    public Transacao {
        valor = valor.setScale(2);
    }
}
