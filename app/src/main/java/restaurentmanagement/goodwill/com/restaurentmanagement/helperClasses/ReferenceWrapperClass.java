package restaurentmanagement.goodwill.com.restaurentmanagement.helperClasses;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by lenovo on 5/10/2018.
 */

public class ReferenceWrapperClass {

    Activity activity;


    private static ReferenceWrapperClass referenceWrapperClass;

    private ReferenceWrapperClass(Activity activity) {
        //reference constructor created
        this.activity = activity;
    }

    public static ReferenceWrapperClass getReferenceClass(Activity activity) {

        if (referenceWrapperClass == null) {
            referenceWrapperClass = new ReferenceWrapperClass(activity);
        }
        return referenceWrapperClass;
    }

 //  public void setsharedpreference(Activity activity, String key,int)

    public void setSharedPreference(Activity activity,String key,String value){
        SharedPreferences sharedPreferences=activity.getSharedPreferences(activity.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,value);
        editor.apply();
    }
    public String getSharedPreference(Activity activity,String key,String defaultVal){
        SharedPreferences sharedPreferences =activity.getSharedPreferences(activity.getPackageName(),Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,null);
    }
}
   /* public void asynTask(Activity activity, String baseURL, String additionalURL,String name,String value) {
        //Intent myintent = new Intent(this, Menu.class);
        //startActivity(myintent);

       *//* try {
            JSONObject json = new JSONObject();
            json.put("email_id", name);
            json.put("password", value);
          *//**//*  json.put("mobilenumber", "7503757651");
            json.put("address", "B- 86 Sector 6 Noida");
            json.put("landmark", "near noida authority");
            json.put("lat_lang", "near noida authority");
            json.put("password", "admin");
            json.put("role", "1");
            json.put("deviceid", "dsdshjdskjdfsndfsknfdjdfskljldsnskjkdskjdfsdf");
*//**//*
            *//**//*RequestBody formBody = new
                    .add("", json.toString())
                    .build();*//**//*
            new AsynkTaskClass(activity, 1, json.toString()).execute(baseURL + additionalURL);*//*//**//*getResources().getString(R.string.TABLE_URL)*//**//**//**//*);
        } catch (Exception e) {

        }*//*
    }*/


    /*  public ReferenceWrapperClass(Activity activity) {

    }

    enum Singleton {
   INSTANCE;

        public Activity activity;

        @Override
        public void cart(Activity activity, String f, String r) {
            //Intent myintent = new Intent(this, Menu.class);
            //startActivity(myintent);

            try {
                JSONObject json = new JSONObject();
                json.put("username", "Param");
                json.put("emailid", "mailtoparam1@gmail.com");
                json.put("mobilenumber", "7503757651");
                json.put("address", "B- 86 Sector 6 Noida");
                json.put("landmark", "near noida authority");
                json.put("lat_lang", "near noida authority");
                json.put("password", "admin");
                json.put("role", "1");
                json.put("deviceid", "dsdshjdskjdfsndfsknfdjdfskljldsnskjkdskjdfsdf");

                RequestBody formBody = new FormEncodingBuilder()
                        .add("DataFromMenuFr", json.toString())
                        .build();
                new AsynkTaskClass(activity, 1, formBody).execute(f + r*//*getResources().getString(R.string.TABLE_URL)*//*);
            } catch (Exception e) {

            }
        }
        }
}
*/