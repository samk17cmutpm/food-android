package startupordie.food.food_popular;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import startupordie.food.R;
import startupordie.food.data.Restaurant;


public class FoodsPopularFragment extends Fragment implements FoodsPopularContract.View{
    private FoodsPopularContract.Presenter presenter;
    public FoodsPopularFragment() {
        // Required empty public constructor
    }

    public static FoodsPopularFragment newInstance() {
        FoodsPopularFragment fragment = new FoodsPopularFragment();
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
        return inflater.inflate(R.layout.fragment_foods_popular, container, false);
    }

    @Override
    public void showRestaurants(List<Restaurant> restaurants) {

    }

    @Override
    public void setPrensenter(FoodsPopularContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
