package com.franciscoleiva.teste.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Transferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private int contaOrigem;
	@Column(nullable = false)
	private int contaDestino;
	@Column(nullable = false)
	private double valorTransferencia;
	@Column(nullable = false)
	private double taxa;
	@Column(nullable = false)
	private LocalDate dataTransferencia;
	@Column(nullable = false)
	private LocalDate dataAgendamento;
	@Column(nullable = false)

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(int contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public int getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(int contaDestino) {
		this.contaDestino = contaDestino;
	}

	public double getValorTransferencia() {
		return valorTransferencia;
	}

	public void setValorTransferencia(double valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(LocalDate dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transferencia other = (Transferencia) obj;
		return Objects.equals(id, other.id);
	}

}
