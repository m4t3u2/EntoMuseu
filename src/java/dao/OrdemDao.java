package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Ordem;
import util.JpaUtil;


public class OrdemDao implements Serializable{
    
    public boolean inserir(Ordem ord){
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction(); 
        tx.begin();
        manager.persist(ord);
        tx.commit();
        manager.close();
        return true;
    }
    
    public List<Ordem> listarOrdem(){
        EntityManager manager = JpaUtil.getEntityManager();
        TypedQuery<Ordem> query = manager.createNamedQuery("Ordem.listarTodos", Ordem.class);
        List<Ordem> lista = query.getResultList();
        manager.close();
        return lista;
    }
    
    public Ordem buscarPorNome(String nome){
        Ordem temp;
        EntityManager manager = JpaUtil.getEntityManager();
        TypedQuery<Ordem> query = manager.createNamedQuery("Ordem.listarPorNome", Ordem.class);
        query.setParameter("nome", nome);
        temp = query.getSingleResult();
        manager.close();
        return temp;
    }
    
    public Ordem buscar(Object id){
        Ordem temp;
        EntityManager manager = JpaUtil.getEntityManager();
        temp = manager.find(Ordem.class, id);
        manager.close();
        return temp;
    }
}
