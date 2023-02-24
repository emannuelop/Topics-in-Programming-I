package br.unitins.resource;

import java.util.List;

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

@Path("/cachorro")
public class CachorroResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Cachorro addCachorro(Cachorro cachorro) {

        cachorro.persist();
        return cachorro;

    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Cachorro uptadte(@PathParam("id") Long id, Cachorro cachorro) {

        Cachorro entity = Cachorro.findById(id);

        entity.setNome(cachorro.getNome());
        entity.setIdade(cachorro.getIdade());
        entity.setCor(cachorro.getCor());
        entity.setRaca(cachorro.getRaca());
        entity.setPorte(cachorro.getPorte());

        return entity;

    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public void delete(@PathParam("id") Long id) {

        Cachorro cachorro = Cachorro.findById(id);

        if (cachorro.isPersistent())
            cachorro.delete();
            
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cachorro> getAll() {

        return Cachorro.findAll().list();

    }

    @GET
    @Path("/{id}")
    public Cachorro get(@PathParam ("id") Long id) {

        Cachorro cachorro = Cachorro.findById(id);

        if (cachorro.isPersistent())        
            return Cachorro.findById(id);

        return null;
    }

}
