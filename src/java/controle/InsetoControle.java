
package controle;

import dao.EspecieDao;
import dao.FamiliaDao;
import dao.GeneroDao;
import dao.OrdemDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import modelo.Especie;
import modelo.Familia;
import modelo.Genero;
import modelo.Ordem;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

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

    private Especie novaEspecie;
    private EspecieDao especieDao;
    
    private Part arquivo;
               
    public InsetoControle() {
        ordemDao = new OrdemDao();
        ordens = ordemDao.listarOrdem();
        ordemSelecionada = new Ordem();
        
        familiaDao = new FamiliaDao();
        familias = new ArrayList<>();
        familiaSelecionada = new Familia();
        
        generoDao = new GeneroDao();
        generos = new ArrayList<>();
        generoSelecionado = new Genero();
        
        novaEspecie = new Especie();
        especieDao = new EspecieDao(); 
    }
    
    public void atualizarFamilias(){
        familias = familiaDao.listarPorOrdem(ordemSelecionada);
    }
    
    public void atualizarGeneros(){
        generos = generoDao.listarPorFamilia(familiaSelecionada);
    }
    
    public void cadastrar(){
        novaEspecie.setGenero(generoSelecionado);
        especieDao.inserir(novaEspecie);
        novaEspecie = new Especie();        
    }
   
    public void upar() {
        System.out.println("oi");
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

    public Especie getNovaEspecie() {
        return novaEspecie;
    }

    public void setNovaEspecie(Especie novaEspecie) {
        this.novaEspecie = novaEspecie;
    }

    public EspecieDao getEspecieDao() {
        return especieDao;
    }

    public void setEspecieDao(EspecieDao especieDao) {
        this.especieDao = especieDao;
    }

    public Part getArquivo() {
        return arquivo;
    }

    public void setArquivo(Part arquivo) {
        this.arquivo = arquivo;
    }
    
    
}
