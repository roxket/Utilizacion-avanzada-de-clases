
package Vehiculos;

import java.util.Scanner;

/**
 *
 * @author oxh4
 */
public abstract class Vehiculo implements IVehiculo {
    //Atributos
    private String matricula;
    private String modelo;
    private int plazas;
    private int numDiasAlquiler;
    private static final int precioDiaAlquiler = 50;
    
    //Constructor
    public Vehiculo (String matricula, String modelo, int plazas, int numDiasAlquiler){
        this.matricula = matricula;
        this.modelo = modelo;
        this.plazas = plazas;
        this.numDiasAlquiler = numDiasAlquiler;
    }
    
    //Metodos sobreescritura 
    //Metodo para calcular precio alquiler por dias
    @Override
    public Double getPrecioTotalAlquilerPorDias(){
        return (double)Vehiculo.precioDiaAlquiler * this.getNumeroDias();
    }
    
    //Metodo para mostrar la informacion del vehiculo
    @Override
    public void showInformacion(){
    System.out.println("Matricula: " + this.getMatricula());
    System.out.println("Modelo: " + this.getModelo());
    System.out.println("Plazas: " + this.getPlazas());
    System.out.println("Dias en alquiler: " + this.getNumeroDias());
    System.out.println("Precio total: " + this.getPrecioTotalAlquilerPorDias());
    //System.out.println("----------------------");
    }
    
    //Metodo para solicitar datos por consola
    @Override
    public void pideDatos(){
        Scanner lectorMatricula = new Scanner(System.in);
        System.out.println("Introducir matricula: ");
        String matr = lectorMatricula.next();
        
        System.out.println("Introducir modelo: ");
        Scanner lectorModelo = new Scanner(System.in);
        String modl = lectorModelo.next();
        
        System.out.println("Introducir plazas: ");
        Scanner lectorPlazas = new Scanner(System.in);
        int plaz = lectorPlazas.nextInt();
        
        System.out.println("Introducir dias de alquiler: ");
        Scanner lectorDias = new Scanner(System.in);
        int dias = lectorDias.nextInt();
        
        this.setMatricula(matr);
        this.setModelo(modl);
        this.setPlazas(plaz);
        this.setNumeroDias(dias);
    }
    
    //Setters y getters
    @Override
    public void setNumeroDias(int numDiasAlquiler){
        //metodo pedir datos
        this.numDiasAlquiler = numDiasAlquiler;
    }
    
    public int getNumeroDias(){
    return this.numDiasAlquiler;
    }
    
    //otros getters y settters
    public void setMatricula(String matricula){
    this.matricula = matricula;
    }
    
    public String getMatricula(){
    return this.matricula;
    }
    
    public void setModelo(String modelo){
    this.modelo = modelo;
    }
    
    public String getModelo(){
    return this.modelo;
    }
    
    public void setPlazas(int plazas){
    this.plazas = plazas;
    }
    
    public int getPlazas(){
    return this.plazas;
    } 
}
