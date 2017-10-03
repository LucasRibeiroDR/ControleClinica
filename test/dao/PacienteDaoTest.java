/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Paciente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author a120088
 */
public class PacienteDaoTest {
    
    public PacienteDaoTest() {
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

    @Test
    
public void testInserir() {
        /*PacienteDao dao = new PacienteDao();
        dao.listarTodos();
        List<Paciente> lista = dao.listarTodos();
        for(Paciente p:lista){
            System.out.println(p.getNome());
        }*/
        Paciente paciente = new Paciente();
        paciente.setConvenio("Unimed");
        paciente.setCpf_Paciente("12345678911");
        paciente.setCpf_Responsavel("99999999999");
        paciente.setEmail_Paciente("lucas@gmail.com");
        paciente.setEmail_Responsavel("lulu@hot.com");
        paciente.setEndereco_Paciente("Rua da manguaça");
        paciente.setEndereco_Responsavel("Rua das pinga");
        paciente.setNome("MERLINZAO");
        paciente.setNome("Mario da Pinga");
        paciente.setNomeResponsavel("Mario da cachaça");
        paciente.setRg_Paciente("123456789");
        paciente.setRg_Responsavel("123456789");
        paciente.setSenhaDeAcesso("senha123");
        paciente.setTelefone_Paciente("12345678");
        paciente.setTelefone_Responsavel("12345678");
        PacienteDao dao = new PacienteDao();
        dao.inserir(paciente);
    
    }
}