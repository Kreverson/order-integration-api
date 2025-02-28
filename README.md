# order-integration
Integration orders with decoupling system using a messaging plataform e database

![image](https://github.com/user-attachments/assets/a6eb701b-624f-4468-afec-71624dbfde9b)

# Instalação

1 - Baixar o repositório e executar o docker da pasta /infra

```
docker compose up
```

2 - Executar o projeto

3 - Acessar o RabbitMq

`http://localhost:15672/`

4 - Publicar o seguinte pedido

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

5 - Executar um request

```
curl --location 'http://localhost:8080/customers/1/orders?page=0'

```

