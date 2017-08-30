package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import modelo.Especie;
import modelo.Genero;
import util.JpaUtil;

public class EspecieDao implements Serializable{
     public Especie buscarPorNome(String nome){
        Especie temp;
        EntityManager manager = JpaUtil.getEntityManager();
        TypedQuery<Especie> query = manager.createNamedQuery("Especie.listarPorNome", Especie.class);
        query.setParameter("nome", nome);
        temp = query.getSingleResult();
        manager.close();
        return temp;
    }
    
    
    public Integer inserir(Especie esp){
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction(); 
        tx.begin();
        manager.persist(esp);
        tx.commit();
        Query query = manager.createNativeQuery("SELECT last_value FROM especie_codigo_seq");
        Long l = (Long) query.getSingleResult();
        Integer codigoInsInteger = l.intValue();
        manager.close();
        return codigoInsInteger;
    } 
    
    public List<Especie> listarEspecie(){
        EntityManager manager = JpaUtil.getEntityManager();
        TypedQuery<Especie> query = manager.createNamedQuery("Especie.listarTodos", Especie.class);
        List<Especie> lista = query.getResultList();
        manager.close();
        return lista;
    }
    
    public List<Especie> listarPorGenero(Genero genero){
        EntityManager manager = JpaUtil.getEntityManager();
        TypedQuery<Especie> query = manager.createNamedQuery("Especie.buscarPorGenero", Especie.class);
        query.setParameter("codigo", genero.getCodigo());
        List<Especie> lista = query.getResultList();
        manager.close();
        return lista;     
    }
}
