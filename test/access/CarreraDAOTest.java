/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.util.ArrayList;
import models.CarreraModel;
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
public class CarreraDAOTest {
    
    CarreraDAO carreraDAO;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        carreraDAO = new CarreraDAO();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findCarreraByID method, of class CarreraDAO.
     */
    @Test
    public void testFindCarreraByID() {
        System.out.println("findCarreraByID");
        ArrayList<CarreraModel> result = carreraDAO.findCarreraByID(1);
        assertEquals(1, result.size());
        assertTrue(result.size() > 0);
    }

    /**
     * Test of findCarreraByName method, of class CarreraDAO.
     */
    @Test
    public void testFindCarreraByName() {
        System.out.println("findCarreraByName");
        ArrayList<CarreraModel> result = carreraDAO.findCarreraByName("Zipotacan");
        assertEquals(1, result.size());
        assertEquals("Zipotacan", result.get(0).getNombre());
        assertTrue(result.size() > 0);
    }

    /**
     * Test of findAll method, of class CarreraDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        ArrayList<CarreraModel> result = carreraDAO.findAll();
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    /**
     * Test of createCarrera method, of class CarreraDAO.
     */
    @Test
    public void testCreateCarrera() {
        System.out.println("createCarrera");
        ArrayList<CarreraModel> resultInitial = carreraDAO.findAll();
        carreraDAO.createCarrera(new CarreraModel("Daniel", 1321, 5.0, true));
        ArrayList<CarreraModel> result = carreraDAO.findAll();
        assertEquals(resultInitial.size() + 1, result.size());
    }

    /**
     * Test of updateCarreraById method, of class CarreraDAO.
     */
    @Test
    public void testUpdateCarreraById() {
        System.out.println("updateCarreraById");
        ArrayList<CarreraModel> resultInitial = carreraDAO.findCarreraByName("Daniel");
        resultInitial.get(0).setCapacidad(1000);
        resultInitial.get(0).setIsTecho(false);
        carreraDAO.updateCarreraById(resultInitial.get(0));
        ArrayList<CarreraModel> result = carreraDAO.findCarreraByName("Daniel");
        assertEquals(1000, result.get(0).getCapacidad());
        assertEquals(false, result.get(0).isIsTecho());
        
    }
    
    /**
     * Test of deleteCarreraById method, of class CarreraDAO.
     */
    @Test
    public void testDeleteCarreraById() {
        System.out.println("deleteCarreraById");
        ArrayList<CarreraModel> resultInitial = carreraDAO.findAll();
        carreraDAO.deleteCarreraById(carreraDAO.findCarreraByName("Daniel").get(0).getIdCarrera());
        ArrayList<CarreraModel> result = carreraDAO.findAll();
        assertEquals(resultInitial.size() - 1, result.size());
        
    }
    
}
