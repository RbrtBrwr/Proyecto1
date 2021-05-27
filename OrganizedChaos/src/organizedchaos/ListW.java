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
    
    public void addLast(Warehouse info){
        
        Nodo nuevo = new Nodo(info);
        if (headW == null){
            headW = tailW = nuevo;
        } else {
            tailW.sig = nuevo;
            tailW = nuevo;
        }
    }
    
    public String getName(int pos){ //Me regresa el nombre del almacen en la posicion pos
        Nodo track = headW;
        int i = 0;
        if (track == null) {
            System.out.println("Lista vacia");
            return null;
        }
        while (track != null){
            if (i == pos){return track.info.nombre();}
            
            track = track.sig;
        }
        return " ";
    }
}
