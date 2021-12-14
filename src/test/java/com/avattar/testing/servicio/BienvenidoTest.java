package com.avattar.testing.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class BienvenidoTest {


	
	
	@Test
	public void generaBienvenidaTest() {
		
		assertEquals("Bienvenido fredy", Bienvenido.generarBienvenida("fredy"));
		
		try (MockedStatic<Bienvenido> mock = Mockito.mockStatic(Bienvenido.class)) {
		
			mock.when(() -> Bienvenido.generarBienvenida("fredy"))
			.thenReturn("Hola Mundo");
			
			assertEquals("Hola Mundo", Bienvenido.generarBienvenida("fredy"));

		} 
		
		assertEquals("Bienvenido fredy", Bienvenido.generarBienvenida("fredy"));

		
	}
	
	@Test
	public void rangeTest() {
		List<Integer> lista = Bienvenido.range(2, 6);
		
		assertEquals(4, lista.size());
		
		try (MockedStatic<Bienvenido> mock =  Mockito.mockStatic(Bienvenido.class)) {
			List<Integer> listaTemp = new ArrayList<>();
			
			mock.when(() -> Bienvenido.range(2,  6)).thenReturn(listaTemp);
			
			assertEquals(0, Bienvenido.range(2, 6).size());

		} 
		
	}
	
	
	
	
	
}
