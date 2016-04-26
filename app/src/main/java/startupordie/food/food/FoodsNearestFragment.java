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
public class FoodsNearestFragment extends Fragment implements FoodsContract.FoodsNearestView{

    private FoodsContract.FoodsNearestBasePresenter presenter;

    public FoodsNearestFragment() {
        // Required empty public constructor
    }

    public static FoodsNearestFragment newInstance() {
        return new FoodsNearestFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_foods_nearest, container, false);
    }

    @Override
    public void showData(List<Food> foods) {

    }

    @Override
    public void setPrensenter(FoodsContract.FoodsNearestBasePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.presenter.start();
    }
}
