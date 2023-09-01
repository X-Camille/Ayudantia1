package org.example;
import java.text.DecimalFormat;
import java.util.*;

public class Actividad2 {
    public static void main(String[] args){
        iniciarPrograma();
    }


    public static double[][] crearMatriz(){
        double[][] temperaturas = new double[24][7];
        llenarMatriz(temperaturas); // Paso por referencia
        return temperaturas;
    }

    public static void llenarMatriz(double[][] temperaturas) {
        Random random = new Random();
        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {
                temperaturas[i][j] = random.nextDouble() * 100;
            }
        }
    }

    public static void mostrarMatriz(double[][] temperaturas){
        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {
                System.out.printf("%1.1f", temperaturas[i][j]);
                System.out.print("; ");
            }
            System.out.println();
        }
    }

    public static double[] obtenerDatosDiaCaluroso(double[][] temperaturas){
        double mayorTemperatura = 0.0;
        int diaMasCaluroso = 0;
        int horaMasCalurosa = 0;
        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {
                if(temperaturas[i][j] > mayorTemperatura) {
                    mayorTemperatura = temperaturas[i][j];
                    diaMasCaluroso = j;
                    horaMasCalurosa = i;
                }
            }
        }
        double[] datosDiaCaluroso = {mayorTemperatura, diaMasCaluroso, horaMasCalurosa};
        return datosDiaCaluroso;
    }

    public static double[] obtenerDatosDiaFrio(double[][] temperaturas) {
        double menorTemperatura = 100;
        int diaMasFrio = 0;
        int horaMasFria = 0;
        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {
                if (temperaturas[i][j] < menorTemperatura) {
                    menorTemperatura = temperaturas[i][j];
                    diaMasFrio = j;
                    horaMasFria = i;
                }
            }
        }
        double[] datosDiaCaluroso = {menorTemperatura, diaMasFrio, horaMasFria};
        return datosDiaCaluroso;
    }

    public static double calcularPromedioTemperaturas(double[][] temperaturas){
        double acumulador = 0;
        int cantidadRegistros = 24*7;
        for (int i = 0; i < temperaturas.length; i++) {
            for (int j = 0; j < temperaturas[i].length; j++) {
               acumulador += temperaturas[i][j];
            }
        }
        return acumulador/cantidadRegistros;
    }

    public static String buscarDia(int indice){
        String[] dias = new String[]{"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        return dias[indice];
    }

    public static void mostrarOpciones(){
        System.out.println("Información sobre las temperaturas de Temuco");
        System.out.println("1. Mostrar día más caluroso");
        System.out.println("2. Mostrar día más frío");
        System.out.println("3. Mostrar hora y día de la temperatura más baja");
        System.out.println("4. Mostrar hora y día de la temperatura más alta");
        System.out.println("5. Mostrar promedio de la temperatura de la semana");
        System.out.println("6. Mostrar todas las temperaturas de la semana");
        System.out.println("0. Salir");
        System.out.print("Ingrese una opción: ");
    }

    public static void iniciarPrograma(){
        Scanner scanner = new Scanner(System.in);
        double[][] temperaturas = crearMatriz();
        mostrarOpciones();
        int opcion = scanner.nextInt();
        while(opcion != 0) {
            menu(opcion, temperaturas);
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
        }
        System.out.println("Saliendo del programa.");
    }

    public static void menu(int opcion, double[][] temperaturas){

        double[] datosDiaCaluroso = obtenerDatosDiaCaluroso(temperaturas);
        double[] datosDiaFrio = obtenerDatosDiaFrio(temperaturas);
        switch (opcion) {
            case 1:
                System.out.println("El día más caluroso fue el " + buscarDia((int) datosDiaCaluroso[1]));
                break;

            case 2:
                System.out.println("El día más frío fue el " + buscarDia((int) datosDiaFrio[1]));
                break;

            case 3:
                System.out.println("La temperatura del día más caluroso fue " + datosDiaCaluroso[0]);
                System.out.println("Eso ocurrió el día " + buscarDia((int) datosDiaCaluroso[1]) + " a las ");
                break;

            case 4:
                System.out.println("La temperatura del día más frío fue " + datosDiaFrio[0]);
                System.out.println("Eso ocurrió el día " + buscarDia((int) datosDiaFrio[1]) + " a las ");
                break;

            case 5:
                double promedio = calcularPromedioTemperaturas(temperaturas);
                System.out.print("El promedio de las temperaturas de la semana es ");
                System.out.printf("%1.1f", promedio);
                break;

            case 6:
                mostrarMatriz(temperaturas);
                break;


            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }

}
