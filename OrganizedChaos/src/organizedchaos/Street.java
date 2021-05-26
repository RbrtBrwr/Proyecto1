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
public class Street {
    int distance;
    String in;
    String out;
    public Street(String sout, String sin, int sdistance){
        this.in = sin;
        this.out = sout;
        this.distance = sdistance;
    }
}
