/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author a120074
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

    /**
     * Test of inserir method, of class UsuarioDao.
     */
    @Test
    public void testInserir() {
        Usuario usuario = new Usuario();
        usuario.setCpf_Usuario("78945612325");
        usuario.setNome("Jeanzera");
        usuario.setSenhaDeAcesso("eusougod");
        UsuarioDao dao = new UsuarioDao();
        dao.inserir(usuario);
    }

    /**
     * Test of alterar method, of class UsuarioDao.
     */
   

    /**
     * Test of buscarPorCodigo method, of class UsuarioDao.
     */
   
    /**
     * Test of excluir method, of class UsuarioDao.
     */
}