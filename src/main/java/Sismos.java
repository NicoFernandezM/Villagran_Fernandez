import java.math.BigDecimal;
import java.util.FormatFlagsConversionMismatchException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sismos {
    public static void main() {

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


        for(int i = 0; i < matrizRellena.length; i++) {
            for(int j = 0; j < matrizRellena[i].length; j++ ) {
                gradoSismoSinTruncar = (1 + (Math.random() * 8.6));
                BigDecimal gradosSismo = new BigDecimal(gradoSismoSinTruncar);


            }
        }
        return matrizRellena;
    }


}
