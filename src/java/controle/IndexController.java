package controle;

import dao.EspecieDao;
import dao.FamiliaDao;
import dao.GeneroDao;
import dao.OrdemDao;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import modelo.Especie;
import modelo.Familia;
import modelo.Genero;
import modelo.Ordem;
import modelo.Usuario;

@ManagedBean(name = "indexController")
@ViewScoped
public class IndexController implements Serializable {

    private Usuario usr;

    private List<Ordem> ordens;
    private OrdemDao ordemDao;
    private Ordem ordemSelecionada;

    private List<Familia> familias;
    private FamiliaDao familiaDao;
    private Familia familiaSelecionada;

    private List<Genero> generos;
    private GeneroDao generoDao;
    private Genero generoSelecionado;

    private List<Especie> especies;
    private EspecieDao especieDao;
    private Especie especieSelecionada;

    private String caminho;

    public IndexController() {
        usr = new Usuario();

        ordemDao = new OrdemDao();
        ordens = ordemDao.listarOrdem();
        ordemSelecionada = new Ordem();
        System.out.println(ordens.size());

        familiaDao = new FamiliaDao();
        familias = new ArrayList<>();
        familiaSelecionada = new Familia();

        generoDao = new GeneroDao();
        generos = new ArrayList<>();
        generoSelecionado = new Genero();

        especieDao = new EspecieDao();
        especies = new ArrayList<>();
        especieSelecionada = new Especie();

        caminho = "";
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

    public void atualizarFamilias() {
        familias = familiaDao.listarPorOrdem(ordemSelecionada);
    }

    public void atualizarGeneros() {
        generos = generoDao.listarPorFamilia(familiaSelecionada);
    }

    public void atualizarEspecies() {
        especies = especieDao.listarPorGenero(generoSelecionado);
    }

    public void atualizarCaminho() {
//        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
//        String cam = servletContext.getRealPath("");
        caminho = File.separator + "resources" + File.separator + "pacotes" + File.separator + especieSelecionada.getCodigo() + File.separator + "interactive_3d.html";
        System.out.println("Caminho: " + caminho);
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

    public List<Especie> getEspecies() {
        return especies;
    }

    public void setEspecies(List<Especie> especies) {
        this.especies = especies;
    }

    public EspecieDao getEspecieDao() {
        return especieDao;
    }

    public void setEspecieDao(EspecieDao especieDao) {
        this.especieDao = especieDao;
    }

    public Especie getEspecieSelecionada() {
        return especieSelecionada;
    }

    public void setEspecieSelecionada(Especie especieSelecionada) {
        this.especieSelecionada = especieSelecionada;
    }
    
    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

}
