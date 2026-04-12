import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeFormTest {

    private EmployeeForm form;

    @BeforeEach
    void setUp() {
        form = new EmployeeForm();
        System.out.println("Test Environment Initialized: Form Created.");
    }

    @AfterEach
    void tearDown() {
        if (form != null) {
            form.dispose();
        }
        System.out.println("Test Environment Cleaned: Form Disposed.");
    }



    @Test
    void testValidationWithValidData() {
        boolean result = ValidationUtil.isValid("Hamze", "hamze@example.com", "securePass123", "2026-04-12");
        assertTrue(result);
    }

    @Test
    void testValidationWithMissingFields() {
        boolean result = ValidationUtil.isValid("", "hamze@example.com", "password", "2026-04-12");
        assertFalse(result);
    }


}