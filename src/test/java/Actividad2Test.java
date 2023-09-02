import org.example.Actividad2;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class Actividad2Test {
    double[][] temperaturas;
    double[] datosCalurososEsperados;
    double[] datosFriosEsperados;
    double promedioEsperado;

    @BeforeEach
    public void init(){
        temperaturas = new double[][]{
                {10, 10, 10, 10, 10, 10, -10},
                {30, 10, 10, 10, 10, 10, 10}
        };
        datosCalurososEsperados = new double[]{30, 0, 1};
        datosFriosEsperados = new double[]{-10, 6, 0};
        promedioEsperado = 10.0;
    }

    @Test
    public void obtenerDatosExtremosCalurososTest(){
        boolean datosCorrectos = true;
        double[] datosCalurososObtenidos;
        for(int i=0; i < datosCalurososEsperados.length; i++) {
            datosCalurososObtenidos = Actividad2.obtenerDatosExtremos(temperaturas, true);
            if(datosCalurososObtenidos[i] != datosCalurososEsperados[i]) {
                datosCorrectos = false;
            }
        }
        assertTrue(datosCorrectos);
    }

    @Test
    public void obtenerDatosExtremosFriosTest(){
        boolean datosCorrectos = true;
        double[] datosFriosObtenidos;
        for(int i=0; i < datosFriosEsperados.length; i++) {
            datosFriosObtenidos = Actividad2.obtenerDatosExtremos(temperaturas, false);
            if(datosFriosObtenidos[i] != datosFriosEsperados[i]) {
                datosCorrectos = false;
            }
        }
        assertTrue(datosCorrectos);
    }

    @Test
    public void calcularPromedioTemperaturasTest(){
        double promedioObtenido = Actividad2.calcularPromedioTemperaturas(temperaturas);
        assertEquals(promedioEsperado, promedioObtenido, 0.01);
    }
}
