/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizedchaos;

/**
 * Lista de Inventario
 * @author Robert
 */
public class ListI{ //Lista para inventarios
    protected class Nodo{
        Inventory info;
        Nodo sig;
        
        public Nodo(Inventory info){
            this.info = info;
            this.sig = null;
        }
    }
    Nodo headI = null;
    Nodo tailI = null;
    
    
    
    /**
     * Muestra la informacion de los nodos en la lista.
     * @return outString String con el inventario
     */
    public String showNodes(){ 
        Nodo track = headI;
        String outString = "";
        if (track == null) {
            System.out.println("Lista vacia");
            return null;
        }
        while (track != null){
            outString += track.info.name + ": " + track.info.quantity + "\n";
            track = track.sig;
        }
        return outString;
    }
    
    /**
     * agrega al final de la lista
     * @param info 
     */
    public void addLast(Inventory info){ 
        
        Nodo nuevo = new Nodo(info);
        if (headI == null){
            headI = tailI = nuevo;
        } else {
            tailI.sig = nuevo;
            tailI = nuevo;
        }
    }
    
    /**
     * busca el Item indicado
     * @param nombre
     * @return el Item que busca o null
     */
    public Inventory buscarItem(String nombre){
        Nodo track = headI;
        if (track == null) {
            return null;
        }
        while (track != null){
            if (nombre.equalsIgnoreCase(track.info.name)){
                return track.info;
            }
            track = track.sig;
        }
        return null;
    }
}
