/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizedchaos;

/**
 *
 * @author Ignacio
 */
public class Warehouse {
    String name;
    ListI items;

    /**
     *
     * @param letter
     * @param inventory
     * Se inicializa Warehouse con nombre, lista de inventario y posicion -1
     */
    public Warehouse(String letter, ListI inventory){
        this.name = letter;
        this.items = inventory;
        this.numAlmacen = -1;
    }

    int numAlmacen;
    
    

    
    //Muestra el nombre
    public String nombre(){
        return this.name;
    }
    
    //Chequea si dos Warehouses son iguales 
    public boolean iguales(Warehouse x){
        return this.name.equals(x.nombre());
    }
    
    //Asigna posicion al Warehouse
    public void assignNum(int x){
        this.numAlmacen = x;
    }
    
    // Muestra nombre y posicion
    public String verPos(){
        return this.name + " (" + numAlmacen + ")";
    }
}
