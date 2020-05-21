package genericlibrary;

import java.io.IOException;

/**
 * 
 * @author K Themeem
 * 
 *         Interface to declare method for DriverInputData and TestData
 *
 */
public interface DataRepository {
	/**
	 * Method to get value from property file of the the given key
	 * 
	 * @param key
	 *            : Key to search in the property file
	 * @return value of the given key
	 */
	String getPropertyValue(String key) throws IOException;
}
