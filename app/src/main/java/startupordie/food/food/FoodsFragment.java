package startupordie.food.food;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ksoichiro.android.observablescrollview.CacheFragmentStatePagerAdapter;
import com.github.ksoichiro.android.observablescrollview.ObservableListView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

import java.util.List;

import startupordie.food.BaseFragment;
import startupordie.food.R;
import startupordie.food.data.Food;
import startupordie.food.lib.SlidingTabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodsFragment extends BaseFragment implements FoodsContract.View{

    private FoodsContract.Presenter presenter;

    private FoodsViewModel foodsViewModel;
    private View root;
//    private ViewPager mPager;
//    private NavigationAdapter mPagerAdapter;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter foodsAdapter;
    private RecyclerView.LayoutManager layoutManager;


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
        root = inflater.inflate(R.layout.fragment_foods, container, false);
//        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
//        recyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(layoutManager);
        presenter.loadViewPager();
////        getContext().setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
//        mPagerAdapter = new NavigationAdapter(getActivity().getSupportFragmentManager());
//        mPager = (ViewPager) root.findViewById(R.id.pager);
//        mPager.setAdapter(mPagerAdapter);


        // When the page is selected, other fragments' scrollY should be adjusted
        // according to the toolbar status(shown/hidden)
        return root;
    }
    @Override
    public void showViewPager() {
//        foodsAdapter = new FoodsNearestAdapter(foods);
//        recyclerView.setAdapter(foodsAdapter);
        ViewPager viewPager = (ViewPager) root.findViewById(R.id.viewpager);
        viewPager.setAdapter(new FoodsPagerAdapter(getFragmentManager()));

//        // Give the PagerSlidingTabStrip the ViewPager
//        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) root.findViewById(R.id.tabs);
//        // Attach the view pager to the tab strip
//        tabsStrip.setViewPager(viewPager);

        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) root.findViewById(R.id.sliding_tabs);
        slidingTabLayout.setCustomTabView(R.layout.tab_indicator, android.R.id.text1);
        slidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.accent));
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(viewPager);
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


    private static class NavigationAdapter extends CacheFragmentStatePagerAdapter {

        private static final String[] TITLES = new String[]{"Applepie", "Butter Cookie"};

        private int mScrollY;

        public NavigationAdapter(FragmentManager fm) {
            super(fm);
        }

        public void setScrollY(int scrollY) {
            mScrollY = scrollY;
        }

        @Override
        protected Fragment createItem(int position) {
            Fragment f = new ViewPagerTabListViewFragment();
            if (0 < mScrollY) {
                Bundle args = new Bundle();
                args.putInt(ViewPagerTabListViewFragment.ARG_INITIAL_POSITION, 1);
                f.setArguments(args);
            }
            return f;
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }
    }

}
