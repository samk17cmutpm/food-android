package startupordie.food.food;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import startupordie.food.lib.SmartFragmentStatePagerAdapter;

/**
 * Created by samnguyen on 25/04/2016.
 */
public class FoodsPagerAdapter extends SmartFragmentStatePagerAdapter {
    private static int NUM_ITEMS = 2;
    private FoodsMostPopularPresenter foodsMostPopularPresenter;
    private FoodsNearestPresenter foodsNearestPresenter;
    public FoodsPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                fragment = new FoodsMostPopularFragment().newInstance();
                foodsMostPopularPresenter = new
                        FoodsMostPopularPresenter((FoodsContract.FoodsMostPopularView) fragment);
                return fragment;
            case 1: // Fragment # 0 - This will show FirstFragment different title
                fragment = new FoodsNearestFragment().newInstance();
                foodsNearestPresenter = new
                        FoodsNearestPresenter((FoodsContract.FoodsNearestView) fragment);
                return fragment;
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Most Popular";
                break;
            case 1:
                title = "Nearest";
                break;
        }
        return title;
    }

}
