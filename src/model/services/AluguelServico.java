package model.services;

import model.entities.AluguelCarro;
import model.entities.Fatura;

public class AluguelServico {

	private double precoPorHora;
	private double precoPorDia;
	private TaxaServico taxaServico;
	public AluguelServico() {
	
	}
	public AluguelServico(double precoPorHora, double precoPorDia, TaxaBrasilServico taxaServico) {
		super();
		this.precoPorHora = precoPorHora;
		this.precoPorDia = precoPorDia;
		this.taxaServico = taxaServico;
	}
	
	public void processarFatura(AluguelCarro aluguelCarro) {
		
		long t1 = aluguelCarro.getInicio().getTime();
		long t2 = aluguelCarro.getFinal1().getTime();
		double horas =(double)(t2-t1)/1000/60/60;
		
		double pagamentoBasico;
		if(horas<=12) {
			 pagamentoBasico = Math.ceil(horas)*precoPorHora;
		}else {
			 pagamentoBasico = Math.ceil(horas/24)*precoPorDia;

		}
		double taxa = taxaServico.taxa(pagamentoBasico);
		aluguelCarro.setFatura(new Fatura(pagamentoBasico,taxa));
	}
	
}
