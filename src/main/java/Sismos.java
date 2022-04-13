import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.FormatFlagsConversionMismatchException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sismos {
    public static void main(String[] args) {
        int reinicio = 0;
        int dias = pedirDias();
        double [][] matrizLlena = rellenarMatriz(dias);
        int [] mayorQueCuatro = calcularMayorCuatro(matrizLlena, dias);
        imprimirMayorCuatro(mayorQueCuatro);
    }

    public static int pedirDias() {
        int dias;

        while(true) {
            System.out.println("Por favor ingrese la cantidad de días");
            Scanner scanner = new Scanner(System.in);

            try {
                dias = scanner.nextInt();
            }catch(InputMismatchException e) {
                continue;
            }

            if(dias > 1 && dias < 32) {
                return dias;
            }
        }
    }

    public static double [][] rellenarMatriz(int dias) {
        double [][] matrizRellena = new double[dias][24];
        double gradoSismoSinTruncar;
        double gradosSismosTruncados;


        for(int i = 0; i < matrizRellena.length; i++) {
            for(int j = 0; j < matrizRellena[i].length; j++ ) {
                gradoSismoSinTruncar = (1 + (Math.random() * 8.6));
                BigDecimal gradosSismo = new BigDecimal(gradoSismoSinTruncar);
                BigDecimal rounded = gradosSismo.setScale(1, RoundingMode.FLOOR);
                gradosSismosTruncados = rounded.doubleValue();
                matrizRellena[i][j] = gradosSismosTruncados;
                System.out.println(matrizRellena[i][j]);
            }
        }
        return matrizRellena;
    }

    public static int [] calcularMayorCuatro(double [][] matrizRellena, int dias) {
        int aux;
        int vecesPorDia = 0;
        int [] matrizMayorCuatro = new int [dias];

        for(int i = 0; i < matrizRellena.length; i++) {
            for(int j = 0; j < matrizRellena[i].length; j++ ) {
                if(matrizRellena[i][j] >= 4.0) {
                    vecesPorDia++;
                }
            }
            matrizMayorCuatro[i] = vecesPorDia;
            System.out.println(matrizMayorCuatro[i]);
            vecesPorDia = 0;
        }

        return matrizMayorCuatro;
    }

    public static void imprimirMayorCuatro(int [] matrizMayorCuatro) {
        for(int i = 0; i < matrizMayorCuatro.length; i++) {
            System.out.println("Día " + (i + 1) + ": " + matrizMayorCuatro[i] + " veces.");
        }
    }

}
