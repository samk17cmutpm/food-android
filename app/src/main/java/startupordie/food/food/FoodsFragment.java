package startupordie.food.food;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import java.util.List;

import startupordie.food.R;
import startupordie.food.data.Food;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodsFragment extends Fragment implements FoodsContract.View{

    private FoodsContract.Presenter presenter;

    private FoodsViewModel foodsViewModel;

    private View root;

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
        root = inflater.inflate(R.layout.fragment_foods, container, false);
//        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
//        recyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(layoutManager);
        presenter.loadViewPager();
        return root;
    }
    @Override
    public void showViewPager() {
//        foodsAdapter = new FoodsNearestAdapter(foods);
//        recyclerView.setAdapter(foodsAdapter);
        ViewPager viewPager = (ViewPager) root.findViewById(R.id.viewpager);
        viewPager.setAdapter(new FoodsPagerAdapter(getFragmentManager()));

        // Give the PagerSlidingTabStrip the ViewPager
        PagerSlidingTabStrip tabsStrip = (PagerSlidingTabStrip) root.findViewById(R.id.tabs);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);
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
}
