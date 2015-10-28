package de.cellent.test.sysProps;

import java.util.Enumeration;
import java.util.Properties;

import javax.naming.InitialContext;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class SystemPropertiesServiceTest {
	
	private static SystemPropertiesService service;

	public static void main(String[] args) {
		SystemPropertiesServiceTest.setUp();
		
		SystemPropertiesServiceTest test = new SystemPropertiesServiceTest();
//		test.testGetAllProperties();
		test.testGetProperty();
		
	}
	
	@BeforeClass
	public static void setUp() {
		try {
			InitialContext ctx = new InitialContext();
			service = (SystemPropertiesService) ctx.lookup("ejb:/systemProperties-0.0.1-SNAPSHOT/SystemPropertiesServiceBean!de.cellent.test.sysProps.SystemPropertiesService");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllProperties() {
		Properties props = service.getSystemProperties();
		Enumeration<Object> elements = props.elements();
		while(elements.hasMoreElements()) {
			System.out.println(elements.nextElement());
		}
		Assert.assertNotNull(props);
	}
	
	@Test
	public void testGetProperty() {
		// needs to be defined in standalobe.xml beforehand:
		//     	<system-properties>  
        //			<property name="HOST" value="www.acme.org"/>  
		//		</system-properties>  
		String hit = service.getSystemPropertyByName("HOST");
		Assert.assertEquals("www.acme.org", hit);
		System.out.println(hit);
	}
	

}
