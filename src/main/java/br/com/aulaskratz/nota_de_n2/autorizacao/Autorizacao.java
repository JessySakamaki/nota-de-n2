package br.com.aulaskratz.nota_de_n2.autorizacao;

/**
 * Classe que representa uma autorização com uma mensagem.
 * Contém um método para verificar se a autorização foi concedida.
 */
public record Autorizacao(
        String mensagem) {

    /**
     * Verifica se a mensagem de autorização é "Autorizado".
     *
     * @return true se a mensagem for "Autorizado", false caso contrário.
     */
    public boolean autorizado() {
        return mensagem.equals("Autorizado");
    }
}
