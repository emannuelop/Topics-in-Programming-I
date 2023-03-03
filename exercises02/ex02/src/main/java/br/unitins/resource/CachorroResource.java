package br.unitins.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unitins.model.Cachorro;
import br.unitins.repository.CachorroRepository;

@Path("/cachorro")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CachorroResource {

    @Inject
    private CachorroRepository repository;

    @POST
    @Transactional
    public Cachorro insert(Cachorro cachorro) {

        repository.persist(cachorro);

        return cachorro;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Cachorro uptadte(@PathParam("id") Long id, Cachorro cachorro) {

        Cachorro entity = repository.findById(id);

        entity.setNome(cachorro.getNome());
        entity.setIdade(cachorro.getIdade());
        entity.setCor(cachorro.getCor());
        entity.setRaca(cachorro.getRaca());
        entity.setPorte(cachorro.getPorte());

        return entity;

    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {

        Cachorro cachorro = repository.findById(id);

        if (repository.isPersistent(cachorro))
            repository.delete(cachorro);

    }

    @GET
    public List<Cachorro> getAll() {
        return repository.findAll().list();
    }

    @GET
    @Path("/{id}")
    public Cachorro getById(@PathParam("id") Long id) {
        return repository.findById(id);
    }

    @GET
    @Path("/quantidade")
    public long count() {
        return repository.count();
    }

    @GET
    @Path("/serch/{nome}")
    public List<Cachorro> search(@PathParam("nome") String nome) {
        return repository.findByNomeIgnoreCase(nome);
    }

}
