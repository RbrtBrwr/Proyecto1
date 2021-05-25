/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doblista;

/**
 *
 * @author Robert
 */
class dobleNodo {
    Object info;
    dobleNodo previo;
    dobleNodo siguiente;
    
    public dobleNodo(Object info){
        this.info = info;
        this.previo = null;
        this.siguiente = null;
    }
    public dobleNodo(Object info, dobleNodo previo, dobleNodo siguiente){
        this.info = info;
        this.previo = previo;
        this.siguiente = siguiente;
    }
    public dobleNodo(Object info, dobleNodo nodito, boolean previo){
        this.info = info;
        
        if (previo){
            this.previo = nodito;
            this.siguiente = null;
        } else {
            this.siguiente = nodito;
            this.previo = null;
        }
    }
    

}
