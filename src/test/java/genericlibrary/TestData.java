package genericlibrary;

import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author K Themeem
 * 
 *         Class implements to DataRepository for TestData
 *
 */
public class TestData extends CommonLibrary implements DataRepository {

	/**
	 * Method to get value from TestData property file of the the given key
	 * 
	 * @param key
	 *            : Key to search in the property file
	 * @return value of the given key
	 */
	public String getPropertyValue(String key) throws IOException {
		input = this.getClass().getClassLoader().getResourceAsStream("TestData.properties");
		Properties props = new Properties();
		props.load(input);
		return props.getProperty(key);
	}
}