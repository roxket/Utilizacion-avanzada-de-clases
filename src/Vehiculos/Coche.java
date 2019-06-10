
package Vehiculos;

import java.util.Scanner;

/**
 *
 * @author oxh4
 */
public class Coche extends Vehiculo implements IVehiculo {
    //Atributos
    private char gama;
    private String matricula;
    private String modelo;
    private int plazas;
    private int diasAlquiler;
    
    private final double tarifa = 1.5;
    
    //Constructor
    public Coche(char gama, String matricula, String modelo, int plazas, int diasAlquiler){
        super(matricula, modelo, plazas, diasAlquiler);
        this.gama = gama;
    }

    //Metodos sobreescritura 
    //Metodo para calcular precio alquiler por dias
    @Override
    public Double getPrecioTotalAlquilerPorDias(){
       return super.getPrecioTotalAlquilerPorDias() + ( this.getPlazas() * this.getNumeroDias() * this.tarifa);
    
    }
    //Metodo para mostrar la informacion del coche
    @Override
    public void showInformacion(){
    System.out.println("----------------------");
    super.showInformacion();
    System.out.println("Gama: " + this.getGama());
    }
   //Metodo para solicitar datos por consola
   @Override
    public void pideDatos(){
        super.pideDatos();
        
        Scanner lectorGama = new Scanner(System.in);
        System.out.println("Introducir gama (A-B-C-D): ");
        char gam = lectorGama.next().charAt(0);
        
        this.setGama(gam);
    }
    
    //Setters and getters
    public void setGama(char gama){
        this.gama = gama;
    }
    
    public char getGama(){
       return this.gama;
    }
}
