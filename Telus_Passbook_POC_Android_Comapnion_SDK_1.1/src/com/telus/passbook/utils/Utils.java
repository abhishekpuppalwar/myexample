package com.telus.passbook.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;

import android.util.Log;

import com.telus.passbook.constant.PassConstants;
import com.telus.passbook.network.ConnectionManager;

/**
 * This is the utility class of the application.
 * 
 * @author abhishek.puppalwar
 */
public class Utils {

	/**
	 * This method converts the InputStream data into the String
	 * 
	 * @param inputStream
	 *            InputStream data
	 * @return String data
	 * @throws IOException
	 */
	public static String convertToString(InputStream inputStream)
			throws IOException {

		if (inputStream != null) {
			final int PKG_SIZE = 1024;
			byte[] data = new byte[PKG_SIZE];
			StringBuffer buffer = new StringBuffer(PKG_SIZE * 10);
			int size;

			size = inputStream.read(data, 0, data.length);
			while (size > 0) {
				String str = new String(data, 0, size);
				buffer.append(str);
				size = inputStream.read(data, 0, data.length);
			}
			return buffer.toString();
		}
		return "null_input_Stream";
	}

	/**
	 * This method makes the post request to the ConnectionManager
	 * 
	 * @param postRequest
	 *            Request data or Body
	 * @return Server Response
	 */
	public static String postRequest(ArrayList<String> request, String classname,
			HashMap<String, String> headerMap,
			HashMap<String, String> parameterMap) {

		String url = PassConstants.SERVER_URL + "/services" + classname + "/android";
		System.out.println("Utils.postRequest() :: URL = "+url);
		try {
			InputStream inputStream = ConnectionManager.makePostRequest(
					request, url, headerMap, parameterMap);
			String response = Utils.convertToString(inputStream);
			Log.d("Test", "Post response :: " + response);

			return response;

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method makes the post request to the ConnectionManager
	 * 
	 * @param postRequest
	 *            Request data or Body
	 * @return Server Response
	 */
	public static String postRequest(byte[] postRequest, String classname,
			HashMap<String, String> headerMap,
			HashMap<String, String> parameterMap) {

		String url = PassConstants.SERVER_URL + "/services" + classname + "/android";
		try {
			InputStream inputStream = ConnectionManager.postRequest(postRequest, url, headerMap, parameterMap);
			String response = Utils.convertToString(inputStream);
			Log.d("Test", "Post response :: " + response);

			return response;

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method makes the get request to the ConnectionManager
	 * 
	 * @return Server Response
	 */
	public static String getRequest(String classname,
			HashMap<String, String> headerMap,
			HashMap<String, String> parameterMap) {

		String url = PassConstants.SERVER_URL + "/services" + classname + "/android";
		Log.d("SDK", "URL: "+url);
		try {

			InputStream inputStream = ConnectionManager.getRequest(url,
					headerMap, parameterMap);
			String response = Utils.convertToString(inputStream);
			Log.d("Test", "Get response :: " + response);
			return response;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
