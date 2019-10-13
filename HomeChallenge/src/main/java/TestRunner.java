import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static  void main(String [] args) {
        TestNG runner = new TestNG();
        List<String> suitefiles = new ArrayList<String>();
        suitefiles.add(System.getProperty("user.dir")+ "/src/main/java/uat/testng.xml");
        runner.setTestSuites(suitefiles);
        runner.run();
    }
}
