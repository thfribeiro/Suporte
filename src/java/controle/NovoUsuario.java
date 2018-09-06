package controle;

import dao.Dao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import usuarios.Usuario;

@ManagedBean (name ="novoUsuario")
@ViewScoped
public class NovoUsuario implements Serializable{
    private Usuario usuario;
    private Dao<Usuario> dao;
    
    public NovoUsuario(){
        usuario = new Usuario();
        dao = new Dao(Usuario.class);
    }
 
    
    public void inserirUsuario(){
        dao.inserir(usuario);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Cadastro efetuado", null));
        
        usuario = new Usuario();
    }
    
    
    public Usuario getUsuario() { 
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Dao<Usuario> getDao() {
        return dao;
    }

    public void setDao(Dao<Usuario> dao) {
        this.dao = dao;
    }
    
    
}

