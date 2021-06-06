/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizedchaos;

/**
 *
 * @author Ignacio, Robert
 */
public class Warehouse {
    String name;
    ListI items;
    private boolean visitado;

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
        this.visitado = false;
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
    
    public void cambiarVisitado(boolean visitado){
        this.visitado = visitado;
    }
    
    public void setVisitado(boolean visitado){
        this.visitado= visitado;
    }
    
    public boolean getVisitado(){
        return this.visitado;
    }
    
    public String mostrarInventario(){
        String outString = "";
        outString += "Inventario " + this.name + ":\n";
        outString += this.items.showNodes();
        outString += "\n";
        return outString;
    }
    
    public String buscarProducto(String producto){
        String outString = "";
        Inventory encontrado = this.items.buscarItem(producto);
        if (encontrado != null){
            outString += "Inventario " + this.name + ":\n";
            outString += encontrado.name + ": " + encontrado.quantity;
            outString += "\n";
        }
        return outString;
    }
}
