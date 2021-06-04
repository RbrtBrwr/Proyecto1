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
public class PilaW {
    private class Nodo{
        Warehouse info;
        Nodo sig;
        
        private Nodo(Warehouse info){
            this.info = info;
            this.sig = null;
        }
    }
    private int tamano = -1;
    Nodo cima = null;
    
    public boolean empty(){
        return this.tamano < 1;
    }
    
    public void push(Warehouse info){
        Nodo nuevo = new Nodo(info);
        
        if (this.empty()){
            this.tamano = 1;
            cima = nuevo;            
        } else {
            this.tamano ++;
            nuevo.sig = cima;
            cima = nuevo;
        }
    }
    
    public int getSize(){
        return this.tamano;
    }
    
    public Warehouse pop(){
        if (this.empty()){
        } else {
            
            Warehouse aux = cima.info;
            cima = cima.sig;
            // Aqui puedo poner para retornar l valor que elimine
            //System.out.println(this.getSize() + " " + aux);
            this.tamano --;
            return aux;
        }
        return null;
    }
    
    public Warehouse top(){
        return this.cima.info;
    }
    
    public void destroy(){
        while (!this.empty()){
            this.pop();
        }
    }
    
}
