/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import static org.junit.Assert.assertTrue;

import org.apache.tomcat.jni.Library;
import org.junit.Test;

public class LibraryTest {
    @Test public void testSomeLibraryMethod() throws Exception {

        assertTrue("someLibraryMethod should return 'true'", Library.initialize(null));
    }
}
