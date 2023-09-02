package org.example;
import java.util.*;

public class Actividad2 {
    public static void main(String[] args){
        iniciarPrograma();
    }

    public static double[][] crearMatriz(){ // Crea una matriz 24x7
        final int horas = 24; final int dias = 7;
        double[][] temperaturas = new double[horas][dias];
        llenarMatriz(temperaturas); // Se llena la función por paso por referencia
        return temperaturas;
    }

    public static void llenarMatriz(double[][] temperaturas) {
        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {
                temperaturas[i][j] = generarNumeroAleatorio(); // Se llena la matriz con números aleatorios
            }
        }
    }

    public static double generarNumeroAleatorio() {
        Random random = new Random();
        double numeroAleatorio = Math.round((random.nextDouble(-0.2,0.6)) * 100); // Se redondean las temperaturas a 1 decimal
        return numeroAleatorio;
    }

    public static void mostrarMatriz(double[][] temperaturas){ // Método que muestra todas las temperaturas en la consola
        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {
                System.out.print(temperaturas[i][j] + "; "); // Separador de los datos, para que sea más cómodo leerlo
            }
            System.out.println(); // Salto de línea
        }
    }

    public static double[] obtenerDatosExtremos(double[][] temperaturas, boolean buscarCaluroso) {
        double temperaturaExtrema; int diaExtremo = 0; int horaExtrema = 0;
         // Buscar caluroso será true si se busca la temperatura más alta
        if (buscarCaluroso) {
            temperaturaExtrema = 0; // El valor de temperaturaExtrema dependerá de cual temperatura extrema se busque
        } else {
            temperaturaExtrema = 100;
        }
        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {
                if ((buscarCaluroso && temperaturas[i][j] > temperaturaExtrema)
                        || (!buscarCaluroso && temperaturas[i][j] < temperaturaExtrema)) { // Si se busca el día más caluroso, la temperatura tiene que ser mayor que la extrema, pasa lo contrario si se busca el día más frío
                    temperaturaExtrema = temperaturas[i][j];
                    diaExtremo = j;
                    horaExtrema = i;
                }
            }
        }
        double[] datosExtremos = {temperaturaExtrema, diaExtremo, horaExtrema};
        return datosExtremos;
    }

    public static double calcularPromedioTemperaturas(double[][] temperaturas){
        double acumulador = 0;
        final int filas = temperaturas.length;
        final int columnas = temperaturas[0].length;
        int cantidadRegistros = filas*columnas;
        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {
               acumulador += temperaturas[i][j];
            }
        }
        return Math.round(acumulador/cantidadRegistros);
    }

    public static String buscarDia(int indice){
        String[] dias = new String[]{"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        return dias[indice];
    }

    public static String buscarHora(int indice){
        return (indice + 1) + ":00 hrs.";
    }

    public static void mostrarOpciones(){
        System.out.println("------------------------- MENÚ -------------------------");
        System.out.println("1. Mostrar día más caluroso");
        System.out.println("2. Mostrar día más frío");
        System.out.println("3. Mostrar hora y día de la temperatura más alta");
        System.out.println("4. Mostrar hora y día de la temperatura más baja");
        System.out.println("5. Mostrar promedio de la temperatura de la semana");
        System.out.println("6. Mostrar todas las temperaturas de la semana");
        System.out.println("0. Salir");
        System.out.println("-------------------------------------------------------");
        System.out.print("Ingrese una opción: ");
    }


    public static void menu(String opcion, double[][] temperaturas){
        double[] datosDiaCaluroso = obtenerDatosExtremos(temperaturas, true);
        double[] datosDiaFrio = obtenerDatosExtremos(temperaturas, false);
        switch (opcion) {
            case "1":
                System.out.println("El día más caluroso fue el " + buscarDia((int) datosDiaCaluroso[1]) + ".");
                break;

            case "2":
                System.out.println("El día más frío fue el " + buscarDia((int) datosDiaFrio[1]) + ".");
                break;

            case "3":
                System.out.println("La temperatura del día más caluroso fue " + datosDiaCaluroso[0] + "°C.");
                System.out.println("Eso ocurrió el día " + buscarDia((int) datosDiaCaluroso[1]) + " a las " + buscarHora((int) datosDiaCaluroso[2]));
                break;

            case "4":
                System.out.println("La temperatura del día más frío fue " + datosDiaFrio[0] + "°C.");
                System.out.println("Eso ocurrió el día " + buscarDia((int) datosDiaFrio[1]) + " a las " + buscarHora((int) datosDiaFrio[2]));
                break;

            case "5":
                double promedio = calcularPromedioTemperaturas(temperaturas);
                System.out.println("El promedio de las temperaturas de la semana es " + promedio + "°C.");
                break;

            case "6":
                mostrarMatriz(temperaturas);
                break;

            default:
                System.out.println("Opción inválida. Intente de nuevo.");
        }
    }

    public static void iniciarPrograma(){
        Scanner scanner = new Scanner(System.in);
        double[][] temperaturas = crearMatriz();
        mostrarOpciones();
        String opcion = scanner.nextLine();
        while(!opcion.equals("0")) {
            menu(opcion, temperaturas);
            mostrarOpciones();
            opcion = scanner.nextLine();
        }
        System.out.println("Saliendo del programa.");
    }
}
