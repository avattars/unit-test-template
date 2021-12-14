package com.avattar.testing.servicio;

public class Operaciones {

	private ICalculo calculo; 


	private String nombre = "test";
	
	public double formulaGeneral(int a, int b, int c) {

		double resultado;
		// (b^2 + 4ac)
		double dominio = (Math.pow(b, 2) - 4 * a * c);
		// -b +- √ (b^2 + 4ac) / 2
		resultado = -b + Math.sqrt(dominio) / (2 * a);

		if (dominio < 0)// 2, 1, 2
			throw new ArithmeticException("La solucion no es real.");

		return resultado;
	}

	public double division(Object a, Object b) {

		if (null == a || null == b)
			throw new NullPointerException("Valores de entrada son incorrectos.");

		int valueA = Integer.parseInt(a.toString());
		int valueB = Integer.parseInt(b.toString());

		if (valueB == 0)
			throw new ArithmeticException("No se puede dividir un numero entre cero.");

		return valueA / valueB;

	}

	public double sumar(int a, int b) {
		return calculo.suma(a, b);
	}
	
	public String bienvenido(String nombre) {
		return Bienvenido.generarBienvenida(nombre);
	}
	
	public String bienvenido() {
		return Bienvenido.generarBienvenida(nombre);
	}
	
	

}
