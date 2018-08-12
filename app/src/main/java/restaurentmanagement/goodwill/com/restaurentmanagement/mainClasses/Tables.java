package restaurentmanagement.goodwill.com.restaurentmanagement.mainClasses;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import restaurentmanagement.goodwill.com.restaurentmanagement.adapterAndFragmentClasses.RecyclerAdapterTable;
import restaurentmanagement.goodwill.com.restaurentmanagement.helperClasses.ReferenceWrapperClass;
import restaurentmanagement.goodwill.com.restaurentmanagement.R;
import restaurentmanagement.goodwill.com.restaurentmanagement.asynk_TaskClass.AsynkTaskClass;
import restaurentmanagement.goodwill.com.restaurentmanagement.helperClasses.TableStatusGetrSetr;
import restaurentmanagement.goodwill.com.restaurentmanagement.interfacesClasses.PostDataExecute;
import restaurentmanagement.goodwill.com.restaurentmanagement.interfacesClasses.TableIntentInterface;

public class Tables extends AppCompatActivity implements PostDataExecute, TableIntentInterface {
    RecyclerAdapterTable adapter;
    private ReferenceWrapperClass reference;
    Activity activity;
    private int buttonValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);
        reference = ReferenceWrapperClass.getReferenceClass(this);
        onClicklistener();

        getTableStatus();

     /*   RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        recyclerView.setAdapter(new RecyclerAdapterTable(Tables.this, 3, (CartInterface) this));
       // adapter = new RecyclerAdapterTable(this,item);
//          adapter.setClickListener(this);
         recyclerView.setAdapter(adapter);*/
    }

    private void onClicklistener() {
        Button refresh = (Button) findViewById(R.id.refresh);


        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getTableStatus();
            }
        });
    }

    ArrayList<TableStatusGetrSetr> nums = new ArrayList<TableStatusGetrSetr>();

    @Override
    public void onPostRequestSuccess(int method, String response) {
        Log.e("response success table", response);
        if (method == 1) {
            try {
                JSONObject jsonObject = new JSONObject(response);
                String jsonData = jsonObject.getString("tables");
                nums.clear();
                JSONArray jsonArray = new JSONArray(jsonData);
//                Log.e("json array length", String.valueOf(jsonArray.length()));
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

//                  Log.e("json Obj val tableCLSss", String.valueOf(jsonObject1));
                    String tableNO = jsonObject1.getString("tableNumber");
                    String status = jsonObject1.getString("status");
//                    Log.e("TABLE NUMBERRrrr", tableNO);
//                    Log.e("TABLE STATUSss", status);

                    nums.add(new TableStatusGetrSetr(tableNO, status));
//                    Log.e("num after added", String.valueOf(nums));
                }

                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                int numberOfColumns = 4;
                recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
                adapter = new RecyclerAdapterTable(this, activity, Tables.this, nums);
                //  adapter.setClickListener(this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            adapter.tableUpdater(buttonValue);
        }
    }

    @Override
    public void onPostRequestFailed(int method, String response) {
        Log.e("response on failure", response);
    }

    /*  @Override
      public void postingJsonData(){
          try {
              JSONObject json = new JSONObject();
              json.put("email_id", reference.getSharedPreference(this, "email_id", ""));
              json.put("api_key", reference.getSharedPreference(Tables.this, "api_key", ""));
              json.put("tableNumber",nums.get(buttonValue).setStatus("1"));
              Log.e("btnVAlue in Json", String.valueOf(buttonValue));
              new AsynkTaskClass(Tables.this, 1, json.toString()).execute(getResources().getString(R.string.BASE_URL) + getResources().getString(R.string.RESERVE_TABLE_URL));
          } catch (Exception e) {
          }
      }*/

    public void getTableStatus() {
        try {
            JSONObject json = new JSONObject();
            json.put("email_id", reference.getSharedPreference(this, "email_id", ""));
            json.put("api_key", reference.getSharedPreference(Tables.this, "api_key", ""));

            new AsynkTaskClass(Tables.this, 1, json.toString()).execute(getResources().getString(R.string.BASE_URL) + getResources().getString(R.string.TABLE_URL));
        } catch (Exception e) {
        }
    }

    public void tableIntent() {
        Intent myintent = new Intent(Tables.this, Menu.class);
        startActivity(myintent);
    }

    public void buttonValue(int buttonValue) {
        this.buttonValue = buttonValue;
    }


  /*  @Override
    public void cart(String r) {
        Intent myintent = new Intent(Tables.this, Menu.class);
        startActivity(myintent);

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
            new AsynkTaskClass(Tables.this, 1, formBody).execute(getResources().getString(R.string.BASE_URL) + getResources().getString(R.string.TABLE_URL)
);
        } catch (Exception e) {

        }
    }

*/
/*    @Override
    public void onPostRequestSuccess(int method, String response) {
        Log.e("Responce success", response);
        try {
            JSONObject jsnobject = new JSONObject(response);
            String DataFromMenuFr = jsnobject.getString("tables");
            JSONArray jsonArray = new JSONArray(DataFromMenuFr);
            // jsnobject.put("tableNumber",jsonArray);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject explrObject = jsonArray.getJSONObject(i);
                Log.e("the valueee herreeere", String.valueOf(explrObject));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPostRequestFailed(int method, String DataFromMenuFr) {
        Log.e("Responce Error", DataFromMenuFr);
    }*/

}
