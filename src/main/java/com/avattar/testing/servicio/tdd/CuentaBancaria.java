package com.avattar.testing.servicio.tdd;

public class CuentaBancaria {

	/**
	 * CODE
	 **/
	private double saldo = 0.0;
	private String numeroCta;
	
	public CuentaBancaria() {}
	
	public CuentaBancaria(String numeroCuenta, double importe) {
		this.saldo = importe;
		this.numeroCta =  numeroCuenta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void deposito(double importe) throws Exception {
		if(importe <= 0.0)
			throw new Exception("Importe Incorrecto.");
		
		this.saldo += importe;
	}
	
	public void retiro(double importe) throws Exception {
		if(importe <= 0)
			throw new Exception("Importe Incorrecto.");
		if(importe > saldo)
			throw new Exception("Saldo Insuficiente.");
		
		
		this.saldo -= importe;
	}
	
	
	
	
	
	
	
}
