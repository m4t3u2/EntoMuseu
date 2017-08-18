/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Familia;
import modelo.Ordem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mateus
 */
public class FamiliaDaoTest {
    
    public FamiliaDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

//    @Test
//    public void testInserir() {
//        Familia fa = new Familia();
//        fa.setNome("Quarta Familia");
//        fa.setDescricao("Quarta familia cadastrada apra testar");
//        Ordem o = new Ordem();
//        o.setCodigo(1);
//        fa.setOrdem(o);
//        new FamiliaDao().inserir(fa);
//    }
    
    @Test
    public void testListar(){
        List<Ordem> lista = new OrdemDao().listarOrdem();
        for(Ordem o:lista)System.out.println(o.getNome());
    }
}
