package restaurentmanagement.goodwill.com.restaurentmanagement.adapterAndFragmentClasses;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by lenovo on 5/18/2018.
 */

public class FragmentsTabPagerAdapterMenu extends FragmentPagerAdapter {
    private List<String> categoryList;

    public FragmentsTabPagerAdapterMenu(FragmentManager FragmentManager, List<String> categoryList) {
        super(FragmentManager);
          Log.e("inside TABbbbbb", String.valueOf(categoryList));
        this.categoryList = categoryList;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.e("the value position tab", String.valueOf(position));
        return categoryList.get(position);
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Fragment getItem(int position) {
   // return null;
        Log.e("get Instance in tabdd",categoryList.get(position));
     // return null;
      return  MenuTabFragment.getInstance(categoryList.get(position));
    }
}
