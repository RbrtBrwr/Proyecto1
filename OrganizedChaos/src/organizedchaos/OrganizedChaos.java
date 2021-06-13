///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package organizedchaos;
//
///**
// *
// * @author Robert Brewer, Carlos Carrasquero, Ignacio Lemmo
// *
// *
// */
//public class OrganizedChaos {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//
//        //Llamamos a la clase para abrir y leer el archivo .txt.
//
//        String[] separados;
//        
//        try{
//            separados = (Openertxt.read()).split(";");
//<<<<<<< HEAD
//
//=======
//            ListI itemsList = new ListI();
//>>>>>>> Ignacio
//
//            //if (file.read() == null){System.exit(0);}
//            //Separo los datos del .txt en base a los ; que contenga.
//
//            //Llamamos a la clase para crear la lista de Almacenes y calles.
//            ListW warehouseList = new ListW();
//            ListS roadsList = new ListS();
//            //Creamos un ciclo For que recorra todos los elementos que se hayan guaradado despues del split en base al ;.
//            for (int i = 0; i < separados.length; i++) {
//                //Generamos un if para determinar si el elemento pertenece a los almacenes.
//                if (separados[i].contains("Almacen ")) {
//                    // Si pertenece a los almacenes vamos a separar su información en base a los : que contengan y asi separar el nombre del almacen de sus items.
//                    String[] warehouses = separados[i].split(":");
//                        //Creamos otra lista, pero esta va a ser los inventarios de cada almacen.
//                        ListI inventoryList = new ListI();
//                        //Declaramos la variable name que determinara el nombre del almacen que estemos recorriendo.
//                        String name = warehouses[0].replace("\n","");
//                        //Volvemos a separar, esta vez los items de cada almacen para tener su cantidad y nombre.
//                        String[] inventory = warehouses[1].split("\n");
//                        //Recorremos los items con sus debidas cantidades.
//                        for (int k = 1; k < inventory.length; k++) {
//                            //Separamos los items de sus cantidades en base a la , que tienen de por medio.
//                            String[] items = inventory[k].split(",");
//                            //Asignamos la variable item que contiene el nombre del item.
//                            String item = items[0];
//                            String numberString = items[1];
//                            //Asignamos la variable number que contiene el numero en formato entero de la cantidad del item.
//                            int number = Integer.parseInt(numberString);
//                            //Creamos un objeto que contenga el nombre y la cantidad de cada item.
//                            Inventory thing = new Inventory(item, number);
//                            //Agregamos ese objeto a la lista que sera el inventario de cada almacen.
//                            inventoryList.addLast(thing);
//<<<<<<< HEAD
//=======
//                            itemsList.addLast(thing);
//>>>>>>> Ignacio
//                        }
//                        //prueba
//                        //inventoryList.showNodes();
//
//                        Warehouse warehouse = new Warehouse(name, inventoryList);
//                        warehouseList.addLast(warehouse);
//                } //Generamos un else if para determinar si el elemento pertenece a las Rutas.
//                else if (separados[i].contains("Rutas")) {
//                    String[] routs = separados[i + 1].split("\n");
//
//                    for (int j = 1; j < routs.length; j++) {
//                        String[] streets = routs[j].split(",");
//                        String warehouse1 = "Almacen " + streets[0];
//                        String warehouse2 = "Almacen " + streets[1];
//                        String distanceString = streets[2];
//                        int distance = Integer.parseInt(distanceString);
//                        Street roads = new Street(warehouse1, warehouse2, distance);
//                        roadsList.addLast(roads);
//                    }
//                }
//            }
//<<<<<<< HEAD
//            
//
//        
//            
//            Grafo miGrafo = new Grafo(warehouseList, roadsList);
//            
//            InterfazMenuInicial menu = new InterfazMenuInicial(); //Creo interfaz con la lista de almacenes como parámetro
//            menu.setLocationRelativeTo(null);
//            menu.setVisible(true);
//
//            miGrafo.mostrarMatriz();
////
////
////            System.out.println(miGrafo.DFSTodo());
////            System.out.println(miGrafo.BFSTodo());
////            
////            System.out.println(miGrafo.BFSItem("ram"));
////            System.out.println(miGrafo.DFSItem("grafica"));
////            miGrafo.checkStreets();
////            
////            Warehouse almacen = new Warehouse("Almacen F", null);
////            Street calle1 = new Street("Almacen F", "Almacen E", 2);
////            Street calle2 = new Street("Almacen A", "Almacen F", 1);            
////            miGrafo = miGrafo.agregarAlmacen(almacen, calle1, calle2);
////            
////            almacen = new Warehouse("Almacen G", null);
////            calle1 = new Street("Almacen G", "Almacen A", 9);
////            calle2 = new Street("Almacen C", "Almacen G", 7); 
////            miGrafo = miGrafo.agregarAlmacen(almacen, calle1, calle2);
////            
////            almacen = new Warehouse("Almacen H", null);
////            calle1 = new Street("Almacen H", "Almacen D", 4);
////            calle2 = new Street("Almacen E", "Almacen H", 20); 
////            miGrafo = miGrafo.agregarAlmacen(almacen, calle1, calle2);
////            
////            almacen = new Warehouse("Almacen I", null);
////            calle1 = new Street("Almacen I", "Almacen B", 11);
////            calle2 = new Street("Almacen B", "Almacen I", 2); 
////            miGrafo = miGrafo.agregarAlmacen(almacen, calle1, calle2);
////
////            Street nueva = new Street("Almacen E", "Almacen B", 12);
////            miGrafo.agregarCalle(nueva);
////
////            nueva = new Street("Almacen D", "Almacen D", 12);
////            miGrafo.agregarCalle(nueva);
//            miGrafo.mostrarMatriz();
//            
//            MatrizAdy prueba = miGrafo.FWtemp();
//            
//            prueba.muestraMatriz();
//            
//            ListI pedido = new ListI();
//            Inventory nuevo = new Inventory("Pantalla",1);
//            pedido.addLast(nuevo);
//            nuevo = new Inventory("ram",1);
//            pedido.addLast(nuevo);
//            nuevo = new Inventory("procesador",3);
//            pedido.addLast(nuevo);
//            nuevo = new Inventory("placa",1);
//            pedido.addLast(nuevo);
//            nuevo = new Inventory("teclado",1);
//            pedido.addLast(nuevo);
//            nuevo = new Inventory("microfono",1);
//            pedido.addLast(nuevo);
//            nuevo = new Inventory("audifonos",2);
//            pedido.addLast(nuevo);
//            
//            Warehouse almacen = miGrafo.warehouseList.getWarehouse(0);
//
//            ListI pruebaenvio = miGrafo.realizarPedido(pedido, almacen, prueba.mAdy);
//            System.out.println(pruebaenvio.showNodes());
////            
////            String outText = miGrafo.paraGuardar();
////            System.out.println(outText);
////            
////            Openertxt.write(outText);
//=======
//            InterfazMenuInicial menu = new InterfazMenuInicial(); //Creo interfaz con la lista de almacenes como parámetro
//            menu.setLocationRelativeTo(null);
//            menu.setVisible(true);
//>>>>>>> Ignacio
//            
//        } catch (NullPointerException e){
//            System.exit(0);
//        }
//        
//    }
//}
//
