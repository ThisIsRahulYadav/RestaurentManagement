package restaurentmanagement.goodwill.com.restaurentmanagement.adapterAndFragmentClasses;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import restaurentmanagement.goodwill.com.restaurentmanagement.R;
import restaurentmanagement.goodwill.com.restaurentmanagement.helperClasses.TableBookDialog;
import restaurentmanagement.goodwill.com.restaurentmanagement.helperClasses.TableStatusGetrSetr;
import restaurentmanagement.goodwill.com.restaurentmanagement.interfacesClasses.TableIntentInterface;

/**
 * Created by lenovo on 5/15/2018.
 */

public class RecyclerAdapterTable extends RecyclerView.Adapter<RecyclerAdapterTable.RestaurantViewHolder> {
    private ArrayList<TableStatusGetrSetr> arrayRecycler = new ArrayList<>();
    private Context mContext;
    Activity activity;
    TableIntentInterface tableIntentClass;
    int buttonValue;

    public RecyclerAdapterTable(TableIntentInterface intentClass, Context context, Activity activity, ArrayList<TableStatusGetrSetr> arrayRecycler) {
        mContext = context;
        this.arrayRecycler = arrayRecycler;
        this.activity = activity;
        this.tableIntentClass = intentClass;
    }
    @Override
    public RecyclerAdapterTable.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_u_i, parent, false);
        RestaurantViewHolder viewHolder = new RestaurantViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerAdapterTable.RestaurantViewHolder holder, int position) {
        int width = activity.getResources().getDisplayMetrics().widthPixels;
        int margin = width / 22;
        // buttonValue = position;

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width / 6, width / 6);
        layoutParams.setMargins(margin, margin, margin, margin);
        holder.button.setLayoutParams(layoutParams);

        int tableStatus = Integer.parseInt(String.valueOf(arrayRecycler.get(position).getStatus()));
        holder.button.setText(arrayRecycler.get(position).getTableNo());
        final int tableNumber = Integer.parseInt(String.valueOf(arrayRecycler.get(position).getTableNo()));

        if (tableStatus > 0) {
            holder.button.setBackgroundColor(Color.parseColor("#FFDE1C1C"));
        } else {
            holder.button.setBackgroundColor(Color.parseColor("#FF26E115"));
        }

        final int value = position;
        buttonValue = value;

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tableIntentClass.buttonValue(value);

                int tableStatus = Integer.parseInt(String.valueOf(arrayRecycler.get(value).getStatus()));
                if (tableStatus > 0) {
                    Toast.makeText(activity, "TABLE ENGAGED", Toast.LENGTH_SHORT).show();
                    tableIntentClass.tableIntent();

                } else {
                    new TableBookDialog(activity, value, arrayRecycler).show();
                }
                Toast.makeText(activity, "table number" + String.valueOf(arrayRecycler.get(value).getTableNo()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void tableUpdater(int position) {
        Log.e("podition in updater", String.valueOf(position));
        arrayRecycler.get(position).setStatus("1");
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return arrayRecycler.size();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder {
        //@Bind(R.id.button)

        /*  @Bind(R.id.restaurantNameTextView) TextView mNameTextView;
          @Bind(R.id.categoryTextView) TextView mCategoryTextView;
          @Bind(R.id.ratingTextView) TextView mRatingTextView;
      */    private Context mContext;
        Button button;

        public RestaurantViewHolder(View itemView) {
            super(itemView);
            //  ButterKnife.bind(this, itemView);
            button = itemView.findViewById(R.id.button);
            mContext = itemView.getContext();
        }
/*
        public void bindRestaurant(TableStatusGetrSetr tableStatusClass) {
//        mNameTextView.setText(restaurant.getName());
//        mCategoryTextView.setText(restaurant.getCategories().get(0));
//        mRatingTextView.setText("Rating: " + restaurant.getRating() + "/5");
        }*/
    }
}