package controle;

import dao.OrdemDao;
import dao.UsuarioDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Ordem;
import modelo.Usuario;

@ManagedBean(name = "indexController")
@ViewScoped
public class IndexController implements Serializable {

    private Usuario usr;

    private List<Ordem> ordens;
    private OrdemDao ordemDao;
    private Ordem ordemSelecionada;

    public IndexController() {
        usr = new Usuario();

        ordemDao = new OrdemDao();
        ordens = ordemDao.listarOrdem();
        ordemSelecionada = new Ordem();
        System.out.println(ordens.size());
    }

    public String autenticar() {
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

    public List<Ordem> getOrdens() {
        return ordens;
    }

    public void setOrdens(List<Ordem> ordens) {
        this.ordens = ordens;
    }

    public OrdemDao getOrdemDao() {
        return ordemDao;
    }

    public void setOrdemDao(OrdemDao ordemDao) {
        this.ordemDao = ordemDao;
    }

    public Ordem getOrdemSelecionada() {
        return ordemSelecionada;
    }

    public void setOrdemSelecionada(Ordem ordemSelecionada) {
        this.ordemSelecionada = ordemSelecionada;
    }
    
}
