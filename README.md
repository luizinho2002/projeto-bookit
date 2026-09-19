# 🏨 BookIt - Sistema de Gestão de Reservas

[![Java](https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=java)](https://www.java.com)
[![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)](LICENSE)

O **BookIt** é uma aplicação Java desenvolvida em arquitetura limpa, focada no domínio de gestão de reservas de acomodações. O projeto foi projetado do zero em **Java puto**, sem dependência de frameworks externos, priorizando conceitos fundamentais da linguagem, imutabilidade, manipulação de coleções funcionais e execução via linha de comando (CLI).

---

## 📌 Funcionalidades Principais

- 📝 **Criação de Reservas:** Associação entre clientes, acomodações e intervalos de datas.
- 🔍 **Busca por CPF:** Filtragem dinâmica de reservas por documento do cliente utilizando **Stream API**.
- 🛡️ **Garantia de Unicidade:** Camada de repositório isolada com validação de existência e armazenamento em memória.
- 💻 **Execução via Terminal:** Compilação e execução totalmente nativas através de scripts de CLI.

---

## 🏗️ Arquitetura e Decisões de Design

A aplicação segue uma separação clara de responsabilidades dividida nos seguintes pacotes:

```text
br.com.bookit/
├── model/        # DTOs e entidades imutáveis (Records)
├── repository/   # Camada de persistência em memória
├── service/      # Regras de negócio e casos de uso
└── Main.java     # Ponto de entrada e execução da CLI
```

### Principais Tecnologias e Conceitos Utilizados

- **Java Records:** Utilizados em `ClienteDTO`, `AcomodacaoDTO` e `Reserva` para garantir a imutabilidade dos dados e eliminar código boilerplate (`getters`, `equals`, `hashCode`, `toString`).
- **Injeção de Dependência:** O `ReservaService` recebe o `ReservaRepository` via construtor, promovendo o desacoplamento e facilitando testes unitários.
- **Stream API:** Processamento funcional de dados para busca e filtragem eficiente.

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

- **Java JDK 17** ou superior instalado.
- Terminal / Linha de comandos (Linux, macOS ou WSL/PowerShell no Windows).

### Passo a Passo


1. **Clonar o repositório:**   
git clone https://github.com/SEU_USUARIO/projeto-bookit.git  
cd projeto-bookit

2. **Navegar até o diretório do código-fonte:**  
cd src/main/java

3. **Compilar os arquivos `java`:**  
find . -name "*.java" | xargs javac

4. **Executar a aplicação:**  
java br.com.bookit.Main

---

## 🖥️ Exemplo de Saída no Terminal

Ao executar o método principal, a aplicação inicializa o repositório, realiza o registro de teste e exibe a consulta formatada:

--- Testando Busca por CPF ---  
Reserva ID: 1  
Cliente: Luiz  
Acomodação: Chalé de Montanha  
Entrada: 2026-09-18 | Saída: 2026-09-21

---

## 📄 Licença

Este projeto está sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.

---

Developed by **Luiz**
