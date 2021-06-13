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
public class VisitedWarehousesList {
    class Nodo{
        int info;
        Nodo sig;
        
        public Nodo(int info){
            this.info = info;
            this.sig = null;
        }
    }
    Nodo head = null;
    Nodo tail = null;
    
    /**
     *Revisa si la lista esta vacia.
     * @return
     */
    public boolean isEmpty(){
        return head == null;
    }
    
    /**
     *Añade al principio de la lista.
     * @param info
     */
    public void addFirst(int info){
        
        Nodo nuevo = new Nodo(info);
        if (head == null){
            head = tail = nuevo;
        } else {
            nuevo.sig = head;
            head = nuevo;
        }
    }
    
    /**
     *Añade al final de la lista.
     * @param info
     */
    public void addLast(int info){
        
        Nodo nuevo = new Nodo(info);
        if (head == null){
            head = tail = nuevo;
        } else {
            tail.sig = nuevo;
            tail = nuevo;
        }
    }
    
    /**
     *Retorna el nodo que esta en la posicion del index.
     * @param index
     * @return
     */
    public Nodo getInfo (int index){
        int counter = 0;
        Nodo track = head;
        while (counter != index){
            track = track.sig;
            counter ++;
        }
        return track;
    }
    
    /**
     *Muestra los Nodos de la lista.
     */
    public void showNodes(){
        
        Nodo track = head;
        if (track == null) {
            System.out.println("Lista vacia");
            return;
        }
        while (track != null){
            System.out.println(track.info);
            track = track.sig;
        }
        
    }
    
    /**
     *Retorna el nodo que esta en la posicion del pos
     * @param pos
     * @return
     */
    public Object getName(int pos){
        Nodo track = head;
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
        return " ";
    }
    
    /**
     *Elimina el nodo.
     * @param info
     */
    public void remove(int info){
        Nodo track = head;
        Nodo anterior = null;
        
        
        while (track != null){
            if (track.info == info){
                if (anterior == null){
                    head = track.sig;
                } else {
                    anterior.sig = track.sig;
                }
            } 
            anterior = track;
            track = track.sig;
        }
    }
    
    /**
     *Retorna el tamaño de la lista.
     * @return
     */
    public int getSize(){
        Nodo track = head;
        int counter = 0;
        while (track != null){
            track = track.sig;
            counter ++;
        }
        return counter;
    }
    
    /**
     *Retorna el nodo que esta en la posicion del busca
     * @param pos
     * @return
     */
    public int getPos(int busca){
        Nodo track = head;
        for (int i = 0; i < this.getSize(); i++){
            if (track.info == busca){
                return i;
            }
            track = track.sig;
        }
        return -1;
    }
    
    /**
     *Retorna el nodo que esta en la posicion del busca.
     * @param pos
     * @return
     */
    public int find(int busca){
        Nodo track = head;
        for (int i = 0; i < this.getSize(); i++){
            if (track.info == busca){
                return i;
            }
            track = track.sig;
        }
        return -1;
    }
    
    /**
     *Retorna el nodo que con el minimo valor.
     * @return
     */
    public int getMinimum(){
        Nodo tracker1 = head;
        int smallest = 999999;
        for (int i = 0; i < this.getSize(); i++) {
            if (tracker1.info < smallest){
                smallest = tracker1.info;
            }
            tracker1 = tracker1.sig;
        }
        return 0;
    }
}