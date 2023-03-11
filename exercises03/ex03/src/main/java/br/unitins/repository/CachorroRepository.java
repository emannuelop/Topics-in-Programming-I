package br.unitins.repository;

import javax.enterprise.context.ApplicationScoped;

import java.util.List;

import br.unitins.model.Cachorro;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CachorroRepository implements PanacheRepository<Cachorro> {

    public List<Cachorro> findByNomeIgnoreCase(String nome) {
        if (nome == null) {
            return null;
        }

        return find("UPPER(nome) LIKE ?1 ", "%" +
                nome.toUpperCase() + "%").list();
    }

    /*
     * Outra forma de fazer
     * public List<Cachorro> findByNomeIgnoreCase(String nome) {
     * return find("FROM Cachorro WHERE upper(nome) LIKE ?1", "%" +
     * nome.toUpperCase() + "%").list();
     * }
     */

}
