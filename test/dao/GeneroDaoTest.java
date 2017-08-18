/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Familia;
import modelo.Genero;
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
public class GeneroDaoTest {
    
    public GeneroDaoTest() {
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

    @Test
    public void testSomeMethod() {

    }
    
    @Test
    public void testInserir() {
        Ordem or = new Ordem();
        or = new OrdemDao().buscar(1);
        Familia fa = new Familia();
        fa.setCodigo(4);
        fa.setOrdem(or);
        Genero ge = new Genero();
        ge.setNome("Primeiro Genero");
        ge.setDescricao("Primeiro Genero cadastrada para testar");
        ge.setFamilia(fa);
        new GeneroDao().inserir(ge);
    }
    
}
