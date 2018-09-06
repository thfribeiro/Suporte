package dao;

import usuarios.Administrador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import usuarios.Usuario;

public class DaoTest {

    public DaoTest() {
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

//  @Test
//  public void testInserirUsuario() {
//  Dao dao = new Dao(Usuario.class);
//    Usuario usu = new Usuario("tthiago2","tatu1234","Thiago F Ribeiro","thfribeiro@hotmail.com");
//      dao.inserir(usu);
//    }
//  
//    @Test
//  public void testInserirAdministrador() {
//  Dao dao = new Dao(Administrador.class);
//    Administrador adm = new Administrador("tthiago2","tatu1234","Thiago F Ribeiro","thfribeiro@hotmail.com");
//      dao.inserir(adm);
//    }
    
//    @Test
//    public void testListarAdministrador() {
//        Dao<Administrador> dao = new Dao(Administrador.class);
//        List<Administrador> lista = dao.listarTodos();
//        for (Administrador adm : lista){
//            System.out.println(adm.getId() + " - "+adm.getLogin());
//        }
//        
//    }
//    @Test
//    public void testInserirUsuario() {
//        Dao<Usuario> dao = new Dao(Usuario.class);
//        Usuario u = new Usuario("João", "Centro Ciências Tecnológicas");
//        dao.inserir(u);
//    }
//    @Test
//    public void testInserirEmprestimo() {
//        Usuario u = new Usuario("Merlin", "CCT");
//        Veiculo v = new Veiculo("Fiat", "Uno", 4);
//        Emprestimo e = new Emprestimo(v, new Date(), new Date(), u);
//        Dao<Emprestimo> dao = new Dao(Emprestimo.class);
//        dao.inserir(e);
//    }

    @Test
    public void testAlterarUsuario() {
        Dao<Administrador> dao = new Dao(Administrador.class);
        Administrador adm = new Administrador();
        adm.setId(3);
        adm = dao.buscarPorCodigo(adm.getId());  // tem que buscar para recuperar a referência ao objeto
        System.out.println("Antes: ");
        System.out.println("Nome: " + adm.getNome() + "\n\n");

        // alterando o nome
        adm.setNome("Willian");
        adm.setSenha("123");
        // gravando
        dao.alterar(adm);
        adm = dao.buscarPorCodigo(adm.getId());  // tem que buscar para recuperar a referência ao objeto
    }

}