package br.com.aulaskratz.nota_de_n2.carteira;

import org.springframework.data.repository.CrudRepository;

/**
 * Repositório para a entidade {@link Carteira}.
 * Fornece operações CRUD para gerenciar instâncias de {@link Carteira}.
 */
public interface CarteiraRepository extends CrudRepository<Carteira, Long> {

}
