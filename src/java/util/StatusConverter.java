package util;

import dao.Dao;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import usuarios.Status;

@FacesConverter(value = "statusConverter", forClass=Status.class)
public class StatusConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        String nome;
        Status temp = null;
        Dao<Status> dao = new Dao(Status.class);
        try {
            nome = value;
            temp = dao.buscarPorNomeStatus(nome);
	} catch (Exception e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro","Selecione um usuário"));
	}
 	return temp;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj instanceof Status){
            Status u = (Status)obj;
            return u.getNome();
        }
        return "";
    }
    
}