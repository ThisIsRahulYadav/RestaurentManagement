package restaurentmanagement.goodwill.com.restaurentmanagement.adapterAndFragmentClasses;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import restaurentmanagement.goodwill.com.restaurentmanagement.R;


public class MenuTabFragment extends Fragment {
    private List<String> menuContentList;
    private ImageView imageView;
    public MenuTabFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view=inflater.inflate(R.layout.menu_u_i, container, false);
      //  imageView=view.findViewById(R.id.item_image);
  //      imageView.setImageResource(Integer.parseInt(String.valueOf(menuContentList)));
        return view;
    }

    public static MenuTabFragment getInstance(String category) {
        MenuTabFragment fragment = new MenuTabFragment();
        Bundle bundle = new Bundle();

        bundle.putString("category in menu fr1", category);
        fragment.setArguments(bundle);

        return fragment;
    }
    /* private String category;

   private ListView listView;
Activity activity;
    public static MenuTabFragment (String category) {
        MenuTabFragment fragment = new MenuTabFragment();
        Bundle bundle = new Bundle();

        bundle.putString("category in menu fr1", category);
        fragment.setArguments(bundle);

        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.menu_fragment_recycler_view, container, false);
    }
 *//*   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.fragment_menu, container, false);
        if (getArguments() != null) {
            category = getArguments().getString("category");
        }
    }
*//*
    *//*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }*//*
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
       super.onViewCreated(view,savedInstanceState);

       //listView.setAdapter();


        *//*RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
*//*

      *//*  CategorywiseFoodItemAdapter foodMenuItemAdapter = new CategorywiseFoodItemAdapter(this, getActivity(), categoryWiseFoodItemsList());
        recyclerView.setAdapter(foodMenuItemAdapter);*//*

    }

    private OnFragmentInteractionListener mListener;

    public MenuTabFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
            Log.e("the value of URI", String.valueOf(uri));
        }
    }

    *//**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     *//*
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
