package services;

import java.time.LocalDate;

import entities.Contrato;
import entities.Parcela;

public class ServicoDeContrato {
	
	private ServicoDePagamentoOnline servicoDePagamentoOnline;

	public ServicoDeContrato(ServicoDePagamentoOnline servicoDePagamentoOnline) {
		super();
		this.servicoDePagamentoOnline = servicoDePagamentoOnline;
	}

	public ServicoDePagamentoOnline getServicoDePagamentoOnline() {
		return servicoDePagamentoOnline;
	}

	public void setServicoDePagamentoOnline(ServicoDePagamentoOnline servicoDePagamentoOnline) {
		this.servicoDePagamentoOnline = servicoDePagamentoOnline;
	}
	
	public void processarContrato(Contrato contrato, int meses) {
		double valorBasico= contrato.getValorTotal()/meses;
		
		for(int i=1;i<=meses;i++) {
			LocalDate data= contrato.getData().plusMonths(i);
			double juros= servicoDePagamentoOnline.juros(valorBasico, i);
			double taxa= servicoDePagamentoOnline.taxaDePagamento(valorBasico+juros);
			double total= valorBasico+juros+taxa;
			
			contrato.getParcelas().add(new Parcela(data, total));
		}
	}
	

}
