package org.example;

public class Ayundantia1 {
    public static void main(String[] args) {
        System.out.println(esPalindromo("oso"));
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println(obtenerMatrizTranspuesta(matriz));
    }

    public static boolean esPalindromo(String palabraIngresada) {
        palabraIngresada = palabraIngresada.replace(" ", "");
        StringBuilder stringBuilder = new StringBuilder(palabraIngresada);
        String palabraInvertida = stringBuilder.reverse().toString();
        return palabraIngresada.equalsIgnoreCase(palabraInvertida);
    }

    public static double calcularPromedio(double [] notas) {
        double [] ponderacionNotas = {0.25, 0.25, 0.25, 0.15, 0.10};
        double promedio = 0;
        for (int i = 0; i < notas.length; i++) {
            promedio += (notas[i] * ponderacionNotas[i]); // Falta un += para que se vaya acumulando el promedio
        }
        return promedio;
    }

    public static String decidirGanador(int [] puntajes) {
        int jugador1 = 20 - puntajes[0];
        int jugador2 = 20 - puntajes[1];
        if((jugador1 < 0 && jugador2 < 0) || jugador1 == jugador2) {
            return "Empate.";
        } else if((jugador1 < 0 || jugador2 > jugador1) && jugador2 >= 0) { // Se cambió el < por un >
            return "Jugador 2 ganó.";
        } else {
            return "Jugador 1 ganó.";
        }
    }

    public static int[][] obtenerMatrizTranspuesta(int[][] matriz) {
        int[][] transpuesta = new int[matriz[0].length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }
        return transpuesta;
    }

    public static boolean validarCadena(String palabraIngresada) {
        for (int i = 0; i < palabraIngresada.length(); i++) { // Se le quitó el signo =
            if (Character.isDigit(palabraIngresada.charAt(i)) ||
                    palabraIngresada.isBlank()) {
                return false;
            }
        }
        return true;
    }


}