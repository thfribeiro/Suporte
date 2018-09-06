package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import usuarios.Usuario;


@ManagedBean (name="usuarioControle")
@ViewScoped
public class UsuarioControle implements Serializable{   

    private List<Usuario> usuarios;
    private Dao<Usuario> dao;
    private Usuario novo;
    private Usuario temp;
    private boolean mostraPopupNovo;
    
    public UsuarioControle(){
        dao = new Dao(Usuario.class);
        novo = new Usuario();
        usuarios = dao.listarTodos();
        mostraPopupNovo = false; 
    }
    
    public void excluirUsuario(Usuario u){
        dao.excluir(u.getId());
        usuarios.remove(u); // remove da List
    }
    
    public void inserirUsuario(){
        dao.inserir(novo);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
        "Usuário cadastrado", null));
        usuarios = dao.listarTodos();
        novo = new Usuario();
    }
    
    
    public void preparaEditarUsuario(Usuario u){
        temp = u;
   
    }
    
    public void alterarUsuario(){
        dao.alterar(temp);
    }
    
    public void abrirPopupNovo() {
        this.mostraPopupNovo = true;
    }
    
    public void fecharPopupNovo(){
        mostraPopupNovo = false;
    }
    
    public boolean isMostraPopupNovo() {
        return mostraPopupNovo;
    }

    public void setMostraPopupNovo(boolean mostraPopupNovo) {
        this.mostraPopupNovo = mostraPopupNovo;
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Dao<Usuario> getDao() {
        return dao;
    }

    public void setDao(Dao<Usuario> dao) {
        this.dao = dao;
    }

    public Usuario getNovo() {
        return novo;
    }

    public void setNovo(Usuario novo) {
        this.novo = novo;
    }
    
    public Usuario getTemp() {
        return temp;
    }

    public void setTemp(Usuario temp) {
        this.temp = temp;
    }
    
    
    
}