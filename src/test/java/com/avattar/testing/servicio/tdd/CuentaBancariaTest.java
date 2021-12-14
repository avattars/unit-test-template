package com.avattar.testing.servicio.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CuentaBancariaTest {

	/**
	 * Entrada: Numero Cuenta y el saldo Salida: saldo | numerico consulta de saldo,
	 * deposito y un retiro
	 * 
	 */

	CuentaBancaria servicio;

	@BeforeEach
	public void setUp() {
		servicio = new CuentaBancaria();

	}

	@AfterEach
	public void tearDown() {
		servicio = null;
	}

	
	// Bandera Roja >> Verde >> gris/refactorizacion
	@DisplayName("getSaldo | Consultar al saldo de una cuenta.")
	@Test
	public void getSaldoTest() {

		double resultado = servicio.getSaldo();

		assertEquals(0.0, resultado);

	}

	// gris
	@Test
	public void depositoTest() throws Exception {

		servicio.deposito(5000.0);

		assertEquals(5000.0, servicio.getSaldo());
	}

	// validacion > verde/gris
	@DisplayName("deposito | No se permite importes menores o iguales a cero.")
	@Test
	public void depositoValidacionImporte() {

		Exception resultado = assertThrows(Exception.class, () -> servicio.deposito(-400.0));

		assertEquals("Importe Incorrecto.", resultado.getMessage());

	}

	// implementacion obvia
	@Test
	public void retiroTest() throws Exception {
		servicio = new CuentaBancaria("1234567", 5000.0);
		servicio.retiro(5000.0);

		assertEquals(0.0, servicio.getSaldo());
	}

	@DisplayName("retiro | Saldo insuficiente")
	@Test
	public void retiroValidacionImporteTest() throws Exception {
		servicio = new CuentaBancaria("1234567", 1000.0);

		try {
			servicio.retiro(5000.0);
			fail();
		} catch (Exception resultado) {
			assertEquals("Saldo Insuficiente.", resultado.getMessage());
		}

	}
	
	@Test
	public void retiroValidacionImporteNegativoTest() throws Exception {
		servicio = new CuentaBancaria("1234567", 1000.0);

		try {
			servicio.retiro(-5000.0);
			fail();
		} catch (Exception resultado) {
			assertEquals("Importe Incorrecto.", resultado.getMessage());
		}

	}
	

}
