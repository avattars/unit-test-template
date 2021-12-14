package com.avattar.testing.servicio.tdd;

public class PaymentService {

	public IPayment payment(ETipoPago tipoPago) {
		if(null == tipoPago)
			throw new NullPointerException("El tipo pago es invalido.");
		
		switch (tipoPago) {
		case GOOGLE_PAY:
			return new GooglePay();
		case PAYPAL:
			return new PayPal();
		default:
			return new Transferencia();
		}
		
	}
		
}
