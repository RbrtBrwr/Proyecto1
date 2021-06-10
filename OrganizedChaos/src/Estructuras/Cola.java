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
public class Cola {
    private int tamano = -1;
    NodoPC frente = null;
    NodoPC tail = null;
    
    public boolean empty(){
        return this.tamano < 1;
    }
    
    public void push(Object info){
        NodoPC nuevo = new NodoPC(info);
        
        if (this.empty()){
            this.tamano = 1;
            frente = nuevo;   
            tail = nuevo;
        } else {
            this.tamano ++;
            tail.sig = nuevo;
            tail = nuevo;
            
        }
    }
    
    public Object getSize(){
        return this.tamano;
    }
    
    public void pop(){
        if (this.empty()){
        } else {
            
            Object aux;
            
            try {
                aux = frente.info;
            } catch(Exception e){
                return;//Fin
            }
            frente = frente.sig;
            // Aqui puedo poner para retornar l valor que elimine
            System.out.println(this.getSize() + " " + aux);
            this.tamano --;
        }
    }
    
    public Object prevenido(){
        return this.tail.info;
    }
    
    public void delete(){
        while (!this.empty()){
            this.pop();
        }
    }
    
}
