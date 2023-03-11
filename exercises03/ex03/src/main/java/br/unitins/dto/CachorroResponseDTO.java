package br.unitins.dto;

import java.util.HashMap;
import java.util.Map;

import br.unitins.model.Cachorro;

public class CachorroResponseDTO {

    private Long id;
    private String nome;
    private Map<String, Object> dono;

    public CachorroResponseDTO(Cachorro cachorro) {
        this.id = cachorro.getId();
        this.nome = cachorro.getNome();
        this.dono = new HashMap<String, Object>();

        this.dono.put("nome", cachorro.getDono().getNome());
        this.dono.put("sexo", cachorro.getDono().getSexo());
        this.dono.put("sexo", cachorro.getDono().getCpf());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, Object> getDono() {
        return dono;
    }

    public void setDono(Map<String, Object> dono) {
        this.dono = dono;
    }

}
