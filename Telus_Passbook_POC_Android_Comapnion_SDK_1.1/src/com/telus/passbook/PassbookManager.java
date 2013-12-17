package com.telus.passbook;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

import com.telus.passbook.config.Config;
import com.telus.passbook.constant.PassConstants;
import com.telus.passbook.model.Deal;
import com.telus.passbook.network.ResponseParser;
import com.telus.passbook.utils.Utils;

/**
 * This class is responsible to manage and execute the all server requests.
 * 
 * @author abhishek.puppalwar
 */
public class PassbookManager
{

    private final String TAG = PassbookManager.class.getSimpleName();

    @SuppressWarnings( "unused" )
    private Config config = null;

    @SuppressWarnings( "unused" )
    private Context context = null;

    private ArrayList<Deal> deals;

    private static PassbookManager mPassbookManager;

    /**
     * Initializes <code> PassbookManager </code> the class.
     * 
     * @param config
     *            Server Configuration
     * @param context
     *            Application Context
     */
    private PassbookManager(Config config, Context context)
    {

        this.config = config;

        this.context = context;
    }

    /**
     * This method gives the single instance of
     * <code> PassbookManager </code>
     * 
     * @param config
     *            Server Configuration
     * @param context
     *            Application Context
     * @return PassbookManager
     */
    public static PassbookManager getInstance( Config config,
            Context context )
    {

        if ( mPassbookManager == null )
        {
            mPassbookManager = new PassbookManager( config, context );
        }
        return mPassbookManager;
    }

    

    

    /**
     * This method removes the older instance of the
     * <code> PassbookManager </code>
     */
    public void removeInstance()
    {

        mPassbookManager = null;
    }

    public ArrayList<Deal> getDeals()
    {

        if ( deals == null || false ) // false means 3 mins time elapses 
        {
        	String response = Utils.getRequest(PassConstants.GET_DEALS_REQUEST,null,null);
        	Log.d("PASSBOOK_POC","JSON Response ::: "+response);
        	ResponseParser responseParser = new ResponseParser();
        	deals = responseParser.parseDeals(response);
        }
        return deals;

    }

    public boolean setRememberMe(ArrayList<String> rmCookies) {
    	
    	if(rmCookies != null && rmCookies.size() > 0) {
			String response = Utils.postRequest(rmCookies, PassConstants.POST_REMEMBER_ME_REQUEST, null, null);
			return true;
    	}
    	return false;
    	/*if(rmCookies != null && rmCookies.size() > 0) {
    		int size = rmCookies.size();
    		String json = new String("{");
    		for(int i = 0 ; i < size; i++) {
    			json = json+rmCookies.get(i);
    			if(i != size -1)
    				json = json+",";
    			else
    				json = json+"}";
    		}*/
    		/*String response = Utils.postRequest(json, PassServerConstants.POST_REMEMBER_ME_REQUEST, null, null);
    		Log.d("PASSBOOK_POC","JSON Response ::: "+response);
        	ResponseParser responseParser = new ResponseParser();
        	return true;*/
//    	}
//    	return false;
    }
}
