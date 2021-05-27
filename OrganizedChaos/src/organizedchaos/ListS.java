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
public class ListS {
    protected class Nodo{
        Street info;
        Nodo sig;
        
        public Nodo(Street info){
            this.info = info;
            this.sig = null;
        }
    }
    Nodo headS = null;
    Nodo tailS = null;
    
    
    

    public void showNodes(){
        Nodo track = headS;
        if (track == null) {
            System.out.println("Lista vacia");
            return;
        }
        while (track != null){
            System.out.println("salida: " + track.info.out + "\nllegada: " + track.info.in + "\n distancia: " + track.info.distance);
            track = track.sig;
        }
    }
    
    public void addLast(Street info){
        
        Nodo nuevo = new Nodo(info);
        if (headS == null){
            headS = tailS = nuevo;
        } else {
            tailS.sig = nuevo;
            tailS = nuevo;
        }
    }
}
