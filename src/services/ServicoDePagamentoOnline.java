package services;

public interface ServicoDePagamentoOnline {
	
	double taxaDePagamento(double valor);
	double juros(double valor, int mes);

}
