
package Vehiculos;

import java.util.Scanner;

/**
 *
 * @author oxh4
 */
public class Carga extends Vehiculo implements IVehiculo {
    //Atributos
    private String matricula;
    private String modelo;
    private int diasAlquiler;
    private int PMA;
    private final int tarifPMA = 20;
    
    //Constructor
    public Carga( String matricula, String modelo, int plazas, int diasAlquiler){
      super(matricula, modelo, plazas, diasAlquiler);
    }
    //sobrecarga del constructor
    public Carga( String matricula, String modelo, int plazas, int diasAlquiler, int PMA){
        super(matricula, modelo, plazas, diasAlquiler);
        this.PMA = PMA;
    }
    
    //Metodos sobreescritura
    //Metodo para calcular precio alquiler por dias
    @Override
    public Double getPrecioTotalAlquilerPorDias(){
        return super.getPrecioTotalAlquilerPorDias()+ (this.getPMA() * tarifPMA);
    }
    //Metodo para mostrar la informacion de la carga
    @Override
    public void showInformacion(){
    System.out.println("----------------------");
    super.showInformacion();
    System.out.println("PMA: " + this.getPMA());
    
    }
    //Metodo para solicitar datos por consola
    @Override
    public void pideDatos(){
        super.pideDatos();

        System.out.println("Introducir PMA: ");
        Scanner lectorPMA = new Scanner(System.in);
        int pma = lectorPMA.nextInt();
        
        this.setPMA(pma);
    }

    //setters and getters
    
    public void setPMA(int PMA){
        this.PMA = PMA;
    }
    
    public int getPMA(){
        return this.PMA;
    }
}
