package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.AluguelCarro;
import model.entities.Veiculo;
import model.services.AluguelServico;
import model.services.TaxaBrasilServico;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:ss");
		
		System.out.println("Informe o modelo do carro: ");
		String modelo = sc.nextLine();
		System.out.println("Entre com a data do aluguel: ");
		Date dataInicio = sdf.parse(sc.nextLine());
		System.out.println("Entre com a data de retirada do carro: ");
		Date dataFinal = sdf.parse(sc.nextLine());
		
		
				AluguelCarro carro = new AluguelCarro(dataInicio,dataFinal,new Veiculo(modelo));
		
				System.out.println("Informe o preço por hora: ");
				double precoPorHora = sc.nextDouble();
				
				System.out.println("Informe o preço por dia: ");
				double precoPorDia = sc.nextDouble();
				
				 AluguelServico aluguelServico = new AluguelServico(precoPorHora,precoPorDia,new TaxaBrasilServico());
				aluguelServico.processarFatura(carro);
				
				System.out.println("Fatura: ");
				System.out.println("Pagamento Básico: "+String.format("%.2f", carro.getFatura().getPagamentoBasico()));
				System.out.println("Taxa: "+String.format("%.2f", carro.getFatura().getTaxa()));
				System.out.println("Total: "+String.format("%.2f", carro.getFatura().getPagamentoTotal()));
				sc.close();

	}

}
