package app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import model.Funcionario;

public class Principal {
	
	private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static void main(String[] args) {
		List<Funcionario> funcionarios = new ArrayList<>();

		//inserir os Dados na seguencia 
		funcionarios.add(new Funcionario("Maria", LocalDate.of(2000,10,18), new BigDecimal("2009.44"), "Operador"));
		funcionarios.add(new Funcionario("João", LocalDate.of(1990,05,12), new BigDecimal("2284.38"), "Operador"));
		funcionarios.add(new Funcionario("Caio", LocalDate.of(1961,05,02), new BigDecimal("9836.14"), "Coordenador"));
		funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
	    funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
	    funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
	    funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
	    funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
	    funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
	    funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // 3.1.1 – Imprimir todos os funcionários inseridos na lista
        System.out.println("Funcionários inseridos:");
        imprimirFuncionarios(funcionarios);

        // 3.2 – Remover o funcionário “João” da lista.
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        // 3.3 – Imprimir todos os funcionários com todas suas informações após remoção do João
        System.out.println("\nFuncionários após remoção do João:");
        imprimirFuncionarios(funcionarios);

        // 3.4 – Aumentar salário em 10%
        for (Funcionario f : funcionarios) {
            BigDecimal novoSalario = f.getSalario().multiply(new BigDecimal("1.10"));
            f.setSalario(novoSalario);
        }

        // 3.5 – Agrupar por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // 3.6 – Imprimir agrupados por função
        System.out.println("\nFuncionários agrupados por função:");
        imprimirFuncionariosAgrupadosPorFuncao(funcionariosPorFuncao);

        // 3.8 – Imprimir aniversariantes dos meses 10 e 12
        System.out.println("\nAniversariantes dos meses 10 e 12:");
        imprimirAniversariantes(funcionarios, 10, 12);

        // 3.9 – Imprimir funcionário com maior idade
        imprimirFuncionarioMaisVelho(funcionarios);

        // 3.10 – Imprimir lista de funcionários por ordem alfabética
        System.out.println("\nFuncionários em ordem alfabética:");
        List<Funcionario> funcionariosOrdenados = funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());
        imprimirFuncionarios(funcionariosOrdenados);

        // 3.11 – Imprimir total dos salários
        imprimirTotalSalarios(funcionarios);

        // 3.12 – Imprimir quantos salários mínimos ganha cada funcionário
        imprimirSalariosEmSalariosMinimos(funcionarios);
    }

    private static void imprimirFuncionarios(List<Funcionario> funcionarios) {
        for (Funcionario f : funcionarios) {
            String dataNascimento = f.getDataNascimento().format(FORMATTER);
            String salario = formatarSalario(f.getSalario());
            System.out.println(f.getNome() + " - " + dataNascimento + " - " + salario + " - " + f.getFuncao());
        }
    }

    private static void imprimirFuncionariosAgrupadosPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao) {
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            System.out.println("Função: " + entry.getKey());
            for (Funcionario f : entry.getValue()) {
                System.out.println(" - " + f.getNome());
            }
        }
    }

    private static void imprimirAniversariantes(List<Funcionario> funcionarios, int... meses) {
        Set<Integer> mesesSet = Arrays.stream(meses).boxed().collect(Collectors.toSet());
        for (Funcionario f : funcionarios) {
            int mes = f.getDataNascimento().getMonthValue();
            if (mesesSet.contains(mes)) {
                System.out.println(f.getNome());
            }
        }
    }

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

    private static void imprimirTotalSalarios(List<Funcionario> funcionarios) {
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal dos salários: " + formatarSalario(totalSalarios));
    }

    private static void imprimirSalariosEmSalariosMinimos(List<Funcionario> funcionarios) {
        System.out.println("\nSalários em relação ao salário mínimo:");
        for (Funcionario f : funcionarios) {
            BigDecimal qtdSalariosMinimos = calcularSalariosMinimos(f.getSalario(), SALARIO_MINIMO);
            System.out.println(f.getNome() + " - " + qtdSalariosMinimos + " salários mínimos");
        }
    }

    private static BigDecimal calcularSalariosMinimos(BigDecimal salario, BigDecimal salarioMinimo) {
        return salario.divide(salarioMinimo, 2, RoundingMode.HALF_UP);
    }

    private static String formatarSalario(BigDecimal salario) {
        return String.format("%,.2f", salario);
    }
}
