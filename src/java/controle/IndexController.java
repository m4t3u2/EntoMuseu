package controle;

import dao.UsuarioDao;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

@ManagedBean (name="indexController")
@ViewScoped
public class IndexController implements Serializable{
    private Usuario usr;
    
    public IndexController(){
        usr = new Usuario();
    }
    
    public String autenticar(){
//        UsuarioDao ud = new UsuarioDao();
//        Usuario temp;
//        temp = ud.autenticar(getUsr());
//        if (temp == null){
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha inválidos.", null));
//            return null;  //fica na página
//        }  
//        //seta usuario na Sessao
//        FacesContext context = FacesContext.getCurrentInstance();
//        ExternalContext ectx = context.getExternalContext();
//        HttpSession session = (HttpSession) ectx.getSession(true);
//        session.setAttribute("usuarioLogado", getUsr());        
        return "menu?faces-redirect=true";    // vai para o menu
    }

    public Usuario getUsr() {
        return usr;
    }

    public void setUsr(Usuario usr) {
        this.usr = usr;
    }
    
}
