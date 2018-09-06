package dao;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import usuarios.Suporte;
import util.JPAUtil;

public class SuporteDao implements Serializable { 
    
    private Class<Suporte> classe;    
    EntityManager manager;
    
    
    public Suporte buscarPorUsuario(String nome) {
        Suporte temp = null;
        EntityManager manager = JPAUtil.getEntityManager();
        String sql = "SELECT a FROM Suporte a WHERE a.usuario.nome = :n";
        TypedQuery<Suporte> query = manager.createQuery(sql, Suporte.class);
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