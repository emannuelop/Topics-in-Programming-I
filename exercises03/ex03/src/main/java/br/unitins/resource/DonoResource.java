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

import br.unitins.model.Dono;
import br.unitins.repository.DonoRepository;

@Path("/donos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DonoResource {

    @Inject
    private DonoRepository repository;

    @POST
    @Transactional
    public Dono insert(Dono dono) {

        repository.persist(dono);

        return dono;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Dono uptadte(@PathParam("id") Long id, Dono dono) {

        Dono entity = repository.findById(id);

        entity.setNome(dono.getNome());
        entity.setCpf(dono.getCpf());
        entity.setSexo(dono.getSexo());

        return entity;

    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {

        Dono dono = repository.findById(id);

        if (repository.isPersistent(dono))
            repository.delete(dono);

    }

    @GET
    public List<Dono> getAll() {
        return repository.findAll().list();
    }

    @GET
    @Path("/{id}")
    public Dono getById(@PathParam("id") Long id) {
        return repository.findById(id);
    }

    @GET
    @Path("/count")
    public long count() {
        return repository.count();
    }

    @GET
    @Path("/serch/{nome}")
    public List<Dono> search(@PathParam("nome") String nome) {
        return repository.findByNomeIgnoreCase(nome);
    }

}
