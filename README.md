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
Aqui foi criado umna lista de objetos

        List<Funcionario> funcionarios = new ArrayList<>();
		//inserir os Dados na seguencia 
		funcionarios.add(new Funcionario(NOMW, LocalDate.of(DATA), new BigDecimal(SALARIO), FUNÇÃO));
  
### 2. Remoção de Funcionário
Remoção do funcionário "João" da lista.
    funcionarios.removeIf(f -> f.getNome().equals("João"));
    
Funcionamento
    - Iteração: O método removeIf iterará sobre cada Funcionario na lista funcionarios.
    - Avaliação: Para cada Funcionario, a expressão lambda f -> f.getNome().equals("João") será avaliada.
    - Para o funcionário cujo nome é "João", a expressão retornará true.
    - Para todos os outros funcionários, a expressão retornará false.
    - Remoção: removeIf removerá da lista todos os funcionários para os quais a expressão lambda retornou true.
    
Resumo:
Remove da lista funcionarios todos os funcionários cujo nome é exatamente "João". Utiliza a função removeIf da interface Collection com uma expressão lambda que compara o nome de cada funcionário com a string "João".

### 3. Impressão de Funcionários
Impressão de todos os funcionários com todas as suas informações, com formatação específica para data (dd/MM/yyyy) e valores numéricos (separador de milhar como ponto e decimal como vírgula).
    private static void imprimirFuncionarios(List<Funcionario> funcionarios) {
        for (Funcionario f : funcionarios) {
            String dataNascimento = f.getDataNascimento().format(FORMATTER);
            String salario = formatarSalario(f.getSalario());
            System.out.println(f.getNome() + " - " + dataNascimento + " - " + salario + " - " + f.getFuncao());
        }
    }
    
Funcionamento
    - Iteração: Itera sobre cada funcionário na lista.
    - Formatação: Formata a data de nascimento e o salário para facilitar a leitura e apresentação.
    - Impressão: Imprime os detalhes formatados de cada funcionário no console.
    
Resumo
Em resumo, o método imprimirFuncionarios:
    1. Itera sobre a lista de funcionários.
    2. Formata a data de nascimento e o salário de cada funcionário.
    3. Imprime os detalhes formatados (nome, data de nascimento, salário e função) de cada funcionário no console.

### 4. Aumento Salarial
Aplicação de um aumento de 10% no salário de todos os funcionários.
    for (Funcionario f : funcionarios) {
        BigDecimal novoSalario = f.getSalario().multiply(new BigDecimal("1.10"));
        f.setSalario(novoSalario);
    }
    
Funcionamento
    - Iteração: O loop for-each percorre cada Funcionario na lista funcionarios.
    - Cálculo do Novo Salário: Para cada Funcionario:
        - Obtém o salário atual usando f.getSalario().
        - Calcula o novo salário multiplicando o salário atual por 1.10 para aplicar um aumento de 10%.
        - Armazena o resultado na variável novoSalario.
    - Atualização do Salário: Usa o método setSalario para atualizar o salário do funcionário para novoSalario.

### 5. Agrupamento por Função
Agrupamento dos funcionários por função em um `Map`, onde a chave é a função e o valor é a lista de funcionários.
     Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
		
Funcionamento
    - Stream API: Utiliza a Stream API do Java para processar a lista de funcionários de maneira funcional.
    - Agrupamento: Agrupa os funcionários por suas funções usando o Collector groupingBy.
    - Resultado: O resultado é um mapa onde cada chave é uma função e o valor associado é uma lista de funcionários que têm essa função.
    
Passo a Passo
    1. Criação do Stream: Converte a lista original funcionarios em um stream.
    2. Agrupamento por Função: Usa o Collector groupingBy para agrupar os funcionários por suas funções.
    3. Criação do Mapa: O resultado da coleta é um mapa onde cada chave é uma função e o valor é uma lista de funcionários que têm essa função.
    
Resumo
Em resumo, esta linha de código:
    1. Converte a lista de funcionários em um stream.
    2. Usa o Collector groupingBy para agrupar os funcionários por suas funções.
    3. Cria um mapa onde cada chave é uma função e o valor é uma lista de funcionários que têm essa função.

### 6. Impressão Agrupada por Função
Impressão dos funcionários agrupados por função.

    private static void imprimirFuncionariosAgrupadosPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao) {
    for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
        System.out.println("Função: " + entry.getKey());
        for (Funcionario f : entry.getValue()) {
            System.out.println(" - " + f.getNome());
        }
    }
}

Funcionamento
    - Iteração pelo Map: O método itera sobre cada entrada (função e lista de funcionários) no Map funcionariosPorFuncao.
    - Impressão da Função: Para cada entrada, imprime a função.
    - Iteração pela Lista de Funcionários: Para cada função, itera sobre a lista de funcionários associados.
    - Impressão dos Nomes dos Funcionários: Para cada funcionário na lista, imprime o nome do funcionário.
    
Resumo
Em resumo, o método imprimirFuncionariosAgrupadosPorFuncao:
    1. Recebe um Map onde as chaves são funções e os valores são listas de funcionários.
    2. Itera sobre cada entrada no Map.
    3. Para cada entrada:
        - Imprime a função.
        - Itera sobre a lista de funcionários associados à função.
        - Imprime o nome de cada funcionário na lista.

### 7. Aniversariantes
Impressão dos funcionários que fazem aniversário nos meses 10 (outubro) e 12 (dezembro).

    private static void imprimirAniversariantes(List<Funcionario> funcionarios, int... meses) {
    Set<Integer> mesesSet = Arrays.stream(meses).boxed().collect(Collectors.toSet());
    for (Funcionario f : funcionarios) {
        int mes = f.getDataNascimento().getMonthValue();
        if (mesesSet.contains(mes)) {
            System.out.println(f.getNome());
        }
    }
}

Funcionamento
    - Conversão dos Meses: Os meses passados como parâmetros são convertidos para um Set<Integer> chamado mesesSet.
    - Iteração pela Lista de Funcionários: O método itera sobre cada Funcionario na lista funcionarios.
    - Obtendo e Verificando o Mês de Nascimento: Para cada Funcionario, obtém o mês de nascimento e verifica se está contido em mesesSet.
    - Impressão do Nome: Se o mês de nascimento do funcionário estiver em mesesSet, imprime o nome do funcionário.
    
Resumo
Em resumo, o método imprimirAniversariantes:
    1. Converte os meses passados como parâmetros em um Set de inteiros.
    2. Itera sobre a lista de funcionários.
    3. Para cada funcionário:
        - Obtém o mês de nascimento.
        - Verifica se o mês está no conjunto de meses especificados.
        - Imprime o nome do funcionário se o mês de nascimento estiver no conjunto.

### 8. Funcionário com Maior Idade
Impressão do funcionário com a maior idade, exibindo os atributos: nome e idade.

    private static void imprimirFuncionarioMaisVelho(List<Funcionario> funcionarios) {
        Funcionario maisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);
        if (maisVelho != null) {
            int idade = LocalDate.now().getYear() - maisVelho.getDataNascimento().getYear();
            System.out.println("\nFuncionário com maior idade:");
            System.out.println(maisVelho.getNome() + " - " + idade + " anos");
        }
    }
    
Funcionamento
    - Stream API: Utiliza a Stream API do Java para processar a lista de funcionários de maneira funcional.
    - Comparador: Usa um Comparator para encontrar o funcionário com a data de nascimento mais antiga.
    - Calculo da Idade: Calcula a idade aproximada do funcionário mais velho com base no ano atual.
    - Impressão Condicional: Verifica se o funcionário mais velho não é null antes de imprimir suas informações.
    
Resumo
Em resumo, o método imprimirFuncionarioMaisVelho:
    1. Converte a lista de funcionários em um stream.
    2. Encontra o funcionário com a data de nascimento mais antiga.
    3. Calcula a idade do funcionário mais velho.
    4. Imprime o nome e a idade do funcionário mais velho, se a lista de funcionários não estiver vazia.

### 9. Ordenação Alfabética
Impressão da lista de funcionários em ordem alfabética.
    List<Funcionario> funcionariosOrdenados = funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());
		
Funcionamento
    - Stream API: Utiliza a Stream API do Java para processar a lista de funcionários.
    - Comparator: Usa um Comparator para definir a lógica de ordenação baseada nos nomes dos funcionários.
    - Coletor: Coleta os elementos do stream ordenado em uma nova lista.
    
Passo a Passo
    1. Criação do Stream: Converte a lista original funcionarios em um stream.
    2. Ordenação: Ordena o stream de funcionários por nome em ordem alfabética.
    3. Coleta: Coleta os elementos ordenados do stream em uma nova lista.
    4. Atribuição: Atribui a nova lista ordenada à variável funcionariosOrdenados.
    
Resumo
Em resumo, a linha de código:
    1. Converte a lista de funcionários em um stream.
    2. Ordena os funcionários por nome em ordem alfabética usando um Comparator.
    3. Coleta os funcionários ordenados em uma nova lista.
    4. Atribui essa nova lista à variável funcionariosOrdenados.

### 10. Total de Salários
Impressão do total dos salários dos funcionários.
    private static void imprimirTotalSalarios(List<Funcionario> funcionarios) {
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal dos salários: " + formatarSalario(totalSalarios));
    }
    
Funcionamento
    - Stream API: Utliza a Stream API do Java para processar a lista de funcionários de maneira funcional.
    - Mapeamento: Usa a operação de mapeamento para extrair os salários dos funcionários.
    - Redução: Usa a operação de redução para somar todos os salários e calcular o total.
    - Impressão: Imprime o total dos salários no console.
    
Passo a Passo
    1- Criação do Stream: Converte a lista original funcionarios em um stream.
    2- Mapeamento dos Salários: Extrai os salários dos funcionários e cria um stream de BigDecimal contendo esses salários.
    3- Redução para o Total: Soma todos os salários no stream, resultando no total dos salários.
    4- Impressão do Total: Formata e imprime o total dos salários no console.
    
Resumo
Em resumo, o método imprimirTotalSalarios:
    1. Converte a lista de funcionários em um stream.
    2. Extrai os salários dos funcionários usando a operação de mapeamento.
    3. Soma todos os salários usando a operação de redução para calcular o total.
    4. Imprime o total dos salários formatado no console.

### 11. Salários em Múltiplos de Salário Mínimo
Impressão de quantos salários mínimos cada funcionário ganha, considerando o salário mínimo de R$ 1212,00.

    private static void imprimirSalariosEmSalariosMinimos(List<Funcionario> funcionarios) {
            System.out.println("\nSalários em relação ao salário mínimo:");
            for (Funcionario f : funcionarios) {
                BigDecimal qtdSalariosMinimos = calcularSalariosMinimos(f.getSalario(), SALARIO_MINIMO);
                System.out.println(f.getNome() + " - " + qtdSalariosMinimos + " salários mínimos");
            }
        }
	
Resumo
Em resumo, o método imprimirSalariosEmSalariosMinimos:
    1. Itera sobre a lista de funcionários.
    2. Calcula quantos salários mínimos cada funcionário ganha.
    3. Imprime o nome do funcionário e a quantidade de salários mínimos que ele ganha.
