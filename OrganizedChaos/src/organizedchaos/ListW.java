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
    NodoW headW = null;
    NodoW tailW = null;    
    
    /**
     * Imprime los nodos de la lista.
     */
    public void showNodes(){
        NodoW track = headW;
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
        
        NodoW nuevo = new NodoW(info);
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
        NodoW track = headW;
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
     * Retorna el Warehouse en la posicion indicada
     * @param pos
     * @return Warehouse
     */
    public Warehouse getWarehouse(int pos){ 
        NodoW track = headW;
        int i = 0;
        if (track == null) {
            System.out.println("Lista vacia");
            return null;
        }
        while (track != null){
            if (i == pos){return track.info;}
            
            track = track.sig;
            i++;
        }
        return null;
    }

    /**
     * Retorna la posicion del warehouse indicado
     * @param check
     * @return int posicion
     */
    public int getPos(Warehouse check){
        NodoW track = headW;
        int i = 0;
        if (track == null) {
            System.out.println("Lista vacia");
            return -1;
        }
        while (track != null){
            if (check == track.info){return i;}
            
            track = track.sig;
            i++;
        }
        return -1;
    }
    
    /**
     * Cambia el atributo visitado del nodo a visitado.
     * @param pos
     * @param visitado 
     */
    public void setVisitado(int pos, boolean visitado){
        Warehouse track = this.getWarehouse(pos);
        track.setVisitado(visitado);
    }
    
    /**
     * retorna el tamano de la lista
     * @return 
     */
    public int getSize(){
        NodoW track = headW;
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
        NodoW track = headW;
        NodoW prev = null;
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

    /**
     *Guarda los cambios sufridos en las listas del programa.
     * @return
     */    
    public String guardarArchivo(){
        String archivo= "Almacenes;\n";
        NodoW track = headW;
        while (track != null){
            archivo += track.info.name + ":\n";
            
            if (track.info.items != null){
                archivo += track.info.items.guardarArchivo();
            }
            
            track = track.sig;
        }
        return archivo;
    }
    
    /**
     *Retorna el almacen completo.
     * @param name
     * @return
     */    
    public Warehouse getWarehouse(String name){
        NodoW track = headW;
        while (track.sig != null){
            if (track.info.name.equalsIgnoreCase(name)){
                return track.info;
            }
            else{
                track = track.sig;
            }
        }
        return null;
    }

    /**
     *Retorna los almacenes que contienen el item que se le pasa como parametro.
     * @param item
     * @param warehouseList
     * @return
     */
    public ListW getWarehouses(String item, ListW warehouseList){
        ListW warehouses = new ListW();
        for (int j = 0; j < warehouseList.getSize(); j++) {
            for (int k = 0; k < warehouseList.getWarehouse(j).items.size; k++) {
                if (warehouseList.getWarehouse(j).items.getNode(k).info.name.equalsIgnoreCase(item)){
                    warehouses.addLast(warehouseList.getWarehouse(j));
                }
            }
        }
        return warehouses;
    }
}
