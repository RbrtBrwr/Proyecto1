/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizedchaos;

/**
 *
 * @author Robert Brewer, Carlos Carrasquero, Ignacio Lemmo
 *
 *
 */
public class OrganizedChaos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Llamamos a la clase para abrir y leer el archivo .txt.

        Openertxt file = new Openertxt();
        //Separo los datos del .txt en base a los ; que contenga.
        String[] separados = (file.main()).split(";");
        //Llamamos a la clase para crear la lista de Almacenes.
        ListMaker warehouseList = new ListMaker();
        //Creamos un ciclo For que recorra todos los elementos que se hayan guaradado despues del split en base al ;.
        for (int i = 0; i < separados.length; i++) {
            //Generamos un if para determinar si el elemento pertenece a los almacenes.
            if (separados[i].contains("Almacen ")) {
                // Si pertenece a los almacenes vamos a separar su información en base a los : que contengan y asi separar el nombre del almacen de sus items.
                String[] warehouses = separados[i].split(":");
                    //Creamos otra lista, pero esta va a ser los inventarios de cada almacen.
                    ListMaker inventoryList = new ListMaker();
                    //Declaramos la variable name que determinara el nombre del almacen que estemos recorriendo.
                    String name = warehouses[0].replace("\n","");
                    //Volvemos a separar, esta vez los items de cada almacen para tener su cantidad y nombre.
                    String[] inventory = warehouses[1].split("\n");
                    //Recorremos los items con sus debidas cantidades.
                    for (int k = 1; k < inventory.length; k++) {
                        //Separamos los items de sus cantidades en base a la , que tienen de por medio.
                        String[] items = inventory[k].split(",");
                        //Asignamos la variable item que contiene el nombre del item.
                        String item = items[0];
                        String numberString = items[1];
                        //Asignamos la variable number que contiene el numero en formato entero de la cantidad del item.
                        int number = Integer.parseInt(numberString);
                        //Creamos un objeto que contenga el nombre y la cantidad de cada item.
                        Inventory thing = new Inventory(item, number);
                        //Agregamos ese objeto a la lista que sera el inventario de cada almacen.
                        inventoryList.addLast(thing);
                    }
                    Warehouse warehouse = new Warehouse(name, inventoryList);
                    warehouseList.addLast(warehouse);
            } //Generamos un else if para determinar si el elemento pertenece a las Rutas.
            else if (separados[i].contains("Rutas")) {
                String[] routs = separados[i + 1].split("\n");
                ListMaker roadsList = new ListMaker();
                for (int j = 1; j < routs.length; j++) {
                    String[] streets = routs[j].split(",");
                    String warehouse1 = streets[0];
                    String warehouse2 = streets[1];
                    String distanceString = streets[2];
                    int distance = Integer.parseInt(distanceString);
                    Street roads = new Street(warehouse1, warehouse2, distance);
                    roadsList.addLast(roads);
                }
            }
        }
    }
}
