package br.insper.eventos.eventos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Eventos {
    @Id
    private String id;
    private String nome;
    private String endereco;
    private String dataehora;
    @Transient
    @JsonIgnore
    private ArrayList<Eventos> locais = new ArrayList<>();

    public ArrayList<Eventos> getEventos() {return locais;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getEndereco() {return endereco;}

    public void setEndereco(String endereco) {this.endereco = endereco;}

    public String getCapacidadde() {return dataehora;}

    public void setCapacidadde(String capacidadde) {this.dataehora = capacidadde;}

    public void setEventos(ArrayList<Eventos> eventos) {this.eventos = eventos;}
}
