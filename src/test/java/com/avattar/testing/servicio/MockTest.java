package com.avattar.testing.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;//junit 5
import org.mockito.InOrder;
import org.mockito.Mockito;

public class MockTest {

	
	@Test
	public void listaTest() {
		//Arrange
		List<String> lista = new ArrayList<>();
		
		//Act
		lista.add("A");
		
		//Assert
		assertEquals(1, lista.size());
		
	}

	@Test
	public void listaMockTest() {
		//Arrange
		List<String> listaMock = Mockito.mock(List.class);
		
		//Act
		listaMock.add("A");
		/**
		 * Codido de proceso...
		 */
		listaMock.clear();
		
		//Assert
		Mockito.verify(listaMock).clear();
		Mockito.verify(listaMock).add("A");	
		
	}
	

	@Test
	public void listaMockAccionesTest() {
		//Arrange
		List<String> listaMock = Mockito.mock(List.class);
		
		//Act

		listaMock.clear();
		listaMock.add("A");
		/**
		 * Codido de proceso...
		 */
		listaMock.clear();
		
		//Assert
		Mockito.verify(listaMock, times(2)).clear();
		Mockito.verify(listaMock, times(0)).isEmpty();
		Mockito.verify(listaMock).add("A");	
		
	}
	
	@Test
	public void listaMockOtrosTest() {
		//Arrange
		List<String> listaMock = Mockito.mock(List.class);
		
		//Act

		listaMock.clear();
		listaMock.add("A");
		/**
		 * Codido de proceso...
		 */
		listaMock.clear();
		
		//Assert
		Mockito.verify(listaMock, never()).isEmpty();
		Mockito.verify(listaMock, atLeast(1)).clear();
		Mockito.verify(listaMock, atMost(3)).clear();
		
	}
	
	@Test
	public void listaMockOrdenTest() {
		//Arrange
		List<String> listaMock = Mockito.mock(List.class);
		
		//Act

		listaMock.clear();
		listaMock.add("A");
		/**
		 * Codido de proceso...
		 */
		listaMock.isEmpty();
		
		//Assert
		InOrder orden = Mockito.inOrder(listaMock);

		orden.verify(listaMock).clear();
		orden.verify(listaMock).add(Mockito.anyString());
		orden.verify(listaMock).isEmpty();
		
	}
}
