package restaurentmanagement.goodwill.com.restaurentmanagement.mainClasses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import restaurentmanagement.goodwill.com.restaurentmanagement.R;
import restaurentmanagement.goodwill.com.restaurentmanagement.asynk_TaskClass.AsynkTaskClass;
import restaurentmanagement.goodwill.com.restaurentmanagement.helperClasses.ReferenceWrapperClass;
import restaurentmanagement.goodwill.com.restaurentmanagement.interfacesClasses.PostDataExecute;

public class LoginScreen extends AppCompatActivity implements PostDataExecute  {

    EditText username;
    EditText password;
    CheckBox showPassword;
    ProgressBar loginProgressBar;


    private ReferenceWrapperClass reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        reference = ReferenceWrapperClass.getReferenceClass(this);
        onClickListener();
        username.setText("raorahul@gmail.com");
        password.setText("12345");
        /*Intent myintent = new Intent(LoginScreen.this, Tables.class);
        startActivity(myintent);*/
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void onClickListener() {
        username = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        showPassword = (CheckBox) findViewById(R.id.showPassword);
        Button loginBTN = (Button) findViewById(R.id.login);
        loginProgressBar=(ProgressBar)findViewById(R.id.login_progressBar);


        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    JSONObject json = new JSONObject();
                    json.put("email_id", username.getText().toString());
                    json.put("password", password.getText().toString());

                    new AsynkTaskClass(LoginScreen.this, 1, json.toString()).execute(getResources().getString(R.string.BASE_URL) + "login");
                } catch (Exception e) {
                }
                loginProgressBar.setVisibility(View.VISIBLE);

                //                reference.asynTask(LoginScreen.this,"http://192.168.1.8:8080/RestaurantManagement/api/","login",username.getText().toString(),password.getText().toString());
            }
        });

        showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // checkbox status is changed from uncheck to checked.
                if (!isChecked) {
                    // show password
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }

    @Override
    public void onPostRequestSuccess(int method, String response) {
        Log.e("on success LOGIN", response);
        loginProgressBar.setVisibility(View.GONE);
        try {
            JSONObject jsonObject = new JSONObject(response);
            // String DataFromMenuFr=jsonObject.getString("message");

            String userdata = jsonObject.getString("user");
            JSONObject jsonObject1 = new JSONObject(userdata);
            reference.setSharedPreference(this, "userData", userdata);
            reference.setSharedPreference(this, "email_id", jsonObject1.getString("email_id"));
            reference.setSharedPreference(this, "api_key", jsonObject1.getString("api_key"));

            String statusCode = jsonObject.getString("status");
            Log.e("STATUS CODE ", statusCode);
            if (statusCode.equals("200")) {
                Toast.makeText(LoginScreen.this, "code 200 success", Toast.LENGTH_SHORT).show();
                if (username.getText().toString().equals(username.getText().toString()) && password.getText().toString().equals("12345")) {
                    Toast.makeText(LoginScreen.this, "username and password correct", Toast.LENGTH_SHORT).show();
                    Intent myintent = new Intent(LoginScreen.this, Tables.class);
                    startActivity(myintent);
                } else {
                    Toast.makeText(LoginScreen.this, "wrong Details try again", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onPostRequestFailed(int method, String response) {
        Log.e("on failure LOGIN", response);
        loginProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void registerForContextMenu(View view) {
    }


}