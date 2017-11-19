/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BibliotecarioServico;

/**
 *
 * @author eduardo
 */
import javax.persistence.*;

public class BibliotecarioServico {
    
    public static EntityManagerFactory emf;
    
    public static EntityManager getEM() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory(
                    "BibliotecarioJPA");
        }
        
        return emf.createEntityManager();
    }
    
}
