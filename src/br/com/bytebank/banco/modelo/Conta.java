package br.com.bytebank.banco.modelo;

/**
 * Classe representa a moldura de uma conta
 * @author Caroline Araujo
 *
 */

public abstract class Conta {
	double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total = 0;
	
	/**
	 * Construtor para inicializar o objeto Conta a partir da agencia e numero
	 * @param agencia
	 * @param numero
	 */
	
	public Conta(int agencia, int numero) {
		Conta.total++;
		System.out.println("o total de controle é " + Conta.total);
		this.agencia = agencia;
		this.numero = numero;
		System.out.println("Estou criando uma conta " + this.numero);
	}
	
	public abstract void deposita(double valor);
	
	/**
	 * Valor precisa ser maior do que o saldo
	 * @param valor
	 * @throws SaldoInsuficienteException
	 */
	
	public void saca(double valor) throws SaldoInsuficienteException{
	
		if(this.saldo < valor) {
			throw new SaldoInsuficienteException("Saldo: " + this.saldo + ", Valor: " + valor);
		}
		
		this.saldo += valor;
	}
	
	public void transfere(double valor, Conta destino) throws SaldoInsuficienteException{
		this.saca(valor);
		destino.deposita(valor);
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public static int getTotal() {
		return total;
	}

	public static void setTotal(int total) {
		Conta.total = total;
	}

	public double getValorImposto() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
