package startupordie.food.food;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import startupordie.food.R;
import startupordie.food.data.Food;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodsFragment extends Fragment implements FoodsContract.View{

    private FoodsContract.Presenter presenter;

    private FoodsViewModel foodsViewModel;

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
        return inflater.inflate(R.layout.fragment_foods, container, false);
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showFoods(List<Food> foods) {

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
