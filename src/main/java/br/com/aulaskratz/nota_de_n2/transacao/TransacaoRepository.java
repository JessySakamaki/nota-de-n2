package br.com.aulaskratz.nota_de_n2.transacao;

import org.springframework.data.repository.CrudRepository;

/**
 * Interface de repositório para operações de CRUD em transações.
 */
public interface TransacaoRepository extends CrudRepository<Transacao, Long> {

}
