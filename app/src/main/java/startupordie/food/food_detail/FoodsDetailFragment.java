package startupordie.food.food_detail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import startupordie.food.R;
import startupordie.food.food.FoodsPagerAdapter;

public class FoodsDetailFragment extends Fragment implements FoodsDetailsContract.View{
    private FoodsDetailsContract.Presenter presenter;
    private View root;
    public FoodsDetailFragment() {
        // Required empty public constructor
    }

    public static FoodsDetailFragment newInstance() {
        FoodsDetailFragment fragment = new FoodsDetailFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_foods_detail, container, false);
        presenter.loadViewPager();
        return root;
    }

    @Override
    public void showViewPager() {
        ViewPager viewPager = (ViewPager) root.findViewById(R.id.viewpager);
        viewPager.setAdapter(new FoodsDetailPagerAdapter(getFragmentManager()));

        // Give the PagerSlidingTabStrip the ViewPager
        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) root.findViewById(R.id.tabs);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);
    }

    @Override
    public void setPrensenter(FoodsDetailsContract.Presenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void onResume() {
        super.onResume();
        this.presenter.start();
    }
}
