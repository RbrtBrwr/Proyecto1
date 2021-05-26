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
public class Warehouse {
    String name;
    ListMaker items;
    public Warehouse(String letter, ListMaker inventory){
        this.name = letter;
        this.items = inventory;
    }
}
