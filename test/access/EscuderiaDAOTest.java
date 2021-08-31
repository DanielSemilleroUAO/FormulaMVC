/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.util.ArrayList;
import models.EscuderiaModel;
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
public class EscuderiaDAOTest {
    
    public EscuderiaDAOTest() {
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
     * Test of findEscuderiaByCodigo method, of class EscuderiaDAO.
     */
    @Test
    public void testFindEscuderiaByCodigo() {
        System.out.println("findEscuderiaByCodigo");
        int id = 0;
        EscuderiaDAO instance = new EscuderiaDAO();
        ArrayList<EscuderiaModel> expResult = null;
        ArrayList<EscuderiaModel> result = instance.findEscuderiaByCodigo(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findEscuderiaByName method, of class EscuderiaDAO.
     */
    @Test
    public void testFindEscuderiaByName() {
        System.out.println("findEscuderiaByName");
        String name = "";
        EscuderiaDAO instance = new EscuderiaDAO();
        ArrayList<EscuderiaModel> expResult = null;
        ArrayList<EscuderiaModel> result = instance.findEscuderiaByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findEscuderiaByPatrocinador method, of class EscuderiaDAO.
     */
    @Test
    public void testFindEscuderiaByPatrocinador() {
        System.out.println("findEscuderiaByPatrocinador");
        String name = "";
        EscuderiaDAO instance = new EscuderiaDAO();
        ArrayList<EscuderiaModel> expResult = null;
        ArrayList<EscuderiaModel> result = instance.findEscuderiaByPatrocinador(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class EscuderiaDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        EscuderiaDAO instance = new EscuderiaDAO();
        ArrayList<EscuderiaModel> expResult = null;
        ArrayList<EscuderiaModel> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createEscuderia method, of class EscuderiaDAO.
     */
    @Test
    public void testCreateEscuderia() {
        System.out.println("createEscuderia");
        EscuderiaModel escuderia = null;
        EscuderiaDAO instance = new EscuderiaDAO();
        instance.createEscuderia(escuderia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteEscuderiaByCodigo method, of class EscuderiaDAO.
     */
    @Test
    public void testDeleteEscuderiaByCodigo() {
        System.out.println("deleteEscuderiaByCodigo");
        int id = 0;
        EscuderiaDAO instance = new EscuderiaDAO();
        instance.deleteEscuderiaByCodigo(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateEscuderiaById method, of class EscuderiaDAO.
     */
    @Test
    public void testUpdateEscuderiaById() {
        System.out.println("updateEscuderiaById");
        EscuderiaModel escuderia = null;
        EscuderiaDAO instance = new EscuderiaDAO();
        instance.updateEscuderiaById(escuderia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
