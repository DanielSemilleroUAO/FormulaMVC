/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
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
public class ConnectionDBTest {
    
    /**
     * Test of getConnection method, of class ConnectionDB.
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        Connection result = ConnectionDB.getConnection();
        assertNotNull(result);
    }
    
}
