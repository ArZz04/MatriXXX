package com.arzz.matrices.matrices;

public class ArithmeticFunctions {

    static int[][] sumaMatrices(int[][] matriz1, int[][] matriz2) {
        int filas = matriz1.length;
        int columnas = matriz1[0].length;
        int[][] resultado = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        return resultado;
    }

    static int[][] restaMatrices(int[][] matriz1, int[][] matriz2) {
        int filas = matriz1.length;
        int columnas = matriz1[0].length;
        int[][] resultado = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz1[i][j] - matriz2[i][j];
            }
        }
        return resultado;
    }

    static int[][] multiplicacionMatrices(int[][] matriz1, int[][] matriz2) {
        int filas1 = matriz1.length;
        int columnas1 = matriz1[0].length;
        int filas2 = matriz2.length;
        int columnas2 = matriz2[0].length;

        if (columnas1 != filas2) {
            throw new IllegalArgumentException("Las matrices no pueden multiplicarse: las dimensiones no son compatibles.");
        }

        int[][] resultado = new int[filas1][columnas2];

        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas2; j++) {
                for (int k = 0; k < columnas1; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }
        return resultado;
    }

    private double[][] multiplicarPorInversa(double[][] matriz1, double[][] matriz2) {
        // Este método calcularía la multiplicación de matriz1 por la inversa de matriz2, si es posible
        // Aquí iría el cálculo de la inversa de la segunda matriz y luego la multiplicación
        // Debes validar que la matriz2 sea invertible (si tiene determinante distinto de 0)
        return new double[0][0];
    }

}
