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
    int numAlmacen;

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


    /**
     * retorna el nombre del Warehouse
     * @return 
     */
    public String nombre(){
        return this.name;
    }
    
    /**
     * Chequea si dos warehouses son iguales
     * @param x
     * @return 
     */
    public boolean iguales(Warehouse x){
        return this.name.equals(x.nombre());
    }
    
    /**
     * Asigna una posicion al Warehouse
     * @param x 
     */
    public void assignNum(int x){
        this.numAlmacen = x;
    }
    
    /**
     * retorna nombre y posicion del Warehouse
     * 
     * @return 
     */
    public String verPos(){
        return this.name + " (" + numAlmacen + ")";
    }

    /**
     * asigna el valor de visitado al Warehouse
     * @param visitado 
     */
    public void setVisitado(boolean visitado){
        this.visitado = visitado;
    }
    
    /**
     * retorna el valor de visitado del warehouse
     * 
     * @return 
     */
    public boolean getVisitado(){
        return this.visitado;
    }
    
    /**
     * retorna el inventario de Warehouse
     * @return 
     */
    public String mostrarInventario(){
        String outString = "";
        outString += "Inventario " + this.name + ":\n";
        outString += this.items.showNodes() + "\n";
        return outString;
    }
    
    /**
     * Retorna el producto buscado con su cantidad
     * @param producto
     * @return String
     */
    public String buscarProducto(String producto){
        String outString = "";
        Inventory encontrado = this.items.buscarItem(producto);
        if (encontrado != null){
            outString += "Inventario " + this.name + ":\n";
            outString += encontrado.name + ": " + encontrado.quantity + "\n";
        }
        return outString;
    }
    
//    public String buscarProducto(Inventory producto){
//        String outString = "";
//        Inventory encontrado = this.items.buscarItem(producto.name);
//        if (encontrado != null){
//            outString += "Inventario " + this.name + ":\n";
//            outString += encontrado.name + ": " + encontrado.quantity + "\n";
//        }
//        return outString;
//    }
    
    public boolean buscarProducto(Inventory producto){
        Inventory encontrado = this.items.buscarItem(producto.name);
        if (encontrado != null){
            return true;
        }
        return false;
    }
    
    /**
     * anade un producto al inventario
     * @param producto
     * @param cantidad 
     */
    public void agregarProducto(String producto, int cantidad){
        Inventory nuevo = new Inventory(producto, cantidad);
        this.items.agregarItem(nuevo);
    }
    
    /**
     * anade producto al inventario
     * @param producto 
     */
    public void agregarProducto(Inventory producto){
        this.items.agregarItem(producto);
    }
    
    /**
     * anade una lista de productos al inventario
     * @param listaItems 
     */
    public void reStock(ListI listaItems){
        Inventory agg;
        while (!listaItems.empty()){
            agg = listaItems.headI.info;
            this.agregarProducto(agg);
            listaItems.headI = listaItems.headI.sig;
        }
    }
    
    public void envios(ListI pedido, ListI envio){
        ListI.Nodo track = pedido.headI;
        while(track != null){
            if (this.buscarProducto(track.info)){
                pedido.descontar(track.info);
                this.items.descontar(track.info);
                envio.agregarItem(track.info);
            }
            track = track.sig;
        }
    }
    
    public Warehouse getNearest(){
        //Aqui trabajo djikstra o floyd warshall
        return null;
    }
    
    
}
