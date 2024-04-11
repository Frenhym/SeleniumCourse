package pl.coderslab;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FirstTest {

    @BeforeClass
    public static void setUpClass() {
        System.out.println("BEFORE CLASS setUpClass()");
    }

    @AfterClass
    public static void tearUpClass() {
        System.out.println("AFTER CLASS tearUpClass()");
    }


    @Before
    public void setUp() {
        System.out.println("BEFORE setUp");
    }

    @After
    public void tearDown() {
        System.out.println("AFTER tearDown()");
    }

    @Test
    public void getText(){
        String name = "Jacek";
        String secondName = "Agatka";
        assertNotEquals(name, secondName);
        System.out.println("Test 1 getText1()");
    }

    @Test
    public void getText2() {
        String name = "Jacek";
        String secondName = "Agatka";

        assert !equals(secondName);
        System.out.println("Test 2 getText2()");
    }

    @Test
    public void getText3() {

    }
}