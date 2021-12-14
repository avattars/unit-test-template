package com.avattar.testing.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

public class OperacionesTest {

	@InjectMocks
	Operaciones servicio;

	@Mock
	private ICalculo calculo; 

	@BeforeEach
	public void setUp() {
//		servicio = new Operaciones();
		MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	public void tearDown() {
//		servicio = null;
	}

	@Test
	public void formulaGeneralTest() {

		double resultado = servicio.formulaGeneral(2, 9, 4);

		assertNotEquals(0.0, resultado);

	}

	@DisplayName("formulaGeneral | ArithmeticException | La solucion no es real :D")
	@Test
	public void formulaGeneralArithmeticExceptionTest() {

		Exception resultado = assertThrows(ArithmeticException.class, () -> servicio.formulaGeneral(2, 1, 4));

		assertEquals(ArithmeticException.class, resultado.getClass());
		assertEquals("La solucion no es real.", resultado.getMessage());

	}

	@Test
	public void dividirTest() {
		double resultado = servicio.division("2", "2");

		assertEquals(1.0, resultado);
	}

	@Test
	public void dividirNullPointerTest() {
		try {
			servicio.division(null, "2");
			fail();
		} catch (NullPointerException resultado) {
			assertEquals("Valores de entrada son incorrectos.", resultado.getMessage());
		}

	}

	@Test
	public void dividirEntreZeroTest() {
		try {
			servicio.division("2", "0");
			fail();
		} catch (ArithmeticException resultado) {
			assertEquals("No se puede dividir un numero entre cero.", resultado.getMessage());
		}

	}
	
	
	
	@Test
	public void sumaTest() {
		
		Mockito.when(calculo.suma(Mockito.anyInt(), Mockito.anyInt()))
		.thenReturn(4.0);
		
		double resultado = servicio.sumar(2, 2);
		
		assertEquals(4.0, resultado);
	}
	
	@Test
	public void bienvenidoTest() {
		
		try (MockedStatic<Bienvenido> mock =  Mockito.mockStatic(Bienvenido.class)) {
			mock.when(() -> Bienvenido.generarBienvenida(Mockito.anyString())).thenReturn("Bienvenido Juan");
			
			String resultado = servicio.bienvenido("Fredy");
			
			assertEquals("Bienvenido Juan", resultado);
		} 
		
		assertEquals("Bienvenido Fredy", servicio.bienvenido("Fredy"));

		
	}
	
	
	@Test
	public void bienvenidoVariablePrivadaTest() {
		
		ReflectionTestUtils.setField(servicio, "nombre", "Fredy");
		
		assertEquals("Bienvenido Fredy", servicio.bienvenido());

		
	}
	
	
	

}
