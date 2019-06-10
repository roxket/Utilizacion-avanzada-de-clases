
package Vehiculos;

/**
 *
 * @author oxh4
 */
public interface IVehiculo {
    //declaramos los metodos abstractos, sin cuerpo de la interfaz
    public void setNumeroDias(int d);
    
    public Double getPrecioTotalAlquilerPorDias();
    
    public void showInformacion();
    
    public void pideDatos();
    
}
