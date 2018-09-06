package dao;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import usuarios.Administrador;
import util.JPAUtil;

public class AdministradorDao implements Serializable { 
    
    public Administrador autenticar(Administrador adm){
        Administrador temp = null; // administrador retornado na consulta ao banco
        EntityManager manager = JPAUtil.getEntityManager();
        TypedQuery<Administrador> query = manager.createQuery("SELECT a FROM Administrador a WHERE a.login = :login AND a.senha = :senha",
                Administrador.class); 
        query.setParameter("login", adm.getLogin());
        query.setParameter("senha", adm.getSenha());
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
        
    public Administrador buscarPorNome(String nome) {
        Administrador temp = null;
        EntityManager manager = JPAUtil.getEntityManager();
        String sql = "SELECT a FROM Administrador a WHERE a.nome = :n";
        TypedQuery<Administrador> query = manager.createQuery(sql, Administrador.class);
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
    
    public Administrador buscarPorNome(Administrador adm) {
        Administrador temp = null;
        EntityManager manager = JPAUtil.getEntityManager();
        String sql = "SELECT a FROM Administrador a WHERE a.nome = :n";
        TypedQuery<Administrador> query = manager.createQuery(sql, Administrador.class);
        query.setParameter("n", adm.getNome());
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