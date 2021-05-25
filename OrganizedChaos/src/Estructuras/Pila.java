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
public class Pila {
    
    private int tamano = -1;
    NodoPC cima = null;
    
    public boolean empty(){
        return this.tamano < 1;
    }
    
    public void push(Object info){
        NodoPC nuevo = new NodoPC(info);
        
        if (this.empty()){
            this.tamano = 1;
            cima = nuevo;            
        } else {
            this.tamano ++;
            nuevo.sig = cima;
            cima = nuevo;
        }
    }
    
    public Object getSize(){
        return this.tamano;
    }
    
    public Object pop(){
        if (this.empty()){
        } else {
            
            Object aux = cima.info;
            cima = cima.sig;
            // Aqui puedo poner para retornar l valor que elimine
            //System.out.println(this.getSize() + " " + aux);
            this.tamano --;
            return aux;
        }
        return null;
    }
    
    public Object top(){
        return this.cima.info;
    }
    
    public void delete(){
        while (!this.empty()){
            this.pop();
        }
    }
}
