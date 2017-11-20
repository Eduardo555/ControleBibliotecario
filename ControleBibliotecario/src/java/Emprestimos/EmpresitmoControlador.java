/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emprestimos;

import BibliotecarioServico.BibliotecarioServico;
import Clientes.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author eduardo
 */
public class EmpresitmoControlador {
    
    public static void salvar(Emprestimo emprestimo) {
        EntityManager em = BibliotecarioServico.getEM();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(emprestimo);
        t.commit();
    }
    
}
