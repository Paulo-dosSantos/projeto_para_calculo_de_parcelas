package services;

public class PaypalService implements ServicoDePagamentoOnline{

	@Override
	public double taxaDePagamento(double valor) {
		return valor*0.02;
	}

	@Override
	public double juros(double valor, int mes) {
		return valor*0.01*mes;
	}
	
	

}
