
package controle;

import dao.FamiliaDao;
import dao.GeneroDao;
import dao.OrdemDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Familia;
import modelo.Genero;
import modelo.Ordem;

@ManagedBean (name="insetoControle")
@ViewScoped
public class InsetoControle implements Serializable{
    private List<Ordem> ordens;
    private OrdemDao ordemDao;
    private Ordem ordemSelecionada;
    
    private List<Familia> familias;
    private FamiliaDao familiaDao;
    private Familia familiaSelecionada;
    
    private List<Genero> generos;
    private GeneroDao generoDao;
    private Genero generoSelecionado;

    public InsetoControle() {
        ordemDao = new OrdemDao();
        ordens = ordemDao.listarOrdem();
        ordemSelecionada = new Ordem();
        
        familiaDao = new FamiliaDao();
        familias = familiaDao.listarFamilia();
        familiaSelecionada = new Familia();
        
        generoDao = new GeneroDao();
        generos = generoDao.listarGenero();
        generoSelecionado = new Genero();
        
    }
    
    public void atualizarFamilias(){
        familias = familiaDao.listarPorOrdem(ordemSelecionada);
    }
    
    public void atualizarGeneros(){
        generos = generoDao.listarPorFamilia(familiaSelecionada);
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

    public List<Familia> getFamilias() {
        return familias;
    }

    public void setFamilias(List<Familia> familias) {
        this.familias = familias;
    }

    public FamiliaDao getFamiliaDao() {
        return familiaDao;
    }

    public void setFamiliaDao(FamiliaDao familiaDao) {
        this.familiaDao = familiaDao;
    }

    public Familia getFamiliaSelecionada() {
        return familiaSelecionada;
    }

    public void setFamiliaSelecionada(Familia familiaSelecionada) {
        this.familiaSelecionada = familiaSelecionada;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public GeneroDao getGeneroDao() {
        return generoDao;
    }

    public void setGeneroDao(GeneroDao generoDao) {
        this.generoDao = generoDao;
    }

    public Genero getGeneroSelecionado() {
        return generoSelecionado;
    }

    public void setGeneroSelecionado(Genero generoSelecionado) {
        this.generoSelecionado = generoSelecionado;
    }
    
    
}
