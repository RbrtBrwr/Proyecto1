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
public class NodoW {
    Warehouse info;
    NodoW sig;
    
    public NodoW(Warehouse info){
        this.info = info;
        this.sig = null;
    }
}
