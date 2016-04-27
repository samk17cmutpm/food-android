package startupordie.food.food_detail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import startupordie.food.lib.SmartFragmentStatePagerAdapter;

/**
 * Created by samnguyen on 27/04/2016.
 */
public class FoodsDetailPagerAdapter extends SmartFragmentStatePagerAdapter {
    private static int NUM_ITEMS = 2;
    private FoodsDetailInfoPresenter foodsDetailInfoPresenter;
    private FoodsDetailMapPresenter foodsDetailMapPresenter;
    public FoodsDetailPagerAdapter(FragmentManager fragmentManager) {
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
                fragment = new FoodsDetailInfoFragment().newInstance();
                foodsDetailInfoPresenter = new
                        FoodsDetailInfoPresenter((FoodsDetailsContract.FoodsDetailInfoView) fragment);
                return fragment;
            case 1: // Fragment # 0 - This will show FirstFragment different title
                fragment = new FoodsDetailMapFragment().newInstance();
                foodsDetailMapPresenter = new
                        FoodsDetailMapPresenter((FoodsDetailsContract.FoodsDetailMapView) fragment);
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
                title = "Details";
                break;
            case 1:
                title = "Map";
                break;
        }
        return title;
    }

}
