package framework.core.runner;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.addListener(new TestListenerAdapter());
        final XmlSuite suite = new XmlSuite();
        suite.setName("Main suite");
        suite.setSuiteFiles(
                new ArrayList<String>() {{
                    add("./src/main/resources/suites/suite.xml");
                }}
        );

        testNG.setXmlSuites(new ArrayList<XmlSuite>() {{
            add(suite);
        }});

        testNG.run();
    }
}
