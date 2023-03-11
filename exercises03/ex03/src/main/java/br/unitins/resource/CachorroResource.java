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

import br.unitins.dto.CachorroDTO;
import br.unitins.dto.CachorroResponseDTO;
import br.unitins.model.Cachorro;
import br.unitins.repository.CachorroRepository;
import br.unitins.repository.DonoRepository;

@Path("/cachorros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CachorroResource {

    @Inject
    private CachorroRepository repository;

    @Inject
    private DonoRepository donorepository;

    @POST
    @Transactional
    public CachorroResponseDTO insert(CachorroDTO dto) {

        Cachorro entity = new Cachorro();
        entity.setNome(dto.getNome());
        entity.setDono(donorepository.findById(dto.getIdDono()));

        repository.persist(entity);

        return new CachorroResponseDTO(entity);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Cachorro update(@PathParam("id") Long id, Cachorro cachorro) {

        Cachorro entity = repository.findById(id);

        entity.setNome(cachorro.getNome());

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
    @Path("/count")
    public long count() {
        return repository.count();
    }

    @GET
    @Path("/serch/{nome}")
    public List<Cachorro> search(@PathParam("nome") String nome) {
        return repository.findByNome(nome);
    }

}
