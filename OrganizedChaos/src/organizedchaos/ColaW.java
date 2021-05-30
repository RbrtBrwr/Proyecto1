package organizedchaos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Robert
 */
public class ColaW {
    private class Nodo{
        Warehouse info;
        Nodo sig;
        
        private Nodo(Warehouse info){
            this.info = info;
            this.sig = null;
        }
    }
    private int tamano = -1;
    Nodo frente = null;
    Nodo tail = null;
    
    public boolean empty(){
        return this.tamano < 1;
    }
    
    public void push(Warehouse info){
        Nodo nuevo = new Nodo(info);
        
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
    
    public Warehouse pop(){
        if (this.empty()){
        } else {
            
            Warehouse aux;
            
            try {
                aux = frente.info;
            } catch(Exception e){
                return null;//Fin
            }
            frente = frente.sig;
            // Aqui puedo poner para retornar l valor que elimine
            
            this.tamano --;
            return aux;
        }
        return null;
    }
    
    public Warehouse top(){
        return this.tail.info;
    }
    
    public void delete(){
        while (!this.empty()){
            this.pop();
        }
    }
}
