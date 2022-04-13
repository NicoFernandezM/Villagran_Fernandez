import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Sismos {
    public static void main(String[] args) {
        eleccion();
    }


    public static void menu() {
        System.out.println("[1] Mostrar sismo mas Intenso");
        System.out.println("[2] Mostrar Sismos >= 4.0 Grados Richter");
        System.out.println("[3] Reiniciar arreglo con nuevos valores");
        System.out.println("[4] Salir");
    }

    public static String ingresoeleccion() {
        System.out.println("A que quiere acceder");
        Scanner teclado = new Scanner(System.in);
        return teclado.next();
    }

    public static void eleccion() {
        boolean x = false;
        do {
            menu();
            String a = ingresoeleccion();
            System.out.println(a);
            switch (a) {
                case "1":
                    mostrarSismoIntenso(rellenarMatriz(pedirDias));
                    System.out.println("Sismo Intenso");
                    x=false;
                    break;
                case "2":
                    //sismosMayoresde4();
                    System.out.println("Sismos Mayores de 4");
                    x=false;
                    break;
                case "3":
                    //reiniciarArreglos();
                    System.out.println("Reinicio");
                    x=false;
                    break;
                case "4":
                    //salir();
                    System.out.println("Saliendo");
                    x= true;
                    break;
                default: x=false;
            }
        }while (x==false);
    }

    private static void salir() {
        System.out.println("Gracias por usar el programa");
    }

    private static void reiniciarArreglos() {
    }

    private static void sismosMayoresde4() {

    }

   /*
   private static double[][] matriz() {
        double[][] matriz = new double[3][24];
        return matriz;
    }

    public static double [][] rellenarMatriz(double [][] matrizRellena) {
        double gradoSismoSinTruncar;
        double gradosSismosTruncados;


        for(int i = 0; i < matrizRellena.length; i++) {
            for(int j = 0; j < matrizRellena[i].length; j++ ) {
                gradoSismoSinTruncar = (1 + (Math.random() * 8.6));
                BigDecimal gradosSismo = new BigDecimal(gradoSismoSinTruncar);
                BigDecimal rounded = gradosSismo.setScale(1, RoundingMode.FLOOR);
                gradosSismosTruncados = rounded.doubleValue();
                matrizRellena[i][j] = gradosSismosTruncados;
            }
        }
        return matrizRellena;
    }*/

    public static double mayorsismo(double[][] matriz) {
        double mayor=0;
        int diamayor;
        int horamayor;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (mayor<matriz[i][j]){
                    mayor=matriz[i][j];
                }
            }
        }
        return mayor;
    }

    public static int mayorhora(double[][] matriz) {
        double mayor=0;
        int horamayor=-5;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (mayor<matriz[i][j]){
                    horamayor=j;
                }
            }
        }
        return horamayor;
    }

    public static int mayorDia(double[][] matriz) {
        double mayor=0;
        int diamayor=-5;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (mayor<matriz[i][j]){
                    diamayor=i;
                }
            }
        }
        return diamayor;
    }

    public static void mostrarSismoIntenso(double mayor, int dia, int hora) {
        System.out.println("El sismo mas intenso es: "+mayor+" El dia "+dia+" a la hora de: "+hora);
    }

}
