## Eventos-Inscricoes-Back

# Rotas da API

## Eventos

POST /api/v1/eventos
```json
{
  "nome": "Evento de Tecnologia",
  "endereco": "Av. Paulista, 1000",
  "dataHora": "2024-11-01T10:00",
  "capacidade": 5
}

```
GET /api/v1/eventos
```json
{
    "content": [
        {
            "id": "647a6f9b6b7e6a2b9b6b7e6a",
            "nome": "Evento de Tecnologia",
            "endereco": "Av. Paulista, 1000",
            "dataHora": "2024-11-01T10:00",
            "capacidade": 5,
            "participantes": []
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 20
    },
    "totalElements": 1,
    "totalPages": 1
}
```
POST /api/v1/eventos/{id}/participantes
```json
{
  "joao.silva@email.com"
}
```
GET /api/v1/eventos/{id}/participantes

```json
[
    "joao.silva@email.com"
]
```
DELETE /api/v1/eventos/{id}