
package util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;
import usuarios.Administrador;
import usuarios.Usuario;

public class FiltroAutenticacao implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        String pagina = facesContext.getViewRoot().getViewId();
        if(pagina.contains("/index")){
            return;
        }
        else if(pagina.contains("/cadastro")){
            return;
        }
        else if (pagina.contains("/loginUsuario")){
            return ;
        }
        else if (pagina.contains("/loginADM")) {
            return ;
        }
        Administrador usuarioLogado = (Administrador) session.getAttribute("usuarioLogado");
        Usuario usuarioLogado2 = (Usuario) session.getAttribute("usuarioLogado2");
        
        
        if (usuarioLogado == null) {
            NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
            nh.handleNavigation(facesContext, null, "/loginADM?faces-redirect=true");
            facesContext.renderResponse();
        }
        else if (usuarioLogado2 == null) {
            NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
            nh.handleNavigation(facesContext, null, "/loginUsuario?faces-redirect=true");
            facesContext.renderResponse();
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {        

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW; 
    }

    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

}
