# Simulador de Crédito

Este projeto é uma API em Java com Spring Boot que simula cenários de empréstimo com base em valor solicitado, data de nascimento e prazo. O sistema retorna valores de parcela, total a pagar e total de juros.

---

## ✅ Tecnologias

- Java 21
- Spring Boot
- Maven
- JUnit 5 (testes)

---

## 🚀 Como rodar o projeto

1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/simulador-credito.git
cd simulador-credito
```

2. Rode o projeto com a classe Application

```
com.simulador.credito
├── Application
```

---

## 📮 Endpoints

### `POST /simulations`

Simula um empréstimo com base nos dados:

#### Exemplo de request:

```json
{
  "loanAmount": 10000.0,
  "birthDate": "1993-07-20",
  "months": 12
}
```

#### Exemplo de resposta:

```json
{
  "totalAmount": 10163.24,
  "monthlyInstallment": 846.94,
  "totalInterest": 163.24
}
```

### Curl da simulação:
```curl
curl --request POST \
  --url http://localhost:8080/simulations \
  --header 'Content-Type: application/json' \
  --data '{
    "loanAmount": 10000,
    "birthDate": "1993-07-20",
    "months": 12
}'
```
---

## 📁 Estrutura do projeto

```
com.simulador.credito
├── controller
├── dto
│   ├── request
│   └── response
├── model (vazio, sem persistência ainda)
├── service
│   └── impl
├── util
└── exception
```

---

## ✨ Melhorias futuras

- Geração de novas propostas
- Autenticação JWT
- Integração com banco de dados
- Validações com Jakarta

  ---

## ⚙️ Configuração do banco quando for implementar (pom.xml)
Já existe configuração no application.yml e uma configuração docker pronta. Quando for integrar com banco, basta adicionar a dependencia e configurar a model.
```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
```
