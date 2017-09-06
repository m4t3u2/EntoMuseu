package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import util.Sessao;

@ManagedBean(name = "menuController")
@ViewScoped
public class MenuController {

    public String deslogar() {
        Sessao.invalidar();
        return "index";
    }
}
