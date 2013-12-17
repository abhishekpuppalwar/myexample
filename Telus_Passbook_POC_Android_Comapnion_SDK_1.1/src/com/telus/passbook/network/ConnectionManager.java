package com.telus.passbook.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

import android.util.Log;

import com.telus.passbook.constant.PassConstants;

/**
 * This class is responsible for all the communication over the network.
 */
public class ConnectionManager {

	private static final String KEY_APPLICATION_ID = "X-Parse-Application-Id";
	private static final String KEY_REST_API_ID = "X-Parse-REST-API-Key";
	private static final String KEY_CONTENT_TYPE = "Content-Type";
	private static final String CONTENT_TYPE_JSON = "application/json";
	private static final String CONTENT_TYPE_IMAGE = "image/png";

	/**
	 * This method make's the post request to the server
	 * 
	 * @param request
	 *            Body of the request
	 * @param url
	 *            Server Url
	 * @return InputStream if successful, otherwise null
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws SocketException
	 */
	public static InputStream postRequest(String request, String url,
			HashMap<String, String> headerMap,
			HashMap<String, String> parameterMap)
			throws ClientProtocolException, IOException, SocketException {

		HttpPost httpPostRequest = null;
		InputStream instream = null;
		HttpResponse response = null;
		HttpParams httpParameters = new BasicHttpParams();
		
		if (parameterMap != null && parameterMap.size() > 0) {
			Iterator<String> paramIterator = parameterMap.keySet().iterator();
			while (paramIterator.hasNext()) {
				String paramKey = paramIterator.next();
				httpParameters.setParameter(paramKey,parameterMap.get(paramKey));
			}
		}
		
		HttpClient httpclient = new DefaultHttpClient(httpParameters);
		if (null != url) {
			httpPostRequest = new HttpPost(url);
		} else {

			return null;

		}
		httpPostRequest.setHeader(KEY_APPLICATION_ID,
				PassConstants.APPLICATION_ID);
		httpPostRequest.setHeader(KEY_REST_API_ID, PassConstants.REST_API_KEY);
		httpPostRequest.setHeader(KEY_CONTENT_TYPE, CONTENT_TYPE_JSON);
		
		if (headerMap != null && headerMap.size() > 0) {
			Iterator<String> headerIterator = headerMap.keySet().iterator();
			while (headerIterator.hasNext()) {
				String headerKey = headerIterator.next();
				httpPostRequest.setHeader(headerKey, headerMap.get(headerKey));
			}
		}

		httpPostRequest.setEntity(new StringEntity(request));

		try {
			response = (HttpResponse) httpclient.execute(httpPostRequest);
		} catch (ClientProtocolException ex) {
			ex.printStackTrace();
			throw new ClientProtocolException();

		} catch (SocketException ex) {
			ex.printStackTrace();
			throw new SocketException();

		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			instream = entity.getContent();
			Header[] header = response.getAllHeaders();
			for (Header h : header) {
				Log.d("Test", "header name :: " + h.getName());
				Log.d("Test", "header value :: " + h.getValue());
				if (h.getName()
						.equalsIgnoreCase(PassConstants.RESPONSE_STATUS)
						&& h.getValue().startsWith(
								PassConstants.RESPONSE_STATUS_SUCCESS)) {

					return instream;
				}

			}
		}
		return null;
	}

	/**
	 * This method make's the post request to the server. Mainly used to send
	 * the image to server.
	 * 
	 * @param request
	 *            Body of the request in byte format
	 * @param url
	 *            Server Url
	 * @return InputStream if successful, otherwise null
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws SocketException
	 */
	public static InputStream postRequest(byte[] request, String url,
			HashMap<String, String> headerMap,
			HashMap<String, String> parameterMap)
			throws ClientProtocolException, IOException, SocketException {

		HttpPost httpPostRequest = null;
		InputStream instream = null;
		HttpResponse response = null;
		HttpParams httpParameters = new BasicHttpParams();
		if (parameterMap != null && parameterMap.size() > 0) {
			Iterator<String> paramIterator = parameterMap.keySet().iterator();
			while (paramIterator.hasNext()) {
				String paramKey = paramIterator.next();
				httpParameters.setParameter(paramKey,
						parameterMap.get(paramKey));
			}
		}
		
		HttpClient httpclient = new DefaultHttpClient(httpParameters);
		if (null != url) {
			httpPostRequest = new HttpPost(url);
		} else {

			return null;

		}
		httpPostRequest.setHeader(KEY_APPLICATION_ID,
				PassConstants.APPLICATION_ID);
		httpPostRequest.setHeader(KEY_REST_API_ID, PassConstants.REST_API_KEY);
		httpPostRequest.setHeader(KEY_CONTENT_TYPE, CONTENT_TYPE_IMAGE);
		
		if (headerMap != null && headerMap.size() > 0) {
			Iterator<String> headerIterator = headerMap.keySet().iterator();
			while (headerIterator.hasNext()) {
				String headerKey = headerIterator.next();
				httpPostRequest.setHeader(headerKey, headerMap.get(headerKey));
			}
		}

		httpPostRequest.setEntity(new ByteArrayEntity(request));

		try {
			response = (HttpResponse) httpclient.execute(httpPostRequest);
		} catch (ClientProtocolException ex) {
			ex.printStackTrace();
			throw new ClientProtocolException();

		} catch (SocketException ex) {
			ex.printStackTrace();
			throw new SocketException();

		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			instream = entity.getContent();
			Header[] header = response.getAllHeaders();
			for (Header h : header) {
				Log.d("Test", "header name :: " + h.getName());
				Log.d("Test", "header value :: " + h.getValue());
				if (h.getName()
						.equalsIgnoreCase(PassConstants.RESPONSE_STATUS)
						&& h.getValue().startsWith(
								PassConstants.RESPONSE_STATUS_SUCCESS)) {

					return instream;
				}

			}
		}
		return null;
	}
	
	/**
	 * This method make's the post request to the server. Mainly used to send
	 * the image to server.
	 * 
	 * @param request
	 *            Body of the request in byte format
	 * @param url
	 *            Server Url
	 * @return InputStream if successful, otherwise null
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws SocketException
	 */
	public static InputStream makePostRequest(ArrayList<String> request, String url,
			HashMap<String, String> headerMap,
			HashMap<String, String> parameterMap)
			throws ClientProtocolException, IOException, SocketException {

		HttpPost httpPostRequest = null;
		InputStream instream = null;
		HttpResponse response = null;
		HttpParams httpParameters = new BasicHttpParams();

		if (parameterMap != null && parameterMap.size() > 0) {
			Iterator<String> paramIterator = parameterMap.keySet().iterator();
			while (paramIterator.hasNext()) {
				String paramKey = paramIterator.next();
				httpParameters.setParameter(paramKey,parameterMap.get(paramKey));
			}
		}

		HttpClient httpclient = new DefaultHttpClient(httpParameters);
		if (null != url) {
			httpPostRequest = new HttpPost(url);
		} else {
			return null;
		}

		JSONObject object = new JSONObject();
		if(request != null && request.size() > 0) {
	        try {
	            object.put("cookie", request.get(0));
	            object.put("deviceId", request.get(1));
	            object.put("msisdn", request.get(2));
	            object.put("userId", request.get(3));
	
	        } catch (Exception ex) {
	
	        }
		}
        
        String message = object.toString();

        httpPostRequest.setEntity(new StringEntity(message, "UTF8"));
        httpPostRequest.setHeader("Content-type", "application/json");
		
		try {
			response = (HttpResponse) httpclient.execute(httpPostRequest);
			Log.d("PASSBOOK_POC",""+response.getStatusLine().getStatusCode());
		} catch (ClientProtocolException ex) {
			ex.printStackTrace();
			throw new ClientProtocolException();

		} catch (SocketException ex) {
			ex.printStackTrace();
			throw new SocketException();

		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
		HttpEntity entity = response.getEntity();
		
		if (entity != null) {
			instream = entity.getContent();
			Header[] header = response.getAllHeaders();
			for (Header h : header) {
				if (h.getName().equalsIgnoreCase("Status")&& h.getValue().startsWith("2")) {
					return instream;
				}
			}
		}
		 
		return null;
	}
	
	/**
	 * This method make's the post request to the server. Mainly used to send
	 * the image to server.
	 * 
	 * @param request
	 *            Body of the request in byte format
	 * @param url
	 *            Server Url
	 * @return InputStream if successful, otherwise null
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws SocketException
	 */
	public static InputStream makeDeleteRequest(String request, String url,
			HashMap<String, String> headerMap,
			HashMap<String, String> parameterMap)
			throws ClientProtocolException, IOException, SocketException {

		HttpDelete httpDeleteRequest = null;
		InputStream instream = null;
		HttpResponse response = null;
		HttpParams httpParameters = new BasicHttpParams();

		if (parameterMap != null && parameterMap.size() > 0) {
			Iterator<String> paramIterator = parameterMap.keySet().iterator();
			while (paramIterator.hasNext()) {
				String paramKey = paramIterator.next();
				httpParameters.setParameter(paramKey,parameterMap.get(paramKey));
			}
		}

		HttpClient httpclient = new DefaultHttpClient(httpParameters);
		if (null != url) {
			httpDeleteRequest = new HttpDelete(url);
		} else {
			return null;
		}

		JSONObject object = new JSONObject();
        try {

            object.put("cookie", "10C34498E4793C618A539E0C9E281472%2C1%2C5073A2097F");
            object.put("deviceId", "B539E4EF-6D2C-4B0D-A894-D899A48C8CA9");
            object.put("msisdn", "6474638994");
            object.put("userId", "gomez9@telusinternal.com");

        } catch (Exception ex) {

        }
        
        String message = object.toString();

//        httpDeleteRequest.setEntity(new StringEntity(message, "UTF8"));
        httpDeleteRequest.setHeader("Content-type", "application/json");
		
		try {
			response = (HttpResponse) httpclient.execute(httpDeleteRequest);
			Log.d("PASSBOOK_POC",""+response.getStatusLine().getStatusCode());
		} catch (ClientProtocolException ex) {
			ex.printStackTrace();
			throw new ClientProtocolException();

		} catch (SocketException ex) {
			ex.printStackTrace();
			throw new SocketException();

		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
		HttpEntity entity = response.getEntity();
		
		if (entity != null) {
			instream = entity.getContent();
			Header[] header = response.getAllHeaders();
			for (Header h : header) {
				if (h.getName().equalsIgnoreCase("Status")&& h.getValue().startsWith("2")) {
					return instream;
				}
			}
		}
		 
		return null;
	}
	

	/**
	 * This method make's the get request to the server
	 * 
	 * @param url
	 *            Server Url
	 * @param headerMap
	 *            HashMap of headers for the request
	 * @param parameterMap
	 *            HashMap of parameters for the request
	 * @return InputStream if successful, otherwise null
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws SocketException
	 */
	public static InputStream getRequest(String url,
			HashMap<String, String> headerMap,
			HashMap<String, String> parameterMap)
			throws ClientProtocolException, IOException, SocketException {

		HttpGet httpGetRequest = null;
		InputStream instream = null;
		HttpResponse response = null;
		HttpParams httpParameters = new BasicHttpParams();
		if (parameterMap != null && parameterMap.size() > 0) {
			Iterator<String> paramIterator = parameterMap.keySet().iterator();
			while (paramIterator.hasNext()) {
				String paramKey = paramIterator.next();
				httpParameters.setParameter(paramKey,
						parameterMap.get(paramKey));
			}
		}
		HttpClient httpclient = new DefaultHttpClient(httpParameters);
		if (null != url) {
			httpGetRequest = new HttpGet(url);
		} else {

			return null;

		}
		httpGetRequest.setHeader(KEY_APPLICATION_ID,
				PassConstants.APPLICATION_ID);
		httpGetRequest.setHeader(KEY_REST_API_ID, PassConstants.REST_API_KEY);

		if (headerMap != null && headerMap.size() > 0) {
			Iterator<String> headerIterator = headerMap.keySet().iterator();
			while (headerIterator.hasNext()) {
				String headerKey = headerIterator.next();
				httpGetRequest.setHeader(headerKey, headerMap.get(headerKey));
			}
		}

		try {
			response = (HttpResponse) httpclient.execute(httpGetRequest);
		} catch (ClientProtocolException ex) {
			ex.printStackTrace();
			throw new ClientProtocolException();

		} catch (SocketException ex) {
			ex.printStackTrace();
			throw new SocketException();

		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			instream = entity.getContent();
			Header[] header = response.getAllHeaders();
			for (Header h : header) {
				Log.d("Test", "header name :: " + h.getName());
				Log.d("Test", "header value :: " + h.getValue());

			}
		}
		return instream;
	}

}
