# Sistema de Simulação e Proposta de Empréstimos Futura

## 1. Arquitetura do Sistema

### Componentes Principais

- **Frontend (Web ou Mobile)**  
  Interface para entrada de dados do usuário.

- **API Gateway (opcional)**  
  Autenticação e roteamento.

- **Backend (Spring Boot)**  
  - Camada de simulação
  - Camada de geração de propostas
  - Camada de autenticação/autorização

- **Banco de Dados (MySQL/PostgreSQL)**  
  Armazena simulações, propostas e usuários.

### Fluxo de Dados

Usuário → Frontend → Backend → Simulação → Proposta → Resposta

---
## 2.a Desenho da arquitetura.
<img width="695" height="364" alt="image" src="https://github.com/user-attachments/assets/b64588b3-b0a7-4ec9-bfec-baf775c17667" />

## 2.b Padrões de Projeto e Boas Práticas

- MVC
- DTOs + Mappers
- Service com interface
- Spring Security + JWT

---

## 2.c Escalabilidade

- Fila assíncrona (Kafka) para grande volume
- Índices no banco para campos críticos
- Microsserviços em fase futura

---

## 2.d API Design

### POST `/simulations`

**Simula cenários de empréstimo**

#### Request:
```json
{
    "loanAmount": 10000,
    "birthDate": "1993-07-20",
    "months": 12
}
```

#### Response:
```json
{
  "scenarios": [
    { "interestRate": 0.02, "monthlyPayment": 675.45 },
    { "interestRate": 0.03, "monthlyPayment": 696.89 },
    { "interestRate": 0.04, "monthlyPayment": 718.34 }
  ]
}
```

---

### POST `/proposals`

**Gera uma proposta de empréstimo personalizada**

#### Request:
```json
{
  "userId": "abc123",
  "chosenScenario": { "interestRate": 0.03, "monthlyPayment": 696.89 }
}
```

#### Response:
```json
{
  "proposalId": "PROP-7890",
  "status": "PRE_APPROVED",
  "expiresAt": "2025-07-25T23:59:59"
}
```
