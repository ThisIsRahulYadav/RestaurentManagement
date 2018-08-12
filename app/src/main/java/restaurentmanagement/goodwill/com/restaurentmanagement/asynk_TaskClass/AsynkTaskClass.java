package restaurentmanagement.goodwill.com.restaurentmanagement.asynk_TaskClass;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import restaurentmanagement.goodwill.com.restaurentmanagement.interfacesClasses.PostDataExecute;


/**
 * Created by lenovo on 5/4/2018.
 */

public class AsynkTaskClass extends AsyncTask<String, Void, String> {


    Context context;
    int method;
    String resp;
    String requestBody;
    PostDataExecute postDataExecute;
    Response response;

    public AsynkTaskClass(Context context, int method, String requestBody) {

        this.context = context;
        this.method = method;
        this.requestBody = requestBody;
        postDataExecute = (PostDataExecute) context;
    }

        public static final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected String doInBackground(String... params) {
//Log.e("requestBody",requestBody.toString());
                OkHttpClient client = new OkHttpClient();
        RequestBody body=RequestBody.create(JSON,requestBody);
        try {
            Request request = new Request.Builder()
                    .url(params[0])
                    .post(body)
                    .build();
            response = client.newCall(request).execute();
            resp = response.body().string();
        } catch (Exception e) {
            Log.e("Executng Post", e.getMessage());
        }
        return resp;
    }

    @Override
    protected void onPostExecute(String respo) {
        super.onPostExecute(respo);
        Log.e("DataFromMenuFr", respo + "dsdsdsds");
        if (response.isSuccessful())
            try {
                if (respo.length() > 0) {
                    postDataExecute.    onPostRequestSuccess(method, respo);
                } else {
                    postDataExecute.onPostRequestFailed(method, "Network Error Try Again..");
                }
            } catch (Exception e) {
                postDataExecute.onPostRequestFailed(method, "Failed");
            }
        else {
            postDataExecute.onPostRequestFailed(method, response.message());
        }
    }
}