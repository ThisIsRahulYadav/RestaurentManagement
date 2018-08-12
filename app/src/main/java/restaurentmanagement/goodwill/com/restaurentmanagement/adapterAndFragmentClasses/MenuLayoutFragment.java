package restaurentmanagement.goodwill.com.restaurentmanagement.adapterAndFragmentClasses;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import restaurentmanagement.goodwill.com.restaurentmanagement.R;

/**
 * Created by lenovo on 6/28/2018.
 */
public class MenuLayoutFragment extends Fragment {

    public MenuLayoutFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.menu_fragment_recycler_view,container,false);
        RecyclerView recyclerView=view.findViewById(R.id.recyclerViewMenu);
//super.onCreateView(inflater, container, savedInstanceState);
    return view;
    }

    public static MenuLayoutFragment getInstance(String category){
        MenuLayoutFragment fragmentClass=new MenuLayoutFragment();
        Bundle bundle=new Bundle();

        bundle.putString("value of category in fragment",category);
        fragmentClass.setArguments(bundle);

        return fragmentClass;
    }
}
