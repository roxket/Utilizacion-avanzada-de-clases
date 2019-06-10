
import Vehiculos.*;
import java.util.Scanner;

/**
 *
 * @author oxh4
 */
public class GestionVehiculos {
    private static int contVehiculo;
    private static final int ARRAY_LIMITE = 10;
    private static final Vehiculo [] flota = new Vehiculo [ARRAY_LIMITE];
    
    public static void main(String[] args) {
        //iniciamos el contador de vehiculos
        int contVehiculo = 0;
        
        //-- inicio del metodo de testing--//
        cargarVehiculosTest(contVehiculo);
        contVehiculo = 3;
        //----//
        
        // MENU Y SELECTOR
        //coger valor del scanner, comprobar si es int, comprobar si no es 7, otros casos ejecutar y volver a iniciar el ciclo
        int dataSelect=0;
        
        //mientras las condiciones de salida no se cumplan, repetimos el bucle.
        do{
            //Mostramos el menu y esperamos captura de consola
            menu();
            Scanner lectorMenu = new Scanner(System.in);
            //filtramos entradas. Debe ser int
            if(!lectorMenu.hasNextInt()){
                System.out.println("Seleccion erronea. Intente otra vez.");    
            } else{
            dataSelect = lectorMenu.nextInt();
            Scanner lectorSelect = new Scanner(System.in);
        //switch de seleccion de accion del menu    
        switch(dataSelect){
            case 1:
                //seleccion añadir coche
                añadirCoche(contVehiculo, flota);
                contVehiculo++;
                break;
            case 2:
                //seleccion añadir carga
                añadirCarga(contVehiculo, flota);
                contVehiculo++;
                break;
            case 3:
                //seleccion añadir camion
                añadirCamion(contVehiculo, flota);
                contVehiculo++;
                break;
            case 4:
                //seleccion mostrar datos del vehiculo seleccionado
                System.out.println("Seleccionar vehiculo por orden introducido (1 | 2 | 3 ...): ");
                int dataMIVSelect = lectorSelect.nextInt();
                mostrarInformacionVehiculo(dataMIVSelect,flota);
                break;
            case 5:
                //seleccion editar dias de alquiler del vehiculo seleccionado
                System.out.println("Seleccionar vehiculo por orden introducido (1 | 2 | 3 ...): ");
                int dataSVSelect = lectorSelect.nextInt();
                System.out.println("Introducir día de alquiler: ");
                int dataIASelect = lectorSelect.nextInt();
                editarDiaAlquiler(dataSVSelect,dataIASelect,flota);
                break;
            case 6:
                //seleccion listado completo de todos los vehiculos introducidos
                listarVehiculos(contVehiculo,flota);
                break;
            case 7:
                //fin de programa
                System.out.println("Hasta luego...");
                break;
        }
            }
        } while(dataSelect!= 7);
        
    }
    
    //metodo del menu
    private static void menu(){ 
        System.out.println("--- MENU --");
        System.out.println("1. Añadir Coche a la flota");
        System.out.println("2. Añadir Carga a la flota");
        System.out.println("3. Añadir Camion a la flota");
        System.out.println("4. Mostrar información del vehiculo seleccionado");
        System.out.println("5. Modificar dias de alquiler del vehiculo seleccionado");
        System.out.println("6. Visualizar listado completo");
        System.out.println("7. Salir");
        System.out.println("");
        System.out.println("Seleccion: ");
    }
    
    //metodo añadir coche
    private static void añadirCoche(int contVehiculo, Vehiculo []flota){
        if(contVehiculo<(ARRAY_LIMITE-1)){
            
            Vehiculo coche = new Coche('A',"","",0,0);
            coche.pideDatos();
            flota[contVehiculo] = coche;
        }
    }
    //metodo añadir carga
    private static void añadirCarga(int contVehiculo, Vehiculo []flota){
        if(contVehiculo<(ARRAY_LIMITE-1)){
            Vehiculo carga = new Carga("","",0,0,0);
            carga.pideDatos();
            flota[contVehiculo] = carga;
        }
    }
    //metodo añadir camion    
    private static void añadirCamion(int contVehiculo, Vehiculo []flota){
        if(contVehiculo<(ARRAY_LIMITE-1)){
            Vehiculo camion = new Camion("","",0,0,"");
            camion.pideDatos();
            flota[contVehiculo] = camion;
        }
    }
    //metodo mostrar informacion del vehiculo seleccionado
    private static void mostrarInformacionVehiculo(int selectVehiculo, Vehiculo []flota){
        flota[selectVehiculo-1].showInformacion();
        }
    //metodo editar dias de alquiler del vehiculo seleccionado
    private static void editarDiaAlquiler(int selectVehiculo,int selectDia, Vehiculo []flota){
        flota[selectVehiculo-1].setNumeroDias(selectDia);
        double nuevoAlquiler = flota[selectVehiculo-1].getPrecioTotalAlquilerPorDias();
        System.out.println("Nuevo precio: " + nuevoAlquiler);
        }
    //metodo listas vehiculos introducidos
    private static void listarVehiculos(int contVehiculo, Vehiculo []flota){
        for(int i=0; i<contVehiculo; i++){
            System.out.println("----------------------");
            System.out.println("-- Vehiculo nº" + (i+1));
            flota[i].showInformacion();
        }
    }
    //metodo cargar vehiculos testing
    private static void cargarVehiculosTest(int contVehiculo){
        flota[0] = new Coche('A',"1234A","BMW 318ci",5,10);
        flota[1] = new Carga("5678B","Nissan12",3,10,3);
        flota[2] = new Camion("9123C","Scania Pro",5,10,"rigido");
    }
}
