package com.avattar.testing.servicio.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {

	/**
	 * Funcion: metodo tipos de pago Entrada: el tipo pago | googlepay, paypal y
	 * transferencia salida: mensaje de confirmacion | Objecto {mensaje, importe,
	 * status, proveedor} validacion: limitar tipos de pagos
	 */

	// Patron AAA
	// Arrange, Act, Assert
	// organizamos, ejecucion y afirmacion

	PaymentService servicio;

	// Arrange | Organizar los recursos
	@BeforeEach
	public void setup() {
		servicio = new PaymentService();
	}

	@AfterEach
	public void tearDown() {
		servicio = null;
	}

	// TDD
	// ROJA >> VERDE >> GRIS >> rojo/gris
	@Test
	public void paymentTest() throws Exception {
		// Act
		IPayment resultado = servicio.payment(ETipoPago.GOOGLE_PAY);

		// Assert
		assertNotNull(resultado);
		assertEquals("Operacion GooglePay Existosa.", resultado.doPayment());

	}

	// roja >> verde/gris
	@Test
	public void paymentPaypalTest() throws Exception {
		// Act
		IPayment resultado = servicio.payment(ETipoPago.PAYPAL);

		// Assert
		assertNotNull(resultado);
		assertEquals("Operacion PayPal Existosa.", resultado.doPayment());

	}

	@Test
	public void paymentTransferenciaTest() throws Exception {
		// Act
		IPayment resultado = servicio.payment(ETipoPago.TRANSFERENCIA);

		// Assert
		assertNotNull(resultado);
		assertEquals("Operacion Transferencia Existosa.", resultado.doPayment());

	}

	@Test
	public void paymentMetodoPagoNullTest() {
		// Act
		Exception resultado = assertThrows(NullPointerException.class, () -> servicio.payment(null));

		// Assert
		assertEquals(NullPointerException.class, resultado.getClass());
		assertEquals("El tipo pago es invalido.", resultado.getMessage());

	}

}
