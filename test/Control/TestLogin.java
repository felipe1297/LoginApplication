/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import org.junit.BeforeClass;
import org.junit.Test;
import Entidad.Usuario;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

/**
 *
 * @author clau_
 */
public class TestLogin {
    
    private static ValidarLogin validar = new ValidarLogin();
    
    private String LONG_NOMBRE_INCORRECTA = "Longitud nombre incorrecta";
    private String  LONG_PASSWORD_INCORRECTA = "Longitud contraseña incorreta";
    private String DATOS_INCORRECTOS = "Datos incorrectos";
    private String USUARIO_AUTORIZADO = "Bienvenido";
    
    public TestLogin() {
    }
    
    @Before
    public void setUp(){
        
    }
    
    @Test
    public void testLongitudNombre() {
        
        Usuario u = new Usuario();
        u.setNombre("R");
        u.setPassword("123456");
        assertEquals(validar.verificarLogin(u), LONG_NOMBRE_INCORRECTA);
        
        u.setNombre("Roberto");
        u.setPassword("123456");
        assertEquals(validar.verificarLogin(u), LONG_NOMBRE_INCORRECTA);
        
    }
    
    @Test
    public void testLongitudContrasenia(){
        
        Usuario u = new Usuario();
        
        u.setNombre("Pepe");
        u.setPassword("12");
        assertEquals(validar.verificarLogin(u), LONG_PASSWORD_INCORRECTA);
        
        u.setNombre("Pepe");
        u.setPassword("123456");
        assertEquals(validar.verificarLogin(u), LONG_PASSWORD_INCORRECTA);
    }
    
    @Test
    public void testNombre(){
        
        Usuario u = new Usuario();
        u.setNombre("Henry");
        u.setPassword("12345");
        assertEquals(validar.verificarLogin(u), DATOS_INCORRECTOS);
        
    }
    
    @Test
    public void testContrasenia(){
        
        Usuario u = new Usuario();
        
        u.setNombre("maria");
        u.setPassword("1234");
        assertEquals(validar.verificarLogin(u), DATOS_INCORRECTOS);
        
    }
    
    @Test
    public void testDatos(){
        
        Usuario u = new Usuario();
        
        u.setNombre("Henry");
        u.setPassword("A234");
        assertEquals(validar.verificarLogin(u), DATOS_INCORRECTOS);
        
    }
    
    @Test
    public void testTodoCorrecto(){
        
        Usuario u = new Usuario();
        
        u.setNombre("juan");
        u.setPassword("1234");
        assertEquals(validar.verificarLogin(u), USUARIO_AUTORIZADO);
        
        
        u.setNombre("pedro");
        u.setPassword("123");
        assertEquals(validar.verificarLogin(u), USUARIO_AUTORIZADO);
        
        u.setNombre("maria");
        u.setPassword("12345");
        assertEquals(validar.verificarLogin(u), USUARIO_AUTORIZADO);
        
    }
    
}
