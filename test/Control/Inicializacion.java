/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;
import java.util.ArrayList;
import org.junit.*;

/**
 *
 * @author USER
 */
public class Inicializacion {
    
   @Test
    public void initData() {
        
        UsuarioDAO dao = new UsuarioDAO();
        

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        //Creacion Usuarios
        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();

        //Generacion de nombre y contaseñas
        a.setNombre("Juan");
        a.setPassword("1234");
        b.setNombre("Pedro");
        b.setPassword("123");
        c.setNombre("Maria");
        c.setPassword("12345");

        //Se añaden usuarios
        usuarios.add(a);
        usuarios.add(b);
        usuarios.add(c);
        
        //sistema.setUsuarios(usuarios);
        
        //for (Usuario u: sistema.getUsuarios()) {
        for (Usuario u: usuarios){
            System.out.println(u.getNombre());
            System.out.println(u.getPassword());
            System.out.println("------------");
            dao.crear(u);
        }
        
    }
}
