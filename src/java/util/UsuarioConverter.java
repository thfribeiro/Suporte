package util;

import dao.Dao;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import usuarios.Usuario;

@FacesConverter(value = "usuarioConverter", forClass=Usuario.class)
public class UsuarioConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        String nome;
        Usuario temp = null;
        Dao<Usuario> dao = new Dao(Usuario.class);
        try {
            nome = value;
            temp = dao.buscarPorNomeUsuario(nome);
	} catch (Exception e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro","Selecione um usuário"));
	}
 	return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj instanceof Usuario){
            Usuario u = (Usuario)obj;
            return u.getNome();
        }
        return "";
    }
    
}