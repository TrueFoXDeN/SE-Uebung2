import org.hbrs.se.ws2020.uebung2.Container;
import org.hbrs.se.ws2020.uebung2.ContainerException;
import org.hbrs.se.ws2020.uebung2.MemberObject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
    MemberObject m1, m2, m3;
    Container c;

    @BeforeEach
    void setUp() {
        m1 = new MemberObject(1);
        m2 = new MemberObject(2);
        m3 = new MemberObject(3);
        c = new Container();
    }

    @AfterEach
    void tearDown() {
        m1 = null;
        m2 = null;
        m3 = null;
    }

    @Test
    void addMember() throws ContainerException {
        assertEquals(0, c.size());
        c.addMember(m1);
        assertEquals(1, c.size());
        c.addMember(m2);
        assertEquals(2, c.size());
        c.addMember(m3);
        assertEquals(3, c.size());
        ContainerException e = assertThrows(ContainerException.class, () ->{
            c.addMember(m3);
        });
        assertTrue(e.getMessage().contains("Das Member-Objekt mit der ID [3] ist bereits vorhanden!"));
        assertEquals(3, c.size());
    }

    @Test
    void deleteMember() throws ContainerException {
        c.addMember(m1);
        c.addMember(m2);
        c.addMember(m3);

        assertEquals("Member (ID = [1]) deleted", c.deleteMember(1));
        assertEquals(2, c.size());
        assertEquals("Member (ID = [1]) not found", c.deleteMember(1));
        assertEquals(2, c.size());
        assertEquals("Member (ID = [2]) deleted", c.deleteMember(2));
        assertEquals(1, c.size());
        assertEquals("Member (ID = [3]) deleted", c.deleteMember(3));
        assertEquals(0, c.size());

    }

    @Test
    void dump() throws ContainerException {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        c.addMember(m1);
        c.dump();
        assertEquals("Member (ID = [1])", outContent.toString().trim());
        outContent.reset();

        c.addMember(m2);
        c.dump();
        assertEquals("Member (ID = [1])\nMember (ID = [2])", outContent.toString().trim().replace("\r", ""));
        outContent.reset();

        c.deleteMember(1);
        c.dump();
        assertEquals("Member (ID = [2])", outContent.toString().trim());
        outContent.reset();

        System.setOut(originalOut);
    }


}