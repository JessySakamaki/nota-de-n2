package br.com.aulaskratz.nota_de_n2;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.aulaskratz.nota_de_n2.carteira.Carteira;

/**
 * Testes para a classe Carteira.
 */
public class CarteiraTest {

    /**
     * Teste para garantir que a criação de uma carteira funcione corretamente.
     */
    @Test
    void testCarteiraCreation() {
        Long id = 1L;
        String nomeComp = "John Doe";
        Long cpfCnpj = 12345678901L;
        String email = "john.doe@example.com";
        String senha = "password";
        int tipo = 1;
        BigDecimal saldo = new BigDecimal("1000.00");

        Carteira carteira = new Carteira(id, nomeComp, cpfCnpj, email, senha, tipo, saldo);

        assertThat(carteira.id()).isEqualTo(id);
        assertThat(carteira.nomeComp()).isEqualTo(nomeComp);
        assertThat(carteira.cpfCnpj()).isEqualTo(cpfCnpj);
        assertThat(carteira.email()).isEqualTo(email);
        assertThat(carteira.senha()).isEqualTo(senha);
        assertThat(carteira.tipo()).isEqualTo(tipo);
        assertThat(carteira.saldo()).isEqualTo(saldo);
    }

    /**
     * Teste para garantir que o débito de uma carteira funcione corretamente.
     */
    @Test
    void testDebitar() {
        Long id = 1L;
        String nomeComp = "John Doe";
        Long cpfCnpj = 12345678901L;
        String email = "john.doe@example.com";
        String senha = "password";
        int tipo = 1;
        BigDecimal saldo = new BigDecimal("1000.00");
        BigDecimal valorDebito = new BigDecimal("250.00");

        Carteira carteira = new Carteira(id, nomeComp, cpfCnpj, email, senha, tipo, saldo);
        Carteira carteiraDebitada = carteira.debitar(valorDebito);

        assertThat(carteiraDebitada.saldo()).isEqualTo(new BigDecimal("750.00"));
        assertThat(carteiraDebitada.id()).isEqualTo(id);
        assertThat(carteiraDebitada.nomeComp()).isEqualTo(nomeComp);
        assertThat(carteiraDebitada.cpfCnpj()).isEqualTo(cpfCnpj);
        assertThat(carteiraDebitada.email()).isEqualTo(email);
        assertThat(carteiraDebitada.senha()).isEqualTo(senha);
        assertThat(carteiraDebitada.tipo()).isEqualTo(tipo);
    }

    /**
     * Teste para garantir que o débito de uma carteira com fundos insuficientes
     * resulte em saldo negativo.
     */
    @Test
    void testDebitarInsufficientFunds() {
        Long id = 1L;
        String nomeComp = "John Doe";
        Long cpfCnpj = 12345678901L;
        String email = "john.doe@example.com";
        String senha = "password";
        int tipo = 1;
        BigDecimal saldo = new BigDecimal("100.00");
        BigDecimal valorDebito = new BigDecimal("250.00");

        Carteira carteira = new Carteira(id, nomeComp, cpfCnpj, email, senha, tipo, saldo);

        Carteira carteiraDebitada = carteira.debitar(valorDebito);

        assertThat(carteiraDebitada.saldo()).isEqualTo(new BigDecimal("-150.00"));
    }
}
