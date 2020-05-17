package Control;

import Entidad.Sistema;
import Entidad.Usuario;
import Frontera.FramePrincipal;
import DAO.UsuarioDAO;
import Entidad.Usuario;

/**
 *
 * @author felipepineda
 */
public class ValidarLogin {

    //private Sistema sistema = FramePrincipal.sistema;
    private UsuarioDAO dao = new UsuarioDAO();

    public ValidarLogin() {
    }

    public String verificarLogin(Usuario usuario) {
        if (!verificarLongitudNombre(usuario.getNombre())) {
            return ("Longitud nombre incorrecta");
        }
        if (!verificarLongitudPassword(usuario.getPassword())) {
            return ("Longitud contraseña incorreta");
        }
        
        /*for (Usuario u : sistema.getUsuarios()) {
            if (u.getNombre().equals(usuario.getNombre()) && u.getPassword().equals(usuario.getPassword())) {
                return ("Bienvenido");
            }
        }*/
        if (dao.leer(usuario) != null) {
            return ("Bienvenido");
        }
        return ("Datos incorrectos");
    }

    public boolean verificarLongitudNombre(String Nombre) {
        return (Nombre.length() > 1 && Nombre.length() <= 6);
    }

    public boolean verificarLongitudPassword(String Password) {
        return (Password.length() >= 3 && Password.length() < 6);
    }

}
