package dao;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import usuarios.Usuario;
import util.JPAUtil;

public class UsuarioDao implements Serializable { 
    
    public Usuario autenticar(Usuario usu){
        Usuario temp = null; // administrador retornado na consulta ao banco
        EntityManager manager = JPAUtil.getEntityManager();
        TypedQuery<Usuario> query = manager.createQuery("SELECT a FROM Usuario a WHERE a.login = :login AND a.senha = :senha",
                Usuario.class); 
        query.setParameter("login", usu.getLogin());
        query.setParameter("senha", usu.getSenha());
        try{
            temp = query.getSingleResult(); 
        }
        catch(Exception e){ 
            
        }     //aqui poderia haver um tratamento de exceção mais decente
        finally{
            manager.close();
        }        
        return temp;
    }
        
    public Usuario buscarPorNome(String nome) {
        Usuario temp = null;
        EntityManager manager = JPAUtil.getEntityManager();
        String sql = "SELECT a FROM Usuario a WHERE a.nome = :n";
        TypedQuery<Usuario> query = manager.createQuery(sql, Usuario.class);
        query.setParameter("n", nome);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  //aqui poderia haver um tratamento de exceção mais decente
//            System.out.println("Exception in AdministradorDao.buscarPorNome(): " + e.toString());
        } finally {
            manager.close();
        }
        return temp;
    }
    

}