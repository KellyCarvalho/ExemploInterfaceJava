package model.entities;

import java.util.Date;

public class AluguelCarro {
	
	private Date inicio;
	private Date final1;
	
	private Veiculo veiculo;
	private Fatura fatura;
	
	public AluguelCarro() {
		
		
	}
	

	public AluguelCarro(Date inicio, Date final1, Veiculo veiculo) {
	
		this.inicio = inicio;
		this.final1 = final1;
		this.veiculo = veiculo;
	
	}


	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFinal1() {
		return final1;
	}

	public void setFinal1(Date final1) {
		this.final1 = final1;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
	

}