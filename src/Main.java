import java.util.Scanner;

public class Main {

    private static Scanner scan;
    public static void main(String args[]){
        String nombre;
        int edad;
        char sexo;
        float peso, altura;
        scan = new Scanner(System.in);

        System.out.println("Introduzca su nombre: ");
        nombre = scan.next();
        System.out.println("Introduzca su edad: ");
        edad = scan.nextInt();
        System.out.println("Introduzca su sexo: ");
        sexo = scan.next().charAt(0);
        System.out.println("Introduzca su peso (kg): ");
        peso = scan.nextFloat();
        System.out.println("Introduzca su altura (m): ");
        altura = scan.nextFloat();

        Persona persona[] = new Persona[3];
        persona[0] = new Persona(nombre, edad, sexo, peso, altura);
        persona[1] = new Persona(nombre, edad, sexo);
        persona[2] = new Persona();

        persona[2].setNombre("Carlos");
        persona[2].setEdad(22);
        persona[2].setPeso(65);
        persona[2].setAltura(1.80f);

        for (Persona ipersona: persona){
            switch (ipersona.calcularIMC()){
                case -1:
                    System.out.println(ipersona.getNombre()+" está debajo del peso ideal");
                    break;
                case 0:
                    System.out.println(ipersona.getNombre()+" está en el peso ideal.");
                    break;
                case 1:
                    System.out.println(ipersona.getNombre()+" está sobre el peso ideal.");
                    break;
                default:
                    break;
            }
            if (ipersona.esMayorDeEdad()){
                System.out.println(ipersona.getNombre()+" es mayor de edad.");
            } else{
                System.out.println(ipersona.getNombre()+" no es mayor de edad.");
            }
            System.out.println(ipersona.toString());
            System.out.println("\n");
        }
    }
}
