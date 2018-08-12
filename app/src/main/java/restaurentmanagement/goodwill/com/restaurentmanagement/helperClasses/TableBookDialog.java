package restaurentmanagement.goodwill.com.restaurentmanagement.helperClasses;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.json.JSONObject;

import java.util.ArrayList;

import restaurentmanagement.goodwill.com.restaurentmanagement.R;
import restaurentmanagement.goodwill.com.restaurentmanagement.asynk_TaskClass.AsynkTaskClass;

/**
 * Created by lenovo on 5/16/2018.
 */

public class TableBookDialog extends Dialog implements View.OnClickListener {
Activity activity;
private ArrayList arrayList;
private int position;
//TableBookReq tableBookReq;
    private ReferenceWrapperClass reference=ReferenceWrapperClass.getReferenceClass(activity);
    private ArrayList<TableStatusGetrSetr> arrayDialog = new ArrayList<>();
    public TableBookDialog(Activity activity, int position, ArrayList<TableStatusGetrSetr> arrayDialog) {
        super(activity);
        this.activity=activity;
        this.position=position;
        this.arrayDialog=arrayDialog;
     //  this.tableBookReq=tableBookReq;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.table_booking_alert);
        setCanceledOnTouchOutside(false);
        Button yes=(Button)findViewById(R.id.table_book_yes);
        Button cancel=(Button)findViewById(R.id.table_book_cancel);
        yes.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.table_book_yes:{
                    try {
                        JSONObject json = new JSONObject();
                        json.put("email_id", reference.getSharedPreference(activity, "email_id", ""));
                        json.put("api_key", reference.getSharedPreference(activity, "api_key", ""));
                        arrayDialog.get(position).getTableNo();
                        json.put("table_number",arrayDialog.get(position).getTableNo());
                        new AsynkTaskClass(activity, 2, json.toString()).execute(activity.getResources().getString(R.string.BASE_URL) + activity.getResources().getString(R.string.RESERVE_TABLE_URL));
                    } catch (Exception e) {
                    }
                //Toast.makeText(activity,"table number "+tableNumber+"and table status "+tableStatus,Toast.LENGTH_SHORT).show();

          //tableBookReq.postingJsonData();
               // Log.e("table number in Dialog", String.valueOf(tableBookReq.postingJsonData()));
           /*int r= arrayDialog.get(position).setStatus("1");
                Log.e("the value of rrrrrrrrr", String.valueOf(r));*/
                dismiss();
            }break;
            case R.id.table_book_cancel:{
              arrayDialog.get(position).getStatus();
            dismiss();
            }break;
        }
    }
}
