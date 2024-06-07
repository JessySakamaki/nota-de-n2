package br.com.aulaskratz.nota_de_n2.carteira;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

/**
 * Representa uma carteira contendo informações pessoais e saldo.
 */
public record Carteira(
        @Id Long id,
        String nomeComp,
        Long cpfCnpj,
        String email,
        String senha,
        int tipo,
        BigDecimal saldo) {

    /**
     * Debita um valor do saldo da carteira.
     *
     * @param valor o valor a ser debitado.
     * @return uma nova instância de {@code Carteira} com o saldo atualizado.
     */
    public Carteira debitar(BigDecimal valor) {
        return new Carteira(id, nomeComp, cpfCnpj, email, senha, tipo, saldo.subtract(valor));
    }

}
