/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Robert
 */
public class ListaSimple {
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
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void addFirst(int info){
        
        Nodo nuevo = new Nodo(info);
        if (head == null){
            head = tail = nuevo;
        } else {
            nuevo.sig = head;
            head = nuevo;
        }
    }
    
    public void addLast(int info){
        
        Nodo nuevo = new Nodo(info);
        if (head == null){
            head = tail = nuevo;
        } else {
            tail.sig = nuevo;
            tail = nuevo;
        }
    }
    
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
    
    void printReverse(Nodo next){
        if (next != null) {
            this.printReverse(next.sig);
            System.out.println(next.info);
        }   
    }
    
    public void printReverse(){
        Nodo track = head;
        printReverse(track);
    }
    
    public int getSize(){
        Nodo track = head;
        int counter = 0;
        while (track != null){
            track = track.sig;
            counter ++;
        }
        return counter;
    }
    
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
    
    public void insertAt(int posicion, int info){
        if (posicion == 0){
            this.addFirst(info);
        } else if (posicion == (this.getSize() - 1)){
            this.addLast(info);
        } else {
            Nodo track = head;
            Nodo nuevo = new Nodo(info);
            
            for (int i = 0; i < this.getSize(); i++){
                if ((i + 1) == posicion){
                    Nodo temp = track.sig;
                    track.sig = nuevo;
                    nuevo.sig = temp;
                    return;
                }
                track = track.sig;
            }
        }
        
        System.out.println("Posicion invalida");
    }
    
    public void invert(){
        Nodo track = head;
        if (track.sig != null){
            this.remove(track.info);
            this.invert();
            this.addLast(track.info);
        }
    }
}
