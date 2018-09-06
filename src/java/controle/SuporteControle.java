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
import usuarios.Suporte;
import usuarios.Usuario;


@ManagedBean (name="suporteControle")
@ViewScoped
public class SuporteControle implements Serializable{   
    
    private Usuario usuariologado;
    private List<Suporte> solicitacoes;
    private List<Suporte> solicitacoesADM;
    private Dao<Suporte> dao;
    private Suporte novo;
    private Suporte temp;
    private boolean mostraPopupNovo;


    
    public SuporteControle(){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(false);
        usuariologado = (Usuario) session.getAttribute("usuarioLogado2");
        dao = new Dao(Suporte.class);
        novo = new Suporte();
        solicitacoes = dao.listarSolicitacoesPorUsuario(usuariologado);
        solicitacoesADM = dao.listarTodos();
        mostraPopupNovo = false; 
    }

    public void excluirSuporte(Suporte u){
        dao.excluir(u.getId());
        solicitacoes.remove(u); // remove da List
    }
    
    public void inserirSuporte(){
        dao.inserir(novo);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
        "Suporte cadastrado", null));
        solicitacoes = dao.listarTodos();
        novo = new Suporte();
    }
    
    public void preparaEditarSuporte(Suporte u){
        temp = u;
   
    }
    
    public void alterarSuporte(){
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

    public List<Suporte> getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(List<Suporte> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }

    public Dao<Suporte> getDao() {
        return dao;
    }

    public void setDao(Dao<Suporte> dao) {
        this.dao = dao;
    }

    public Suporte getNovo() {
        return novo;
    }

    public void setNovo(Suporte novo) {
        this.novo = novo;
    }

    public Suporte getTemp() {
        return temp;
    }

    public void setTemp(Suporte temp) {
        this.temp = temp;
    }
    
        public Usuario getUsuariologado() {
        return usuariologado;
    }

    public void setUsuariologado(Usuario usuariologado) {
        this.usuariologado = usuariologado;
    }

    public List<Suporte> getSolicitacoesADM() {
        return solicitacoesADM;
    }

    public void setSolicitacoesADM(List<Suporte> solicitacoesADM) {
        this.solicitacoesADM = solicitacoesADM;
    }


}