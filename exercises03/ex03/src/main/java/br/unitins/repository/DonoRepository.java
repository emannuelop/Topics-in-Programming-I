package br.unitins.repository;

import javax.enterprise.context.ApplicationScoped;

import java.util.List;

import br.unitins.model.Dono;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class DonoRepository implements PanacheRepository<Dono> {

    public List<Dono> findByNomeIgnoreCase(String nome) {
        if (nome == null) {
            return null;
        }

        return find("UPPER(nome) LIKE ?1 ", "%" +
                nome.toUpperCase() + "%").list();

        /*
         * return find("UPPER(unaccent(nome)) LIKE unaccent(?1)", "%" +
         * nome.toUpperCase() + "%").list();
         * 
         * SELECT e FROM dono e WHERE e.nome LIKE %Ema%
         */

    }

}
