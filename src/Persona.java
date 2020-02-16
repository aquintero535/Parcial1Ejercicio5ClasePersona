import java.util.Random;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private final char sexo;
    private float peso;
    private float altura;

    private final static int DEBAJO_PESOIDEAL = -1;
    private final static int PESOIDEAL = 0;
    private final static int SOBREPESO = 1;
    private final static char DEFAULT_SEXO = 'H';

    public Persona(){
        this.nombre = "";
        this.edad = 0;
        this.dni = generaDNI();
        this.sexo = DEFAULT_SEXO;
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, int edad, char sexo){
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        this.dni = generaDNI();
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, int edad, char sexo, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        this.dni = generaDNI();
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        float imc = peso/(float) Math.pow(altura, 2);
        if (imc < 20){
            return DEBAJO_PESOIDEAL;
        } else if (imc >= 20 && imc <= 25){
            return PESOIDEAL;
        } else if (imc > 25){
            return SOBREPESO;
        }
        return 0;
    }

    public boolean esMayorDeEdad(){
        return (edad>=18)?true:false;
    }

    private char comprobarSexo(char sexo){
        if (sexo == 'M' || sexo == 'm') {
            return 'M';
        } else if (sexo == 'H' || sexo == 'h'){
            return 'H';
        }
        else{
            return DEFAULT_SEXO;
        }
    }

    public String toString(){
        return "Nombre: "+this.nombre+"\nEdad: "+this.edad+"\nSexo: "+this.sexo+"\nDNI: "+this.dni+"\nPeso: "+this.peso+"\nAltura: "+this.altura;
    }

    private String generaDNI(){
        Random random = new Random();
        String nuevoDNI = "ABCDEFGHIJKLMNOPQRSTVWXYZ";
        int forma = (int) (random.nextDouble() * nuevoDNI.length()-1);
        int numero = (int) (random.nextDouble() * 99+100);
        nuevoDNI  = ""+nuevoDNI.charAt(forma)+numero;
        return nuevoDNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }
}
