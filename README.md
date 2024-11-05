## Eventos-Inscricoes-Back

# Rotas da API

## Eventos

POST /api/v1/eventos
```json
{
  "nome": "Workshop de Tecnologia",
  "localId": "672a22a733d1cf77dd680664",
  "dataHora": "2024-12-01T15:30",
  "capacidade": 100
}


```
GET /api/v1/eventos
```json
{
  "content": [
    {
      "id": "672a2b2698b61f76360714d6",
      "nome": "Workshop de Tecnologia",
      "localId": "672a22a733d1cf77dd680664",
      "localNome": "Auditório Principal",
      "dataHora": "2024-12-01T15:30",
      "capacidade": 100,
      "participantes": [
        "joao.silva@email.com"
      ]
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 20,
    "sort": {
      "empty": true,
      "sorted": false,
      "unsorted": true
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "last": true,
  "totalPages": 1,
  "totalElements": 1,
  "size": 20,
  "number": 0,
  "sort": {
    "empty": true,
    "sorted": false,
    "unsorted": true
  },
  "numberOfElements": 1,
  "first": true,
  "empty": false
}
```
# o id deve ser o id do evento

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

## Locais

POST /api/v1/locais
```json
{
  "nome": "Auditório Principal",
  "endereco": "Rua das Flores, 123",
  "capacidade": 200
}
```
GET /api/v1/locais
```json
{
  "content": [
    {
      "nome": "Auditório Principal",
      "endereco": "Rua das Flores, 123",
      "capacidadde": 200
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 20,
    "sort": {
      "empty": true,
      "sorted": false,
      "unsorted": true
    },
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "last": true,
  "totalPages": 1,
  "totalElements": 1,
  "size": 20,
  "number": 0,
  "sort": {
    "empty": true,
    "sorted": false,
    "unsorted": true
  },
  "numberOfElements": 1,
  "first": true,
  "empty": false
}
```
# o id deve ser o id do local
DELETE /api/v1/locais/{id}

Get /api/v1/locais/{id}/relatorio
```json
"Nenhum evento foi realizado neste local."
```
