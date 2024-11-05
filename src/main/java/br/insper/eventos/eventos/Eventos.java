package br.insper.eventos.eventos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "eventos")
public class Eventos {
    @Id
    private String id;
    private String nome;
    private String localId;     // Referência ao local cadastrado
    private String localNome;   // Nome do local onde o evento ocorrerá
    private String dataHora;
    private Integer capacidade;
    private ArrayList<String> participantes = new ArrayList<>();

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLocalId() { return localId; }
    public void setLocalId(String localId) { this.localId = localId; }

    public String getLocalNome() { return localNome; }
    public void setLocalNome(String localNome) { this.localNome = localNome; }

    public String getDataHora() { return dataHora; }
    public void setDataHora(String dataHora) { this.dataHora = dataHora; }

    public Integer getCapacidade() { return capacidade; }
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade; }

    public ArrayList<String> getParticipantes() { return participantes; }
    public void setParticipantes(ArrayList<String> participantes) { this.participantes = participantes; }

    public boolean adicionarParticipante(String participante) {
        if (this.participantes.size() >= this.capacidade) {
            return false;
        }
        this.participantes.add(participante);
        return true;
    }
}
