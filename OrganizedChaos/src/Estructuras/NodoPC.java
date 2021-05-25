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
public class NodoPC {
    Object info;
    NodoPC sig;
        
    public NodoPC(Object info){
        this.info = info;
        this.sig = null;
    }
}
