package br.insper.eventos.eventos;

import java.util.ArrayList;

record CadastrarEventoDTO(String nome, String localId, String dataHora, Integer capacidade) {}

record RetornarEventoDTO(String id, String nome, String localId, String localNome, String dataHora, Integer capacidade, ArrayList<String> participantes) {}