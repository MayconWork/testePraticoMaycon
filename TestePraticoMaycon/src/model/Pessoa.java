package model;

import java.time.LocalDate;

public class Pessoa {

	private String nome;
	private LocalDate dataNascimento;
	
	//construtor
	public Pessoa(String Nome, LocalDate dataNascimento) {
		this.nome = Nome;
		this.dataNascimento = dataNascimento;
	}
	
	// Getters e Setters Nome
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;		
	}
	
	// Getters e Setters DataNascimento
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}