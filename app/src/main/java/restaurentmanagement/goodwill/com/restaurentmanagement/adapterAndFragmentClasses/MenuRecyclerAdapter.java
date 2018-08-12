package restaurentmanagement.goodwill.com.restaurentmanagement.adapterAndFragmentClasses;

import android.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import restaurentmanagement.goodwill.com.restaurentmanagement.R;

/**
 * Created by lenovo on 5/31/2018.
 */

public class MenuRecyclerAdapter extends RecyclerView.Adapter<MenuRecyclerAdapter.RestaurantViewHolderMenu> {
    private List<String> menuContentLists;
    int product;
    public FragmentManager fragmentManager;

    public MenuRecyclerAdapter(List<String> menuContentLists) {
        Log.e("content inside MenuAda", String.valueOf(menuContentLists));
        this.menuContentLists = menuContentLists;
    Log.e("menuContentLists",""+this.menuContentLists.size());
        Log.e("menuContetsIncoming",""+menuContentLists.size());
    }

    @Override
    public RestaurantViewHolderMenu onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("listtttttttt00000 in", String.valueOf(menuContentLists));
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_u_i, parent, false);
//        MenuRecyclerAdapter.RestaurantViewHolderMenu viewHolderMenu=
        Log.e("listtttttttt00000 out", String.valueOf(menuContentLists));
        return new MenuRecyclerAdapter.RestaurantViewHolderMenu(view);
    }

    @Override
    public void onBindViewHolder(RestaurantViewHolderMenu holder, int position) {

        Log.e("listtttttttt1111", String.valueOf(menuContentLists));
        for (int i = 0; i < menuContentLists.size(); i++) {
           // holder.image.setImageResource(Integer.parseInt(menuContentLists.get(i)));
          //  holder.image.setBackgroundResource(R.drawable.ic_launcher_background);
        }


        /* Log.e("the value of ","00000000000000000000000000000000000000000");
        Log.e("ttttttttttttttttt", String.valueOf(menuContentLists));*/
        //holder.image.setImageResource();
        /* holder.image.setText("ABc");
           String rr= (String) holder.image.getText();
           Log.e( "rrrrrrrrrrr",rr+" pos "+position);
        HashMap models;
        ((RestaurantViewHolderMenu) holder).bindData(menuContentLists.get(position));*/
    }

    @Override
    public int getItemCount() {
//        Log.e("menuContentLists COUNT", String.valueOf(menuContentLists));
//        Log.e("list size  MenuRecycler", String.valueOf(menuContentLists.size()));
        Log.e("listtttttttt2222", String.valueOf(menuContentLists));
        return menuContentLists.size();

       /* return menuContentLists.;*/
    }

    class RestaurantViewHolderMenu extends RecyclerView.ViewHolder {
        ImageView image;

        RestaurantViewHolderMenu(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_image);
               /* String imageResourse=String.valueOf(menuContentLists);
                Log.e("value of imageResourse",imageResourse);*/
//                image.setText("google");
                /*String ss= (String) image.getText();
                Log.e( "ssssssss",ss);*/
        }

       /* public void bindData(String s) {
        }*/
    }

/*class RestaurantViewHolderMenu extends RecyclerView.ViewHolder{
            public RestaurantViewHolderMenu(View itemView) {
                super(itemView);
            }*/
}





