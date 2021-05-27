/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizedchaos;


/**
 *
 * @author Robert
 */
public class Grafo {
    /*
    class NodoGrafo{
        Warehouse almacen;
        ListaSimple salidas;
        
        public NodoGrafo(Warehouse almacen, ListaSimple salidas){
            this.almacen = almacen;
            this.salidas = salidas;
        }
    }
    */
    
    ListW warehouseList;
    ListS roadsList;
    MatrizAdy laMatriz;

    
    public Grafo(ListW warehouseList, ListS roadsList){ //Lista que tenga nombre de almacen, inventario, y calles de salida
        this.warehouseList = warehouseList;
        this.roadsList = roadsList;
        this.laMatriz = new MatrizAdy();
        this.laMatriz.extractAlmacenes(warehouseList);
        this.laMatriz.extractRoads(roadsList);
    }
    
    public void mostrarMatriz(){
        this.laMatriz.muestraMatriz();
    }
    
    public void agregarAlmacen(Warehouse almacen, Street calle1, Street calle2){
        /*
        this.warehouseList.addLast(almacen);
        this.roadsList.addLast(calle1);
        this.roadsList.addLast(calle2);
        */
        this.laMatriz.nuevoAlmacen(almacen);
        this.laMatriz.nuevaCalle(calle1.out, calle1.in, calle1.distance);
        this.laMatriz.nuevaCalle(calle2.out, calle2.in, calle2.distance);
        
    }
    
    public void agregarCalle(Street calle){
        this.laMatriz.nuevaCalle(calle.out, calle.in, calle.distance);
    }
    
    public void eliminarCalle(String almacen1, String almacen2){
        //Metodo en lista S para eliminar una calle conociendo ambos almacenes y uno conociendo solo uno
        
    }
    
    public void eliminarAlmacen(String nombre){
        //Necesito metodo para eliminar las calles primero, chequear si al eliminar el almacen queda algun otro con una sola calle etc...
        
    }
}
