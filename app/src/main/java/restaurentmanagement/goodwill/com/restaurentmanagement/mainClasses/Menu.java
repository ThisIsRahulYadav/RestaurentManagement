package restaurentmanagement.goodwill.com.restaurentmanagement.mainClasses;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import restaurentmanagement.goodwill.com.restaurentmanagement.R;
import restaurentmanagement.goodwill.com.restaurentmanagement.adapterAndFragmentClasses.MenuRecyclerAdapter;
import restaurentmanagement.goodwill.com.restaurentmanagement.asynk_TaskClass.AsynkTaskClass;
import restaurentmanagement.goodwill.com.restaurentmanagement.adapterAndFragmentClasses.FragmentsTabPagerAdapterMenu;
import restaurentmanagement.goodwill.com.restaurentmanagement.helperClasses.ReferenceWrapperClass;
import restaurentmanagement.goodwill.com.restaurentmanagement.interfacesClasses.PostDataExecute;

public class Menu extends AppCompatActivity implements PostDataExecute {
    ReferenceWrapperClass reference;
    MenuRecyclerAdapter adapter;

    // created only for practice
   /* List<String> categoryList = new ArrayList<>();
    List<String> menuContentLists =new ArrayList<>();*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        reference = ReferenceWrapperClass.getReferenceClass(this);
        getMenuItems();

        // created only for practice
        /*categoryList.add("Chicken");
        categoryList.add("Paneer");
        categoryList.add("Breads");
        menuContentLists.add("R.drawable.progress_bar_color");
        menuContentLists.add("R.drawable.progress_bar_color");
        menuContentLists.add("R.drawable.progress_bar_color");
        recyclerView();*/
    }

    public void getMenuItems() {
        try {
            JSONObject json = new JSONObject();
            json.put("email_id", reference.getSharedPreference(this, "email_id", ""));
            json.put("api_key", reference.getSharedPreference(Menu.this, "api_key", ""));

            new AsynkTaskClass(Menu.this, 1, json.toString()).execute(getResources().getString(R.string.BASE_URL) + getResources().getString(R.string.FOODMENU_URL));
        } catch (Exception e) {
            Log.e("menu Ex",e.toString());
        }
    }

    @Override
    public void onPostRequestFailed(int method, String response) {
        Log.e("response failure menu", response);
    }

    @Override
    public void onPostRequestSuccess(int method, String response) {
        Log.e("response success menu", response);
        //getting api from server
        try {
            JSONObject jsonObject = new JSONObject(response);
            int status = jsonObject.getInt("status");
            if (status == 200) {
                JSONArray foodMenu = jsonObject.getJSONArray("menu");
                String jsonString = jsonObject.getJSONArray("menu").toString();
                Log.e("the value JSONNSTRING", jsonString);
               // ArrayList<String>arr=new ArrayList<>();

                //Recycler View
                RecyclerView recyclerView =findViewById(R.id.recyclerViewMenu);
                //MenuRecyclerAdapter menuPagerAdapter = new MenuRecyclerAdapter();

                //creating list of category

                List<String> categoryList = new ArrayList<>();
                List<String> menuContentLists =new ArrayList<>();
                for (int i = 0; i < foodMenu.length(); i++) {
                    JSONObject items= foodMenu.getJSONObject(i);
                    Log.e("value of itemssssss men", String.valueOf(items));
                   String category=items.getString("category_name");
                   String item_image= items.getString("item_image");
                    Log.e("the value of categorryu",category);

                    Log.e("the value of itemIMAge",item_image);
                    if (items.getBoolean("is_avalable") && !categoryList.contains(category)) {
                        categoryList.add(category);
                        menuContentLists.add(item_image);
                        Log.e("category val inside",category);
                    }
                    /*  if (items.getBoolean("is_avalable") && !categoryList.contains(category)) {
                        categoryList.add(category);
                       Log.e("category List", String.valueOf(categoryList));
                   }*/
                }
                Log.e("category size val ", String.valueOf(categoryList.size()));
                //creating view paager and creating tabs


                Log.e("rahul menu",""+menuContentLists.size());
                adapter=new MenuRecyclerAdapter(menuContentLists);
                createTabs(categoryList,menuContentLists);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            } else {
                String messaage = jsonObject.getString("message");
                Toast.makeText(this, messaage, Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void createTabs( List<String> categoryList,List<String> menuContentLists) {
        Log.e("content inside Menu", String.valueOf(menuContentLists));

        ViewPager viewPager = findViewById(R.id. viewPagerFragement);
        Log.e("category list in cr.tab", String.valueOf(categoryList));
        FragmentsTabPagerAdapterMenu fragmentsViewPagerAdapter = new FragmentsTabPagerAdapterMenu(getSupportFragmentManager(), categoryList);
        Log.e("menu list in menu", String.valueOf(menuContentLists));



        viewPager.setAdapter(fragmentsViewPagerAdapter);
       //viewPager.setAdapter(menuPagerAdapter);
      //  fragmentsViewPagerAdapter.notifyDataSetChanged();

        TabLayout waiterTabLayout = findViewById(R.id.waiter_tab_layout);
        waiterTabLayout.setupWithViewPager(viewPager);
    }
 /*   // created only for practice
    private void recyclerView(){
        createTabs(categoryList,menuContentLists);
        RecyclerView recyclerView=findViewById(R.id.recyclerViewMenu);

    }
*/}
