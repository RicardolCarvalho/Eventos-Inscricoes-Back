package br.insper.eventos.locais;

import br.insper.eventos.eventos.Eventos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "locais")
public class Locais {
    @Id
    private String id;
    private String nome;
    private String endereco;
    private Integer capacidade;
    @Transient
    @JsonIgnore
    private ArrayList<Eventos> eventos = new ArrayList<>();

    public String getId() { return id; } // Getter para o ID
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public Integer getCapacidade() { return capacidade; } // Nome do getter corrigido
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade; }

    public ArrayList<Eventos> getEventos() { return eventos; }
    public void setEventos(ArrayList<Eventos> eventos) { this.eventos = eventos; }
}
