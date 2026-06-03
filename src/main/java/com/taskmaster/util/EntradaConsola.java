package com.taskmaster.util;

import java.util.Scanner;

/**
 * Clase auxiliar para gestionar la lectura de datos por consola.
 *
 * @author Felipe
 * @version 1.0
 */
public class EntradaConsola {

    private final Scanner scanner;

    /**
     * Crea una nueva entrada por consola.
     *
     * @param scanner scanner compartido para la lectura de datos
     */
    public EntradaConsola(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Lee texto desde consola mostrando un mensaje.
     *
     * @param mensaje mensaje a mostrar
     * @return texto introducido por el usuario
     */
    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    /**
     * Lee un número entero desde consola mostrando un mensaje.
     *
     * @param mensaje mensaje a mostrar
     * @return número entero introducido por el usuario
     */
    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Lee un número decimal desde consola mostrando un mensaje.
     *
     * @param mensaje mensaje a mostrar
     * @return número decimal introducido por el usuario
     */
    public double leerDecimal(String mensaje) {
        System.out.print(mensaje);
        return Double.parseDouble(scanner.nextLine());
    }
}