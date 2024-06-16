package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa{

	private BigDecimal salario;
	private String funcao;
	
	//construtor
	public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
		super(nome,dataNascimento);
		this.funcao = funcao;
		this.salario = salario;
	}
	
	//get e set função
	public String getFuncao() {
		return funcao;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	//get e set salario
	
	public BigDecimal getSalario() {
		return salario;
	}
	
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
}