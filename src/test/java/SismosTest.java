import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SismosTest {
    private double [][] datosTesting;
    private int [] dias;
    private int [] mayoresQueCuatro;

    @BeforeEach
    public void init() {
        datosTesting = new double [ ][ ] {
                {2.5, 3.0, 2.7, 3.8, 4.0, 3.1, 4.6, 2.3, 3.2, 3.1, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 4.0, 3.1, 4.5, 2.3, 3.2, 3.1, 2.5, 2.2},
                {4.5, 2.3, 3.2, 3.1, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 4.0, 3.1, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 2.5, 3.0, 2.7, 3.8, 4.0, 3.1},
                {2.3, 3.2, 3.1, 2.5, 2.2, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 2.5, 3.0, 2.7, 3.8, 4.0, 3.1, 3.8, 4.0, 3.1, 4.5, 2.3, 3.2, 2.9},
                {2.5, 3.0, 2.7, 3.8, 4.0, 3.1, 4.5, 2.3, 3.2, 3.1, 2.5, 2.2, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 2.7, 3.8, 4.5, 2.3, 3.2, 3.1},
                {3.8, 4.0, 3.1, 4.5, 2.3, 3.2, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 4.5, 2.3, 3.2, 3.1, 2.5, 2.2, 2.5, 3.0, 2.7, 3.8, 4.0, 3.1}
        };

        dias = new int [] {3, 5, 6, 9, 20};
        mayoresQueCuatro = new int [] {4, 3, 3, 3, 4};
    }

    @Test
    public void rellenarMatrizTest() {
        double numeroRetornado;
        double [][]matrizRetornada;
        boolean igualLargo = true;

        for(int i = 0; i < dias.length; i++) {
            matrizRetornada = (Sismos.rellenarMatriz(dias[i]));
            if(matrizRetornada.length != dias.length) {
                igualLargo = false;
            }
            assertTrue(igualLargo);
        }
    }

    @Test
    public void calcularMayorCuatro() {
        int [] resultadosObtenidos = new int[mayoresQueCuatro.length];
        boolean diasIguales = true;

        for(int i = 0; i < mayoresQueCuatro.length; i++) {
            for (int j = 0; j < datosTesting[i].length; j++) {
                resultadosObtenidos = Sismos.calcularMayorCuatro(datosTesting, mayoresQueCuatro.length);
                if(resultadosObtenidos[i] != mayoresQueCuatro[i]) {
                    diasIguales = false;
                }
            }
        }

        assertTrue(diasIguales);
    }
}
