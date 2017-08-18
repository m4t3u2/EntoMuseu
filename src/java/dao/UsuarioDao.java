package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Ordem;
import modelo.Usuario;
import util.JpaUtil;

public class UsuarioDao {
    
    public Usuario autenticar(Usuario usr){
        Usuario temp = null; //usuario retornado na consulta ao banco
        EntityManager manager = JpaUtil.getEntityManager();
        TypedQuery<Usuario> query = manager.createQuery("SELECT a FROM Usuario a WHERE a.login = :login AND a.senha = :senha",
                Usuario.class); 
        query.setParameter("login", usr.getLogin());
        query.setParameter("senha", usr.getSenha());
        try{
            temp = query.getSingleResult(); 
        }
        catch(Exception e){ }     //aqui poderia haver um tratamento de exceção mais decente
        finally{
            manager.close();
        }        
        return temp;
    }
    
    public boolean inserir(Usuario usr){
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction(); 
        tx.begin();
        manager.persist(usr);
        tx.commit();
        manager.close();
        return true;
    }
    
    public List<Usuario> listarUsuarios(){
        EntityManager manager = JpaUtil.getEntityManager();
        TypedQuery<Usuario> query = manager.createNamedQuery("Usuario.listarUsuarios", Usuario.class);
        List<Usuario> lista = query.getResultList();
        manager.close();
        return lista;
    }
    
    public void excluir(Usuario usuario){
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Usuario temp = manager.find(Usuario.class, usuario.getCodigo());
        manager.remove(temp);
        tx.commit();
        manager.close();
    }
}
