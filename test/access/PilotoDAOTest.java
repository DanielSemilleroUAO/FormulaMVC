/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.util.ArrayList;
import models.PilotoModel;
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
public class PilotoDAOTest {
    
    public PilotoDAOTest() {
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
     * Test of findPilotoByCodigo method, of class PilotoDAO.
     */
    @Test
    public void testFindPilotoByCodigo() {
        System.out.println("findPilotoByCodigo");
        int id = 0;
        PilotoDAO instance = new PilotoDAO();
        ArrayList<PilotoModel> expResult = null;
        ArrayList<PilotoModel> result = instance.findPilotoByCodigo(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPilotoByName method, of class PilotoDAO.
     */
    @Test
    public void testFindPilotoByName() {
        System.out.println("findPilotoByName");
        String name = "";
        PilotoDAO instance = new PilotoDAO();
        ArrayList<PilotoModel> expResult = null;
        ArrayList<PilotoModel> result = instance.findPilotoByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class PilotoDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        PilotoDAO instance = new PilotoDAO();
        ArrayList<PilotoModel> expResult = null;
        ArrayList<PilotoModel> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPiloto method, of class PilotoDAO.
     */
    @Test
    public void testCreatePiloto() {
        System.out.println("createPiloto");
        PilotoModel piloto = null;
        PilotoDAO instance = new PilotoDAO();
        instance.createPiloto(piloto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePilotoByCodigo method, of class PilotoDAO.
     */
    @Test
    public void testDeletePilotoByCodigo() {
        System.out.println("deletePilotoByCodigo");
        int id = 0;
        PilotoDAO instance = new PilotoDAO();
        instance.deletePilotoByCodigo(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePilotoById method, of class PilotoDAO.
     */
    @Test
    public void testUpdatePilotoById() {
        System.out.println("updatePilotoById");
        PilotoModel piloto = null;
        PilotoDAO instance = new PilotoDAO();
        instance.updatePilotoById(piloto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
