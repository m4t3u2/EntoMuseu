
package dao;

import modelo.Usuario;
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
public class UsuarioDaoTest {
    
    public UsuarioDaoTest() {
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
    
    /*
    Teste de commit.
    Teste Ok.
    */
    @Test
    public void autenticar(){
        Usuario u = new Usuario();
        u.setSenha("123");
        u.setLogin("teste");
        u = new UsuarioDao().autenticar(u);
        assertNotNull(u);
    }

//    @Test
//    public void testInserir() {
//        Usuario u = new Usuario();
//        u.setNome("Teste");
//        u.setSenha("123");
//        u.setLogin("teste");
//        u.setEmail("teste@gmail.com");
//        new UsuarioDao().inserir(u);
//    }
    
}
