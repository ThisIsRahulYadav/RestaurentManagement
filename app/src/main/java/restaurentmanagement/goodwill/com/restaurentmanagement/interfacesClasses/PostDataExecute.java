package restaurentmanagement.goodwill.com.restaurentmanagement.interfacesClasses;

import org.json.JSONException;

/**
 * Created by lenovo on 5/7/2018.
 */

public interface PostDataExecute {

    void onPostRequestSuccess(int method, String response) throws JSONException;

    void onPostRequestFailed(int method, String response);
}
