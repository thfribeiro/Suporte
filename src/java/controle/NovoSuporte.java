
package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import usuarios.Status;
import usuarios.Suporte;
import usuarios.Usuario;

@ManagedBean (name="solicitaSuporte")
@ViewScoped
public class NovoSuporte implements Serializable{   

    private Usuario usuariologado;
    private Status statusNovo;
    private List<Usuario> usuarios;
    private List<Status> status;
    private Dao<Usuario> daoUsuario;
    private Dao<Status> daoStatus;
    private Suporte suporte; 
    Dao<Suporte> daoSuporte; 
    
    public NovoSuporte(){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(false);
        usuariologado = (Usuario) session.getAttribute("usuarioLogado2");
        daoStatus = new Dao(Status.class);        
        statusNovo = daoStatus.buscarPorCodigo(1);
        daoUsuario = new Dao(Usuario.class);
        usuarios = daoUsuario.listarTodos();
        status = daoStatus.listarTodos();
        daoSuporte = new Dao(Suporte.class);
        suporte = new Suporte();
    }

    public List<Status> getStatus() {
        return status;
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }



    public Dao<Status> getDaoStatus() {
        return daoStatus;
    }

    public void setDaoStatus(Dao<Status> daoStatus) {
        this.daoStatus = daoStatus;
    }
    
    public void registraSuporte(){
        suporte.setStatus(statusNovo);
        suporte.setUsuario(usuariologado);
        daoSuporte.inserir(suporte);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Suporte solicitado com sucesso", null));
        suporte = new Suporte(); 
    }
    
        public void registraSuporteADM(){
        daoSuporte.inserir(suporte);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Suporte solicitado com sucesso", null));
        suporte = new Suporte(); 
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Dao<Usuario> getDaoUsuario() {
        return daoUsuario;
    }

    public void setDaoUsuario(Dao<Usuario> daoUsuario) {
        this.daoUsuario = daoUsuario;
    }

    public Suporte getSuporte() {
        return suporte;
    }

    public void setSuporte(Suporte suporte) {
        this.suporte = suporte;
    }

    public Dao<Suporte> getDaoSuporte() {
        return daoSuporte;
    }

    public void setDaoSuporte(Dao<Suporte> daoSuporte) {
        this.daoSuporte = daoSuporte;
    }

     public Usuario getUsuariologado() {
        return usuariologado;
    }

    public void setUsuariologado(Usuario usuariologado) {
        this.usuariologado = usuariologado;
    }
    
    public Status getStatusNovo() {
        return statusNovo;
    }

    public void setStatusNovo(Status statusNovo) {
        this.statusNovo = statusNovo;
    }
}