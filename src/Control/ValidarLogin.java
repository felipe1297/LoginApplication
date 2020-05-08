package Control;

import Entidad.Sistema;
import Entidad.Usuario;
import Frontera.FramePrincipal;

/**
 *
 * @author felipepineda
 */
public class ValidarLogin {

    private Sistema sistema = FramePrincipal.sistema;

    public ValidarLogin() {
    }

    public String verificarLogin(Usuario usuario) {
        if (!verificarLongitudNombre(usuario.getNombre())) {
            return ("Longitud nombre incorrecta");
        }
        if (!verificarLongitudPassword(usuario.getPassword())) {
            return ("Longitud contraseña incorreta");
        }
        for (Usuario u : sistema.getUsuarios()) {
            if (u.getNombre().equals(usuario.getNombre()) && u.getPassword().equals(usuario.getPassword())) {
                return ("Bienvenido");
            }
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
