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
    
    
    

    public void showNodes(){ //Muestra la informacion de los nodos en la lista
        Nodo track = headI;
        if (track == null) {
            System.out.println("Lista vacia");
            return;
        }
        while (track != null){
            System.out.println(track.info.name + ": " + track.info.quantity);
            track = track.sig;
        }
    }
    
    public void addLast(Inventory info){ //agrega al final de la lista
        
        Nodo nuevo = new Nodo(info);
        if (headI == null){
            headI = tailI = nuevo;
        } else {
            tailI.sig = nuevo;
            tailI = nuevo;
        }
    }
}
