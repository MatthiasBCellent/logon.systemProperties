package de.cellent.test.sysProps;


import java.util.Properties;

import javax.ejb.Remote;

@Remote
public interface SystemPropertiesService {
	
	String getSystemPropertyByName(String name);
	Properties getSystemProperties();
}
