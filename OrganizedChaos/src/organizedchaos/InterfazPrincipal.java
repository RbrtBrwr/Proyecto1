/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizedchaos;
  
import javax.swing.JOptionPane;
import static organizedchaos.InterfazMenuInicial.miGrafo;
import static organizedchaos.InterfazMenuInicial.warehouseList;


/**
 *
 * @author CATATO
 */
public class InterfazPrincipal extends javax.swing.JFrame {
    String producto; //Toma lo que ingrese el usuario en la caja desplegable de productos.
    String cantidad; //Toma el número que ingrese el usuario de la cantidad de productos escogidos deseada. 
    String stringPedido; //String de concatenación de todos los productos y las cantidades que escoja el usuario.
    String mensajes;
    String almacen;
    ListI listaPedido; //Lista donde se almacenará el pedido que vaya a realizar el usuario
    ListI matrizAlmacenes; //Lista que se usa para el Dijkstra CODIGO, DIST MIN DESDE INICIO, PREDECESOR, VISITADO.
    ListDijkstra listaNodosDijkstra;


    /**
     * Creates new form InterfazPrincipal
     */
    
    public static InterfazMenuInicial menuInicial; 
            
    public InterfazPrincipal(InterfazMenuInicial menuInicial) {
        initComponents();
        //Aquí se rellena toda la interfaz
        this.menuInicial = menuInicial;
        this.listaPedido = new ListI();
        this.listaNodosDijkstra = new ListDijkstra();
        ListMaker productos = new ListMaker(); //Se crea lista vacía para almacenar todos los productos sin repetición a partir de la clase ListMaker
        
        
        for (int i = 0; i < menuInicial.miGrafo.warehouseList.getSize(); i++) {
        //Este ciclo es para recorrer todos los Almacenes en el grafo e ir llenando las listas desplegables del a interfaz.
            cbAlmacen.addItem(menuInicial.miGrafo.warehouseList.getWarehouse(i).name);
            String[] productosAlmacen = menuInicial.miGrafo.warehouseList.getWarehouse(i).items.showNodesWithoutRepetition(); //ARREGLAR Es un arreglo
            for (int j = 0; j < productosAlmacen.length; j++) {
            //En este ciclo se llena la lista de productos evitando repetición
                if (productos.isEmpty()) {
                    productos.addFirst(productosAlmacen[j]);
                } else if (productos.find(productosAlmacen[j]) == -1) {
                    productos.addFirst(productosAlmacen[j]);  
                }
            }
        }
        
        for (int i = 0; i < productos.getSize(); i++) {
        //Se llenan las listas desplegables a partir de la lista productos
            cbProducto.addItem(productos.getName(i).toString());  
            }
        

        
        
        }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        cbAlmacen = new javax.swing.JComboBox<>();
        lblAlmacen = new javax.swing.JLabel();
        lblProducto = new javax.swing.JLabel();
        cbProducto = new javax.swing.JComboBox<>();
        buttonAgregar = new javax.swing.JButton();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        buttonFuncionamiento = new javax.swing.JButton();
        lblCantidad1 = new javax.swing.JLabel();
        buttonRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPedido = new javax.swing.JTextArea();
        buttonPedido = new javax.swing.JButton();
        BFS = new javax.swing.JButton();
        DFS = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.add(cbAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 130, -1));

        lblAlmacen.setText("Almacén");
        jPanel3.add(lblAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        lblProducto.setText("Producto");
        jPanel3.add(lblProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        jPanel3.add(cbProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 110, -1));

        buttonAgregar.setText("Agregar");
        buttonAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAgregarMouseClicked(evt);
            }
        });
        jPanel3.add(buttonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 100, -1));

        lblCantidad.setText("Su pedido");
        jPanel3.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, -1, -1));
        jPanel3.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 100, -1));

        buttonFuncionamiento.setText("Funcionamiento");
        jPanel3.add(buttonFuncionamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, -1, -1));

        lblCantidad1.setText("Cantidad");
        jPanel3.add(lblCantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        buttonRegresar.setText("Regresar");
        buttonRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRegresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonRegresarMouseEntered(evt);
            }
        });
        jPanel3.add(buttonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));

        txtPedido.setColumns(20);
        txtPedido.setRows(5);
        jScrollPane1.setViewportView(txtPedido);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, -1, 230));

        buttonPedido.setText("Confirmar pedido");
        buttonPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonPedidoMouseClicked(evt);
            }
        });
        jPanel3.add(buttonPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, -1, -1));

        BFS.setText("BFS");
        BFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFSActionPerformed(evt);
            }
        });
        jPanel3.add(BFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        DFS.setText("DFS");
        DFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DFSActionPerformed(evt);
            }
        });
        jPanel3.add(DFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        jLabel2.setText("Mostrar inventario a través de:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/amazon (2).jpg"))); // NOI18N
        jLabel1.setText("fondo");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 400));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRegresarMouseClicked
        // TODO add your handling code here:
        this.dispose(); //Tiene que hacerse dispose para que la próxima vez que se llame empiece desde cero
        menuInicial.setLocationRelativeTo(null);
        menuInicial.setVisible(true);
    }//GEN-LAST:event_buttonRegresarMouseClicked

    private void buttonAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAgregarMouseClicked
        // TODO add your handling code here:
        //cbAlmacen.setEditable(false);
        cbAlmacen.disable();
        almacen = cbAlmacen.getSelectedItem().toString();
        menuInicial.itemsList.group();
        if (stringPedido == null) {
            //La primera vez que el usuario le de al botón "agregar", el stringPedido siempre va a estar vacío y va a entrar aquí.
            producto = cbProducto.getSelectedItem().toString();
            cantidad = txtCantidad.getText().toString(); //Validar
            if (menuInicial.itemsList.checkquantity(producto, Integer.parseInt(cantidad))){
               Inventory  pedido = new Inventory(producto, Integer.parseInt(cantidad));
            listaPedido.agregarItem(pedido);
            stringPedido = almacen+"\n\n"+producto+": "+cantidad+"\n"; //Se llena stringPedido para mostrarlo en la Text Box.
            txtPedido.setText(stringPedido);
            cbProducto.removeItem(producto); //Se elimina de la caja desplegable el producto que acaba de ser seleccionado. 
            }
            else {
                JOptionPane.showMessageDialog(null, "Los almacenes no cuentan con la cantidad suficiente del producto.");
            }

        } else {
            //Cuando el usuario agregue otro producto a su pedido, ya el stringPedido va a tener algo.
            producto = cbProducto.getSelectedItem().toString();
            cantidad = txtCantidad.getText().toString(); //Validar
             if (menuInicial.itemsList.checkquantity(producto, Integer.parseInt(cantidad))){
            Inventory  pedido = new Inventory(producto, Integer.parseInt(cantidad));
            listaPedido.addLast(pedido);
            stringPedido = stringPedido+producto+": "+cantidad+"\n";
            txtPedido.setText(stringPedido);
            cbProducto.removeItem(producto); //Se elimina de la caja desplegable el producto que acaba de ser seleccionado.            
            }
             else {
                JOptionPane.showMessageDialog(null, "Los almacenes no cuentan con la cantidad suficiente del producto.");
            }
        }
    }//GEN-LAST:event_buttonAgregarMouseClicked

    private void buttonPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPedidoMouseClicked
        // TODO add your handling code here:
        
        //if (){
            Warehouse warehouseName = menuInicial.warehouseList.getWarehouse(almacen);
            FloydWarshallAlgorithm pathMatrix = new FloydWarshallAlgorithm(menuInicial.miGrafo, menuInicial.warehouseList.getSize());
            int [][] matrix = pathMatrix.getPathMatrix();
            ListI envio = menuInicial.miGrafo.realizarPedido(listaPedido, warehouseName, pathMatrix, menuInicial.itemsList);
            String envioString = "";
            for (int i = 0; i < envio.size; i++) {
                envioString += envio.getNode(i).info.name + ": " + envio.getNode(i).info.quantity + "\n";
            }
            JOptionPane.showMessageDialog(null, "Su pedido se ha realizado exitosamente: \n" + envioString);
        //}
        //else {
            stringPedido = null;
        
            //Se llena la lista inicial del Dijkstra
            for (int i = 0; i < menuInicial.miGrafo.warehouseList.getSize(); i++) {
                Dijkstra pInfo = new Dijkstra(menuInicial.miGrafo.warehouseList.getName(i));
                listaNodosDijkstra.addLast(pInfo);
            } 
            //Dijkstra
            //El Almacen origen es el que ingresa el usuario en el cbBox
            String origen = cbAlmacen.getSelectedItem().toString();
            listaNodosDijkstra.getInfoAlmacen2(origen).distMinimaInicio = 0;
            listaNodosDijkstra.getInfoAlmacen2(origen).visitado = false;
        
            //Tengo loop infinito aquí. Revisar esto.
            while (listaNodosDijkstra.quedanAlmacenesSinVisitar()){
                int indiceAlmacenActual = listaNodosDijkstra.almacenMenorDistancia();
                listaNodosDijkstra.actualizarTabla(menuInicial.miGrafo, indiceAlmacenActual);
                System.out.println("DIJKSTRA\n");
                listaNodosDijkstra.showNodes();
            }
        //}
        
        
        
        
        
        //Cuando se confirma el pedido el programa debe, en caso de no encontrar el pedido en stock, hacer el recorrido con Dijkstra o Floyd.
        
        
        
        
    }//GEN-LAST:event_buttonPedidoMouseClicked

    private void buttonRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRegresarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRegresarMouseEntered

    private void DFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DFSActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, menuInicial.miGrafo.DFSTodo());
    }//GEN-LAST:event_DFSActionPerformed

    private void BFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFSActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, menuInicial.miGrafo.BFSTodo());
    }//GEN-LAST:event_BFSActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazPrincipal(menuInicial).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BFS;
    private javax.swing.JButton DFS;
    private javax.swing.JButton buttonAgregar;
    private javax.swing.JButton buttonFuncionamiento;
    private javax.swing.JButton buttonPedido;
    private javax.swing.JButton buttonRegresar;
    private javax.swing.JComboBox<String> cbAlmacen;
    private javax.swing.JComboBox<String> cbProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlmacen;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCantidad1;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextArea txtPedido;
    // End of variables declaration//GEN-END:variables
}
