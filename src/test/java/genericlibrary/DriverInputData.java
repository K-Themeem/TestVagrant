package genericlibrary;

import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author K Themeem
 * 
 * Class implements to DataRepository for DriverInpuitData
 *
 */
public class DriverInputData extends CommonLibrary implements DataRepository {

	/**
	 * Method to get value from DriverInput property file of the the given key
	 * 
	 * @param key
	 *            : Key to search in the property file
	 * @return value of the given key
	 */
	public String getPropertyValue(String key) throws IOException {
		input = this.getClass().getClassLoader().getResourceAsStream("DriverInput.properties");
		Properties props = new Properties();
		props.load(input);
		return props.getProperty(key);
	}

}
