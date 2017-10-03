/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Agendamento;
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
public class AgendamentoDaoTest {
    
    public AgendamentoDaoTest() {
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
     * Test of inserir method, of class AgendamentoDao.
     */
    @Test
    public void testInserir() {
        Agendamento agendamento = new Agendamento();
        agendamento.setCodigoPaciente(5);
        agendamento.setHorario("18h00");
        agendamento.setNome("Fernando");
        agendamento.setProcedimento("Consulta Oftalmo");
        agendamento.setData("21/08/2017");
        AgendamentoDao dao = new AgendamentoDao();
        dao.inserir(agendamento);
    }   
}