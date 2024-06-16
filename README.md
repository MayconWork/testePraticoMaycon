# Desafio de Projeto Java

## Descrição do Projeto

Este projeto em Java foi desenvolvido para atender aos requisitos de manipulação e gestão de uma lista de funcionários de uma indústria. O projeto inclui a implementação de classes para representar pessoas e funcionários, além de diversas funcionalidades para manipulação de dados dos funcionários.

## Estrutura do Projeto

O projeto está organizado nas seguintes classes:

1. **Classe `Pessoa`**:
    - Atributos: `nome` (String) e `dataNascimento` (LocalDate).

2. **Classe `Funcionario`** (extende a classe `Pessoa`):
    - Atributos adicionais: `salario` (BigDecimal) e `funcao` (String).

3. **Classe `Principal`**:
    - Executa diversas ações para manipulação da lista de funcionários.

## Funcionalidades Implementadas

### 1. Inserção de Funcionários
Inserção de todos os funcionários na mesma ordem e com as mesmas informações especificadas na tabela inicial.

### 2. Remoção de Funcionário
Remoção do funcionário "João" da lista.

### 3. Impressão de Funcionários
Impressão de todos os funcionários com todas as suas informações, com formatação específica para data (dd/MM/yyyy) e valores numéricos (separador de milhar como ponto e decimal como vírgula).

### 4. Aumento Salarial
Aplicação de um aumento de 10% no salário de todos os funcionários.

### 5. Agrupamento por Função
Agrupamento dos funcionários por função em um `Map`, onde a chave é a função e o valor é a lista de funcionários.

### 6. Impressão Agrupada por Função
Impressão dos funcionários agrupados por função.

### 7. Aniversariantes
Impressão dos funcionários que fazem aniversário nos meses 10 (outubro) e 12 (dezembro).

### 8. Funcionário com Maior Idade
Impressão do funcionário com a maior idade, exibindo os atributos: nome e idade.

### 9. Ordenação Alfabética
Impressão da lista de funcionários em ordem alfabética.

### 10. Total de Salários
Impressão do total dos salários dos funcionários.

### 11. Salários em Múltiplos de Salário Mínimo
Impressão de quantos salários mínimos cada funcionário ganha, considerando o salário mínimo de R$ 1212,00.
