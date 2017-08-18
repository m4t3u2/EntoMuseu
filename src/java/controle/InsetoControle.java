
package controle;

import dao.OrdemDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Ordem;

@ManagedBean (name="insetoControle")
@ViewScoped
public class InsetoControle implements Serializable{
    private List<Ordem> ordens;
    private OrdemDao ordemDao;
    private Ordem ordemSelecionada;

    public InsetoControle() {
        ordemDao = new OrdemDao();
        ordens = ordemDao.listarOrdem();
        ordemSelecionada = new Ordem();
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
