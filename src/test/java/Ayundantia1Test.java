import org.example.Ayundantia1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class Ayundantia1Test {
    private Boolean [] resultadosPalabrasEsperadas;
    private String [] palabras;
    private double [] notas;
    private double promedioEsperado;
    private int[][] puntajes;
    private String[] ganadorEsperado;
    private int[][] matriz;
    private int[][] transpuestEsperada;
    private String[] cadenas;
    private boolean[] resultadosCadenasEsperadas;



    @BeforeEach
    public void init() {
        // esPalindromoTest
        palabras = new String[] {"oso", "reconocer", "radar", "estrella", "elefante"};
        resultadosPalabrasEsperadas = new Boolean[]{true, true, true, false, false};

        // calcularPromedioTest
        notas = new double[]{4.0, 3.0, 5.6, 6.3, 5.5};
        promedioEsperado = 4.645;

        // decidirGanadorTest
         puntajes = new int[][]{
                 {5, 10},
                 {10, 5},
                 {25, 25},
                 {10, 10}
         };
         ganadorEsperado = new String[]{"Jugador 1 ganó.", "Jugador 2 ganó.", "Empate.", "Empate."};

         // obtenerMatrizTranspuestaTest
        matriz = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        transpuestEsperada = new int[][]{
                {1, 4},
                {2, 5},
                {3, 6}
        };

        // validarCadenaTest
        cadenas = new String[]{" ", "hola3", "buenos días"};
        resultadosCadenasEsperadas = new boolean[]{false, false, true};
    }

    @Test
    public void esPalindromoTest() {
        boolean resultadoCorrecto = true;
        for (int i=0; i < palabras.length; i++) {
            if (Ayundantia1.esPalindromo(palabras[i]) != resultadosPalabrasEsperadas[i]) {
                resultadoCorrecto = false;
                break;
            }
        }
        assertTrue(resultadoCorrecto);
    }

    @Test
    public void calcularPromedioTest(){
        double promedioEsperado = 4.645;
        double promedioCalculado = Ayundantia1.calcularPromedio(notas);
        assertEquals(promedioEsperado, promedioCalculado);
    }

    @Test
    public void decidirGanadorTest(){
        boolean ganadorCorrecto = true;
        for (int i = 0; i < puntajes.length; i++) {
            int[] puntajeActual = puntajes[i];
            String resultadoObtenido = Ayundantia1.decidirGanador(puntajeActual);
            if (resultadoObtenido != ganadorEsperado[i]) {
                ganadorCorrecto = false;
                break;
            }
        }
        assertTrue(ganadorCorrecto);
    }

    @Test
    public void obtenerMatrizTranspuestaTest(){
        boolean transpuestaCorrecta = true;
        int[][] transpuestaObtenida = Ayundantia1.obtenerMatrizTranspuesta(matriz);
        for (int i = 0; i < transpuestaObtenida.length; i++) {
            for (int j = 0; j < transpuestaObtenida[i].length; j++) {
                if (transpuestaObtenida[i][j] != transpuestEsperada[i][j]) {
                    transpuestaCorrecta = false;
                    break;
                }
            }
        }
        assertTrue(transpuestaCorrecta);
    }

    @Test
    public void validarCadenaTest(){
        boolean validacionCorrecta = true;
        for(int i=0; i < cadenas.length; i++) {
            if(Ayundantia1.validarCadena(cadenas[i]) != resultadosCadenasEsperadas[i]) {
                validacionCorrecta = false;
                break;
            }
        }
        assertTrue(validacionCorrecta);
    }

}
