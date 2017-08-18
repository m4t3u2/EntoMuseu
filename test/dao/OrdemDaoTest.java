
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
public class OrdemDaoTest {
    
    public OrdemDaoTest() {
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
//        Ordem or = new Ordem();
//        or.setNome("Primeira Ordem");
//        or.setDescricao("Primeira ordem cadastrada para testar");
//        new OrdemDao().inserir(or);
//    }
//    
//    @Test
//    public void testListar(){
//        List<Ordem> lista = new OrdemDao().listarOrdem();
//        for(Ordem o:lista){
//            System.out.println(o.getNome());
//            for(Familia f:o.getFamilias())
//                System.out.println(f.getNome());
//        }
//    }
    
    @Test
    public void testeBuscarPorNome(){
        Ordem ord = new OrdemDao().buscarPorNome("Primeira Ordem");
        assertNotNull(ord);
    }
}
