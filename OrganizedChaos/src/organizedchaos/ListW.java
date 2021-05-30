/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizedchaos;

/**
 * Lista de Warehouses
 * @author Robert
 */
public class ListW {
    protected class Nodo{
        Warehouse info;
        Nodo sig;
        
        public Nodo(Warehouse info){
            this.info = info;
            this.sig = null;
        }
    }
    Nodo headW = null;
    Nodo tailW = null;
    
    
    
    /**
     * Imprime los nodos de la lista.
     */
    public void showNodes(){
        Nodo track = headW;
        if (track == null) {
            System.out.println("Lista vacia");
            return;
        }
        while (track != null){
            System.out.println(track.info.name);
            track.info.items.showNodes();
            track = track.sig;
        }
    }
    
    /**
     * agrega Warehouse info al final de la lista
     * @param info 
     */
    public void addLast(Warehouse info){
        
        Nodo nuevo = new Nodo(info);
        if (headW == null){
            headW = tailW = nuevo;
        } else {
            tailW.sig = nuevo;
            tailW = nuevo;
        }
    }
    
    /**
     * Retorna el nombre del amacen en la posicion pos
     * @param pos
     * @return 
     */
    public String getName(int pos){ 
        Nodo track = headW;
        int i = 0;
        if (track == null) {
            System.out.println("Lista vacia");
            return null;
        }
        while (track != null){
            if (i == pos){return track.info.nombre();}
            
            track = track.sig;
            i++;
        }
        return null;
    }
    
    /**
     * Cambia el atributo visitado del nodo a visitado.
     * @param pos
     * @param visitado 
     */
    public void setVisitado(int pos, boolean visitado){
        Nodo track = headW;
        int i = 0;
        if (track == null) {
            System.out.println("Lista vacia");
            return;
        }
        while (track != null){
            if (i == pos){track.info.visitado = visitado;}
            
            track = track.sig;
        }
    }
    
    /**
     * retorna el tamano de la lista
     * @return 
     */
    public int getSize(){
        Nodo track = headW;
        int size = 0;
        while (track != null){
            size ++;
            track = track.sig;
        }
        return size;
    }
    
    /**
     * elimina el nodo warehouseName de la lista
     * @param warehouseName 
     */
    public void removeNode(String warehouseName){
        Nodo track = headW;
        Nodo prev = null;
        while (track != null){
            if (headW.info.name == null ? warehouseName == null : headW.info.name.equals(warehouseName)){
                headW = headW.sig;
                return;
            }else if (track.info.name == null ? warehouseName == null : track.info.name.equals(warehouseName)){
                prev.sig = track.sig;
                return;
            }
            prev = track;
            track = track.sig;
        }
    }
    
}
