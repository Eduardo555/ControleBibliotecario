/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

import BibliotecarioServico.BibliotecarioServico;
import LIvros.Livro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author eduardo
 */
public class ClienteControlador {
    
    public static void salvar(Cliente cliente) {
        EntityManager em = BibliotecarioServico.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(cliente);
        t.commit();
    }
    
    public static void excluir(Cliente cliente) {
        EntityManager em = BibliotecarioServico.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.remove(em.find(Cliente.class, cliente.getCod_cliente()));
        t.commit();
    }
    
    public static List<Cliente> getClientes(Integer cod_usuario) {
        EntityManager em = BibliotecarioServico.getEM();
        TypedQuery<Cliente> query = em.createQuery("select x from Cliente x where x.usuario.cod_usuario =:cod_usuario", Cliente.class);
        query.setParameter("cod_usuario", cod_usuario);
        return query.getResultList();
    }
    
}
