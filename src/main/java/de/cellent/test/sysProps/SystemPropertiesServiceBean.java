package de.cellent.test.sysProps;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(SystemPropertiesService.class)
@Stateless
public class SystemPropertiesServiceBean implements SystemPropertiesService {

	private Properties props;

	@Override
	public String getSystemPropertyByName(String key) {
		return props.getProperty(key);
	}

	@Override
	public Properties getSystemProperties() {
		return props;
	}
	
	@PostConstruct
	private void init() {
		this.props = System.getProperties();
	}

}
