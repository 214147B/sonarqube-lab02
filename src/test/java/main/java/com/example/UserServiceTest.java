package main.java.com.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class UserServiceTest {

    @Test
    void testFindUserWithoutDbPassword() {
        // Clear the environment variable to simulate missing password
        UserService service = new UserService();
        
        // When DB_PASSWORD is not set, should throw SQLException
        assertThrows(SQLException.class, () -> service.findUser("testuser"));
    }

    @Test
    void testNotUsedMethod() {
        UserService service = new UserService();
        
        // notUsed() should execute without throwing any exception
        assertDoesNotThrow(() -> service.notUsed());
    }
}
