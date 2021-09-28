//Instrucciones para detectar acciones del formulario, en botones y enviar datos a las cajas de texto
package Controlador;

import Clases.Consultas;
import Clases.Persona;
import Forms.Form;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorPersona implements ActionListener {

    private Persona per;
    private Consultas cons;
    private Form frm;

    public ControladorPersona(Persona per, Consultas cons, Form frm) {
        this.per = per;
        this.cons = cons;
        this.frm = frm;
        this.frm.btn_guardar.addActionListener(this);
        this.frm.btn_editar.addActionListener(this);
        this.frm.btn_eliminar.addActionListener(this);
        this.frm.btn_borrar.addActionListener(this);
        this.frm.btn_buscar.addActionListener(this);
    }

    //Metodo para iniciar el formulario
    public void iniciar() {
        frm.setTitle("Persona");
        frm.setLocationRelativeTo(null);
        frm.txt_id.setVisible(false);
    }
    
    //Metodo que escucha los clicks de los botones
    @Override
    public void actionPerformed(ActionEvent e){
        //Verifica si se le dio click al boton GUARDAR
        if(e.getSource()== frm.btn_guardar){
            per.setId_persona(frm.txt_id_persona.getText());
            per.setNombre(frm.txt_Nombre.getText());
            per.setApellido(frm.txt_Apellido.getText());
            per.setEmail(frm.txt_Email.getText());
            per.setTelefono(frm.txt_Telefono.getText());
            //Llamamos al metodo registrar de la clase Consultas  
            if(cons.registrar(per)){
                JOptionPane.showMessageDialog(null,"REGISTRO EXITOSO",null,JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            }else{
                 JOptionPane.showMessageDialog(null,"ERROR AL REGISTRAR");
                 limpiar();
            }
        }
        //Verifica si se le dio click al boton EDITAR
        if(e.getSource()== frm.btn_editar){
            per.setId(Integer.parseInt(frm.txt_id.getText()));
            per.setId_persona(frm.txt_id_persona.getText());
            per.setNombre(frm.txt_Nombre.getText());
            per.setApellido(frm.txt_Apellido.getText());
            per.setEmail(frm.txt_Email.getText());
            per.setTelefono(frm.txt_Telefono.getText());
        //Llamamos al metodo editar de la clase Consultas    
            if(cons.editar(per)){
                JOptionPane.showMessageDialog(null,"REGISTRO EDITADO EXITOSAMENTE",null,JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            }else{
                 JOptionPane.showMessageDialog(null,"ERROR AL EDITAR");
                 limpiar();
            }
        }
        //Verifica si se le dio click al boton ELIMINAR
        if(e.getSource()== frm.btn_eliminar){
            per.setId(Integer.parseInt(frm.txt_id.getText()));
            //Llamamos al metodo eliminar de la clase Consultas
            if(cons.eliminar(per)){
                JOptionPane.showMessageDialog(null,"REGISTRO ELIMINADO EXITOSAMENTE",null,JOptionPane.WARNING_MESSAGE);
                limpiar();
            }else{
                 JOptionPane.showMessageDialog(null,"ERROR AL ELIMINAR");
                 limpiar();
            }
        }
        //Verifica si se le dio click al boton BUSCAR
        if(e.getSource()== frm.btn_buscar){
            per.setId_persona(frm.txt_id_persona.getText());
            //Llamamos al metodo consultar de la clase Consultas
            if(cons.consultar(per)){
                //Traemos los valores a cada caja de texto
                frm.txt_id.setText(String.valueOf(per.getId()));
                frm.txt_id_persona.setText(per.getId_persona());
                frm.txt_Nombre.setText(per.getNombre());
                frm.txt_Apellido.setText(per.getApellido());
                frm.txt_Email.setText(per.getEmail());
                frm.txt_Telefono.setText(per.getTelefono());
            }else{
                 JOptionPane.showMessageDialog(null,"Ningun resutlado encontrado");
                 limpiar();
            }
        }
        //Verifica si se le dio click al boton BORRAR
         if(e.getSource()== frm.btn_borrar){
             //Llamamos al metodo Limpiar.
             limpiar();
         }
    }
    
    //Borra las datos de las cajas de Texto
    public void limpiar(){
    frm.txt_id.setText(null);
    frm.txt_id_persona.setText(null);
    frm.txt_Nombre.setText(null);
    frm.txt_Apellido.setText(null);
    frm.txt_Email.setText(null);
    frm.txt_Telefono.setText(null);
    }
    
}
