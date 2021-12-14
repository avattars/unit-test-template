package com.avattar.testing.servicio;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Bienvenido {

	private static final String bienvenido = "Bienvenido";
	
	public static String generarBienvenida(String nombre) {
		return String.format(bienvenido+" %s", nombre);
	}

	public static List<Integer> range(int start, int end) {
		return IntStream.range(start, end).boxed().collect(Collectors.toList());
	}
	
}
