package startupordie.food.food;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import startupordie.food.R;
import startupordie.food.data.Food;


public class FoodsMostPopularFragment extends Fragment
        implements FoodsContract.FoodsMostPopularView{


    private FoodsContract.FoodsMostPopularBasePresenter presenter;
    public FoodsMostPopularFragment() {
        // Required empty public constructor
    }

    public static FoodsMostPopularFragment newInstance() {
        FoodsMostPopularFragment fragment = new FoodsMostPopularFragment();
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
        presenter.loadFoodsMostPopularData();
        return inflater.inflate(R.layout.fragment_foods_most_popular, container, false);
    }


    @Override
    public void showData(List<Food> foods) {

    }

    @Override
    public void setPrensenter(FoodsContract.FoodsMostPopularBasePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.presenter.start();
    }
}
