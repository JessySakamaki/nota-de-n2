package br.com.aulaskratz.nota_de_n2.carteira;

/**
 * Enumeração que representa os tipos de carteiras disponíveis.
 */
public enum TipoCarteira {
    COMUM(1), LOJISTA(2);

    private int valor;

    /**
     * Construtor para o enum {@code TipoCarteira}.
     *
     * @param valor o valor numérico associado ao tipo de carteira.
     */
    private TipoCarteira(int valor) {
        this.valor = valor;
    }

    /**
     * Retorna o valor numérico associado ao tipo de carteira.
     *
     * @return o valor numérico do tipo de carteira.
     */
    public int getValor() {
        return valor;
    }
}
