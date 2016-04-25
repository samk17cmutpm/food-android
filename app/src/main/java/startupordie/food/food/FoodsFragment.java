package startupordie.food.food;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import java.util.List;

import startupordie.food.R;
import startupordie.food.data.Food;
import startupordie.food.lib.SmartFragmentStatePagerAdapter;
import startupordie.food.main.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodsFragment extends Fragment implements FoodsContract.View{

    private FoodsContract.Presenter presenter;

    private FoodsViewModel foodsViewModel;

    private SmartFragmentStatePagerAdapter adapterViewPager;

//    private RecyclerView recyclerView;
//    private RecyclerView.Adapter foodsAdapter;
//    private RecyclerView.LayoutManager layoutManager;


    public FoodsFragment() {
        // Required empty public constructor
    }

    public static FoodsFragment newInstance() {
        return new FoodsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_foods, container, false);
//        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
//        recyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(layoutManager);
        presenter.loadFoods(true);
        ViewPager viewPager = (ViewPager) root.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyPagerAdapter(getFragmentManager()));

        // Give the PagerSlidingTabStrip the ViewPager
        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) root.findViewById(R.id.tabs);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);
        return root;
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        Log.d("====>", "====>");

    }

    @Override
    public void showFoods(List<Food> foods) {
//        foodsAdapter = new FoodsAdapter(foods);
//        recyclerView.setAdapter(foodsAdapter);
    }

    @Override
    public void setPrensenter(FoodsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.presenter.start();
    }



    public static class MyPagerAdapter extends SmartFragmentStatePagerAdapter {
        private static int NUM_ITEMS = 2;

        public MyPagerAdapter(FragmentManager fragmentManager) {
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
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return FoodsCasesFragment.newInstance(0);
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return FoodsCasesFragment.newInstance(1);
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }
}
