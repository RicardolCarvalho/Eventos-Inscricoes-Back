package br.insper.eventos.locais;

record CadastraLocaisDTO (String nome, String endereco, Integer capacidade) {
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public Integer getCapacidadde() {
        return capacidade;
    }
}

record RetornarLocaisDTO (String nome, String endereco, Integer capacidade) {

}