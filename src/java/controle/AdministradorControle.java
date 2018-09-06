package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import usuarios.Administrador;


@ManagedBean (name="admControle")
@ViewScoped
public class AdministradorControle implements Serializable{   

    private List<Administrador> adms;
    private Dao<Administrador> dao;
    private Administrador novo;
    private Administrador temp;
    private boolean mostraPopupNovo;
    
    public AdministradorControle(){
        dao = new Dao(Administrador.class);
        novo = new Administrador();
        adms = dao.listarTodos();
        mostraPopupNovo = false; 
    }
    
    public void excluirAdministrador(Administrador u){
        dao.excluir(u.getId());
        adms.remove(u); // remove da List
    }
    
    public void inserirAdministrador(){
        dao.inserir(novo);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
        "Administrador cadastrado", null));
        adms = dao.listarTodos();
        novo = new Administrador();
    }
    
    
    public void preparaEditarAdministrador(Administrador u){
        temp = u;
   
    }
    
    public void alterarAdministrador(){
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
    
    public List<Administrador> getAdms() {
        return adms;
    }

    public void setUsuarios(List<Administrador> adms) {
        this.adms = adms;
    }

    public Dao<Administrador> getDao() {
        return dao;
    }

    public void setDao(Dao<Administrador> dao) {
        this.dao = dao;
    }

    public Administrador getNovo() {
        return novo;
    }

    public void setNovo(Administrador novo) {
        this.novo = novo;
    }
    
    public Administrador getTemp() {
        return temp;
    }

    public void setTemp(Administrador temp) {
        this.temp = temp;
    }
}