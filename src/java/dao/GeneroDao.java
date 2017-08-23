package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Familia;
import modelo.Genero;
import modelo.Ordem;
import util.JpaUtil;

public class GeneroDao implements Serializable{
        public Genero buscarPorNome(String nome){
        Genero temp;
        EntityManager manager = JpaUtil.getEntityManager();
        TypedQuery<Genero> query = manager.createNamedQuery("Genero.listarPorNome", Genero.class);
        query.setParameter("nome", nome);
        temp = query.getSingleResult();
        manager.close();
        return temp;
    }
    
    
    public boolean inserir(Genero gen){
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction(); 
        tx.begin();
        manager.persist(gen);
        tx.commit();
        manager.close();
        return true;
    } 
    
    public List<Genero> listarGenero(){
        EntityManager manager = JpaUtil.getEntityManager();
        TypedQuery<Genero> query = manager.createNamedQuery("Genero.listarTodos", Genero.class);
        List<Genero> lista = query.getResultList();
        manager.close();
        return lista;
    }
    
    public List<Genero> listarPorFamilia(Familia familia){
        EntityManager manager = JpaUtil.getEntityManager();
        TypedQuery<Genero> query = manager.createNamedQuery("Genero.buscarPorFamilia", Genero.class);
        query.setParameter("codigo", familia.getCodigo());
        List<Genero> lista = query.getResultList();
        manager.close();
        return lista;     
    }
}
