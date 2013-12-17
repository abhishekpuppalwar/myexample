package com.telus.passbook.config;

import com.telus.passbook.constant.PassConstants;

/**
 * This class initializes the server configuration which will be required to
 * make the server call.
 * 
 * @author abhishek.puppalwar
 */
public class Config {

	/**
	 * Initializes the Config class with default values
	 */
	public Config() {

	}

	/**
	 * Initialize the Config class
	 * 
	 * @param serverUrl
	 *            server Url
	 * @param applicationId
	 *            Id of the server application
	 * @param restApiKey
	 *            Api Key to make rest call on server
	 */
	public Config(String serverUrl, String applicationId, String restApiKey) {

		PassConstants.SERVER_URL = serverUrl;
		PassConstants.APPLICATION_ID = applicationId;
		PassConstants.REST_API_KEY = restApiKey;
	}

	/**
	 * This method gives server url which is configured earlier.
	 * 
	 * @return server url
	 */
	public String getServerUrl() {

		return PassConstants.SERVER_URL;
	}

	/**
	 * This method gives the application id which is configured earlier.
	 * 
	 * @return application id
	 */
	public String getApplicationId() {

		return PassConstants.APPLICATION_ID;
	}

	/**
	 * This method gives the api key for rest call which is configured earlier.
	 * 
	 * @return api key for rest call
	 */
	public String getRestApiKey() {

		return PassConstants.REST_API_KEY;
	}
}
