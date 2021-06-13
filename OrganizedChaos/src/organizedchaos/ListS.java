/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizedchaos;

/**
 * Lista de Streets
 * @author Robert
 */
public class ListS {
    protected class Nodo{
        Street info;
        Nodo sig;
        
        public Nodo(Street info){
            this.info = info;
            this.sig = null;
        }
    }
    Nodo headS = null;
    Nodo tailS = null;
    
    
    
    /**
     * Imprime la lista de calles
     */
    public void showNodes(){
        Nodo track = headS;
        if (track == null) {
            System.out.println("Lista vacia");
            return;
        }
        while (track != null){
            System.out.println("salida: " + track.info.out + "\nllegada: " + track.info.in + "\ndistancia: " + track.info.distance);
            track = track.sig;
        }
    }
    
    /**
     * agrega el Street info a la lista
     * @param info 
     */
    public void addLast(Street info){
        
        Nodo nuevo = new Nodo(info);
        if (headS == null){
            headS = tailS = nuevo;
        } else {
            tailS.sig = nuevo;
            tailS = nuevo;
        }
    }
    
    /**
     * elimina la calle de la lista, compara nombre de almacen de entrada, salida y su longitud para asegurarse de que es la correcta.
     * 
     * capaz cambiarlo a que el parametro sea un Street?
     * @param almacen1
     * @param almacen2
     * @param longitud 
     */
    public void removeRd(String almacen1, String almacen2, int longitud){
        Nodo track = headS;
        Nodo prev = null;
        while (track != null){
            if (headS.info.in.equalsIgnoreCase(almacen2) && headS.info.out.equalsIgnoreCase(almacen1) && headS.info.distance == longitud){
                headS = headS.sig;
                return;
            } else if (track.info.in.equalsIgnoreCase(almacen2) && track.info.out.equalsIgnoreCase(almacen1) && track.info.distance == longitud){
                prev.sig = track.sig;
                return;
            } else {
                prev = track;
                track = track.sig;
            }
        }
        
        System.out.println("Calle no existe");
    }
    
    /**
     * Retorna un String para guardar los cambios que sufrió el archivo.
     * @return String
     */
    public String guardarArchivo(){
        String archivo = "Rutas;\n";
        Nodo track = this.headS;
        while (track != null){
            archivo += track.info.out.replaceAll("Almacen ", "") + "," + track.info.in.replaceAll("Almacen ", "") + "," + track.info.distance + "\n";
            track = track.sig;
        }
        return archivo;
                
    }
}
