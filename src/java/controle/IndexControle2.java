package controle;

import dao.UsuarioDao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import usuarios.Usuario;


@ManagedBean (name="indexControle2")
@ViewScoped
public class IndexControle2 implements Serializable{
    private Usuario usu;
    
    public IndexControle2(){
        usu = new Usuario();
    }
    
    public String autenticar(){
        UsuarioDao dao = new UsuarioDao();
        Usuario temp;
        temp = dao.autenticar(usu);
        if (temp == null){  // se houver erro, método autenticar no dao retorna null
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha inválidos", null));
            return null;  //fica na página
        }  
        //seta usuario na Sessao
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(true);
        session.setAttribute("usuarioLogado2", temp);
        
        return "menuUsuario";    // menu.xhtml
    }
    
        public String deslogar(){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(false);
        session.setAttribute("usuarioLogado", null);
        return "index";
    }
    
      public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }
}