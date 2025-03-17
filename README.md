# order-integration
Integration orders with decoupling system using a messaging plataform e database

![image](https://github.com/user-attachments/assets/a6eb701b-624f-4468-afec-71624dbfde9b)

# Instalação

1 - Baixar o repositório e executar o docker da pasta /infra

```
docker compose up
```
# RabbitMQ

1 - Acessar o RabbitMq

`http://localhost:15672/`

```
Username: guest
Password: guest
```

4 - Na aba "Queues and Streams", publicar o seguinte pedido na fila `order-created-queue`

```
{
  "codigoPedido": 1001,
  "codigoCliente": 1,
  "itens": [
    {
      "produto": "lápis",
      "quantidade": 100,
      "preco": 1.10
    },
    {
      "produto": "caderno",
      "quantidade": 10,
      "preco": 1.00
    }
  ]
}

```

# API

1 - Listar todas as ordens do cliente

Request

```
curl --request GET \
  --url 'http://localhost:8080/customers/1/orders?page=0'

```

Response
```
{
  "summary": {
    "totalOnOrders": 1708.8
  },
  "data": [
    {
      "orderId": 1,
      "customerId": 1,
      "total": 120
    },
    {
      "orderId": 2,
      "customerId": 1,
      "total": 1588.8
    }
  ],
  "pagination": {
    "page": 0,
    "pageSize": 10,
    "totalElements": 2,
    "totalPages": 1
  }
}
```

