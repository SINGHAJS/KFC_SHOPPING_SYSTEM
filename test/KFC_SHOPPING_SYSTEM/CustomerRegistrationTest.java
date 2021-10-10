package KFC_SHOPPING_SYSTEM;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ajit Singh ID: 19070642
 */
public class CustomerRegistrationTest {

    public CustomerRegistrationTest() {
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
     * Test of validate method, of class CustomerRegistration for a true
     * condition
     */
    @Test
    public void test_ValidateFunction_True() {
        System.out.println("[TEST: VALIDATE FUNCTION - TRUE]");
        String REGEX = "^[a-zA-Z0-9]{3,}$";
        String str = "Ajit";
        boolean expResult = true;
        boolean result = CustomerRegistration.validate(REGEX, str);
        assertEquals(expResult, result);

    }

    /**
     * Test of validate method, of class CustomerRegistration for a false
     * condition
     */
    @Test
    public void test_ValidateFunction_False() {
        System.out.println("[TEST: VALIDATE FUNCTION - FALSE]");
        String REGEX = "^[a-zA-Z0-9]{3,}$";
        String str = "_Aj!1$!@@#";
        boolean expResult = false;
        boolean result = CustomerRegistration.validate(REGEX, str);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateUserName method, of class CustomerRegistration for a
     * valid user name.
     */
    @Test
    public void test_Valid_User_Name() {
        System.out.println("[TEST: VALIDATE USER NAME - VALID]");
        String userName = "Ajit111021";
        boolean expResult = true;
        boolean result = CustomerRegistration.validateUserName(userName);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateUserName method, of class CustomerRegistration for a
     * valid user name.
     */
    @Test
    public void test_Invalid_User_Name() {
        System.out.println("[TEST: VALIDATE USER NAME - INVALID]");
        String userName = "1-_Aj!$-_1";
        boolean expResult = false;
        boolean result = CustomerRegistration.validateUserName(userName);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateUserPassword method, of class CustomerRegistration when
     * the password meets the requirements of having 7 characters minimum, one
     * uppercase character, one lowercase character and a number.
     *
     * Note: The password also matches with the confirm password
     */
    @Test
    public void test_Valid_User_Password() {
        System.out.println("[TEST: VALIDATE USER PASSWORD - VALID]");
        String userPassword = "Password123";
        String userConfirmPassword = "Password123";
        boolean expResult = true;
        boolean result = CustomerRegistration.validateUserPassword(userPassword, userConfirmPassword);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateUserPassword method, of class CustomerRegistration when
     * the password meets the requirements of having 7 characters minimum, one
     * uppercase character, one lowercase character and a number. This also
     * tests the use of special characters in the password.
     *
     * Note: The password also matches with the confirm password
     */
    @Test
    public void test_Valid_User_Password_ContainsSpecialChars() {
        System.out.println("[TEST: VALIDATE USER PASSWORD - VALID (PASSWORD CONTAINS SPECIAL CHARACTERS)]");
        String userPassword = "P@$$w*rd123";
        String userConfirmPassword = "P@$$w*rd123";
        boolean expResult = true;
        boolean result = CustomerRegistration.validateUserPassword(userPassword, userConfirmPassword);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateUserPassword method, of class CustomerRegistration when
     * the password length is less than 7 characters.
     *
     * Note: The password also matches with the confirm password
     */
    @Test
    public void test_Invalid_User_Password_Length() {
        System.out.println("[TEST: VALIDATE USER PASSWORD - INVALID (LENGTH OF PASSWORD < 7)]");
        String userPassword = "Pass12";
        String userConfirmPassword = "Pass12";
        boolean expResult = false;
        boolean result = CustomerRegistration.validateUserPassword(userPassword, userConfirmPassword);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateUserPassword method, of class CustomerRegistration when
     * the password does not contain a number in the password.
     *
     * Note: The password also matches with the confirm password
     */
    @Test
    public void test_Invalid_User_Password_NumExcluded() {
        System.out.println("[TEST: VALIDATE USER PASSWORD - INVALID (NO NUMBER INCLUDED IN THE PASSWORD)]");
        String userPassword = "Password";
        String userConfirmPassword = "Password";
        boolean expResult = false;
        boolean result = CustomerRegistration.validateUserPassword(userPassword, userConfirmPassword);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateUserPassword method, of class CustomerRegistration when
     * the password does not contain a uppercase character.
     *
     * Note: The password also matches with the confirm password
     */
    @Test
    public void test_Invalid_User_Password_UpCaseExcluded() {
        System.out.println("[TEST: VALIDATE USER PASSWORD - INVALID (NO UPPERCASE CHARACTER INCLUDED IN THE PASSWORD)]");
        String userPassword = "password123";
        String userConfirmPassword = "password123";
        boolean expResult = false;
        boolean result = CustomerRegistration.validateUserPassword(userPassword, userConfirmPassword);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateUserPassword method, of class CustomerRegistration when
     * the password contains spaces or tab spaces in the password.
     *
     * Note: The password also matches with the confirm password
     */
    @Test
    public void test_Invalid_User_Password_SpaceOrTabIncluded() {
        System.out.println("[TEST: VALIDATE USER PASSWORD - INVALID (UPPERCASE AND TAB INCLUDED IN THE PASSWORD)]");
        String userPassword = "Pass 1234    5";
        String userConfirmPassword = "Pass 12345    ";
        boolean expResult = false;
        boolean result = CustomerRegistration.validateUserPassword(userPassword, userConfirmPassword);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateUserPassword method, of class CustomerRegistration when
     * the password does not match with the confirm password.
     *
     * Note: The password does not match with the confirm password
     */
    @Test
    public void test_Invalid_User_Password_PassNotMatch() {
        System.out.println("[TEST: VALIDATE USER PASSWORD - INVALID (PASSWORD AND CONFIRM PASSWORD DOES NOT MATCH)]");
        String userPassword = "PassPDC111021121450AM";
        String userConfirmPassword = "PDCPass111021121450AM";//PDC and Pass has been switched around
        boolean expResult = false;
        boolean result = CustomerRegistration.validateUserPassword(userPassword, userConfirmPassword);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateUserEmail method, of class CustomerRegistration when the
     * user inputs a correct format of email address using the @ and . in the
     * email address.
     */
    @Test
    public void test_Valid_UserEmail() {
        System.out.println("[TEST: VALIDATE USER EMAIL ADDRESS: VALID (THE EMAIL FORMAT IS VALID)]");
        String userEmail = "example@example.com";
        boolean expResult = true;
        boolean result = CustomerRegistration.validateUserEmail(userEmail);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateUserEmail method, of class CustomerRegistration when the
     * user inputs a incorrect format of email address not using the @ or . in
     * the email address.
     */
    @Test
    public void test_Invalid_UserEmail() {
        System.out.println("[TEST: VALIDATE USER EMAIL ADDRESS: INVALID (THE EMAIL FORMAT IS INVALID)]");
        String user_Email_Without_AT_Symbol = "exampleexample.com";
        String userEmail_Without_Dot = "example@examplecom";
        boolean expResult = false;
        boolean result1 = CustomerRegistration.validateUserEmail(user_Email_Without_AT_Symbol);
        boolean result2 = CustomerRegistration.validateUserEmail(userEmail_Without_Dot);
        assertEquals(expResult, result1);
        assertEquals(expResult, result2);
    }

    /**
     * Test of validateUserAddress method, of class CustomerRegistration when
     * the given address includes valid characters and sensible special
     * characters such as , or /.
     */
    @Test
    public void test_Valid_User_Address() {
        System.out.println("[TEST: VALIDATE USER ADDRESS - VALID]");
        String userAddress1 = "1 Address Auckland New Zealand";
        String userAddress2 = "Address Auckland New Zealand 111021";
        String userAddress3 = "20/50 1-2 Address, Auckland, New Zealand";
        boolean expResult = true;
        boolean result1 = CustomerRegistration.validateUserAddress(userAddress1);
        boolean result2 = CustomerRegistration.validateUserAddress(userAddress2);
        boolean result3 = CustomerRegistration.validateUserAddress(userAddress3);
        assertEquals(expResult, result1);
        assertEquals(expResult, result2);
        assertEquals(expResult, result3);
    }

    /**
     * Test of validateUserAddress method, of class CustomerRegistration when
     * the given address includes invalid characters such as !@#$%&*(+=
     */
    @Test
    public void test_Invalid_User_Address() {
        System.out.println("[TEST: VALIDATE USER ADDRESS - VALID]");
        String userAddress1 = "!@# Address Aucklan_+d New() Zealand!@";
        boolean expResult = false;
        boolean result = CustomerRegistration.validateUserAddress(userAddress1);
        assertEquals(expResult, result);

    }

}
