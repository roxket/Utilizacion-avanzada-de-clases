
package Vehiculos;

import java.util.Scanner;

/**
 *
 * @author oxh4
 */
public class Camion extends Carga implements IVehiculo {
    //Atributos
    private String matricula;
    private String modelo;
    private int plazas;
    private int diasAlquiler;
    
    private String tipoEstructura; //rigido, remolque, semiremolque
    private final int tarFija = 40;
    
    //Constructor
    public Camion (String matricula, String modelo, int plazas, int diasAlquiler, String tipoEstructura){
        super(matricula, modelo, plazas, diasAlquiler);
        this.tipoEstructura = tipoEstructura;
    }
    //Metodos sobreescritura
    //Metodo para calcular precio alquiler por dias
    @Override
    public Double getPrecioTotalAlquilerPorDias(){
        return super.getPrecioTotalAlquilerPorDias()+ tarFija;
    }
    //Metodo para mostrar la informacion del camion
    @Override
    public void showInformacion(){
    super.showInformacion();
    System.out.println("Tipo de estructura: " + this.getTipoEstructura());
    System.out.println("----------------------");
    }
    //Metodo para solicitar datos por consola
    @Override
    public void pideDatos(){
        super.pideDatos();
        
        System.out.println("Introducir el tipo de estructura (rigido | remolque | semiremolque): ");
        Scanner lectorEstructura = new Scanner(System.in);
        String estruct = lectorEstructura.next().toLowerCase();
       
        this.setTipoEstructura(estruct);
    }
    //Getters y setters
    public String getTipoEstructura(){
        return this.tipoEstructura;
    }
    
    public void setTipoEstructura(String tipoEstructura){
       this.tipoEstructura = tipoEstructura;
    }
}
