/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Controlador.ControladorPersona;
import Forms.Form;

/**
 *
 * @author Working
 */
public class Crud {
    
    public static void main(String[] args){
        Persona per =  new Persona();
        Consultas cons = new Consultas();
        Form frm = new Form();
        
        ControladorPersona cont = new ControladorPersona(per,cons,frm);
        cont.iniciar();
        frm.setVisible(true);
        
    }
    
}
