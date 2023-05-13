package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contrato;
import entities.Parcela;
import services.PaypalService;
import services.ServicoDeContrato;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Entre com os dados do contrato: ");
		System.out.print("Número: ");
		int numero=sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate data= LocalDate.parse(sc.next(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.print("Valor do contrato: ");
		double valor=sc.nextDouble();
		Contrato contrato= new Contrato(numero, data, valor);
		System.out.print("Entre com o número de parcelas: ");
		int quantidadeDeParcelas=sc.nextInt();
		ServicoDeContrato servico= new ServicoDeContrato(new PaypalService());
		servico.processarContrato(contrato, quantidadeDeParcelas);
		
		System.out.println("Parcelas: ");
		for(Parcela p: contrato.getParcelas()) {
			System.out.println(p);
		}
		
		
		
		
		
		
		
		sc.close();

	}

}
