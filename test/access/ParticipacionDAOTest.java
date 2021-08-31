/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.util.ArrayList;
import models.ParticipacionModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author delga
 */
public class ParticipacionDAOTest {
    
    public ParticipacionDAOTest() {
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
     * Test of findParticipacionByNamePiloto method, of class ParticipacionDAO.
     */
    @Test
    public void testFindParticipacionByNamePiloto() {
        System.out.println("findParticipacionByNamePiloto");
        String nombre = "";
        ParticipacionDAO instance = new ParticipacionDAO();
        ArrayList<ParticipacionModel> expResult = null;
        ArrayList<ParticipacionModel> result = instance.findParticipacionByNamePiloto(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findParticipacionByNameCarrera method, of class ParticipacionDAO.
     */
    @Test
    public void testFindParticipacionByNameCarrera() {
        System.out.println("findParticipacionByNameCarrera");
        String nombre = "";
        ParticipacionDAO instance = new ParticipacionDAO();
        ArrayList<ParticipacionModel> expResult = null;
        ArrayList<ParticipacionModel> result = instance.findParticipacionByNameCarrera(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class ParticipacionDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        ParticipacionDAO instance = new ParticipacionDAO();
        ArrayList<ParticipacionModel> expResult = null;
        ArrayList<ParticipacionModel> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createParticipacion method, of class ParticipacionDAO.
     */
    @Test
    public void testCreateParticipacion() {
        System.out.println("createParticipacion");
        ParticipacionModel participacion = null;
        ParticipacionDAO instance = new ParticipacionDAO();
        instance.createParticipacion(participacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteParticipacionById method, of class ParticipacionDAO.
     */
    @Test
    public void testDeleteParticipacionById() {
        System.out.println("deleteParticipacionById");
        int id = 0;
        ParticipacionDAO instance = new ParticipacionDAO();
        instance.deleteParticipacionById(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateParticipacionById method, of class ParticipacionDAO.
     */
    @Test
    public void testUpdateParticipacionById() {
        System.out.println("updateParticipacionById");
        ParticipacionModel participacion = null;
        ParticipacionDAO instance = new ParticipacionDAO();
        instance.updateParticipacionById(participacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
