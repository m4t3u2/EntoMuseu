package controle;

import dao.UsuarioDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Usuario;

@ManagedBean (name="usuarioControle")
@ViewScoped
public class UsuarioControle implements Serializable{
   
    private Usuario novoUsuario;
    private UsuarioDao usuarioDao;
    private List<Usuario> lista;
   
    public UsuarioControle(){
        novoUsuario = new Usuario();
        usuarioDao = new UsuarioDao();
        lista = usuarioDao.listarUsuarios();
    }
  
    public void incluirUsuario(){
       usuarioDao.inserir(novoUsuario);
       lista = usuarioDao.listarUsuarios();
       novoUsuario = new Usuario();
    }
    
    public void excluir(Usuario usuario){
        usuarioDao.excluir(usuario);
        lista.remove(usuario);
    }
    
    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
    
    public Usuario getNovoUsuario() {
        return novoUsuario;
    }

    public void setNovoUsuario(Usuario novoUsuario) {
        this.novoUsuario = novoUsuario;
    }
    
    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

}
