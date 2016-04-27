package startupordie.food.food_detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import startupordie.food.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodsDetailMapFragment extends Fragment
        implements FoodsDetailsContract.FoodsDetailMapView{
    private FoodsDetailsContract.FoodsDetailMapBasePresenter presenter;
    private View root;
    public FoodsDetailMapFragment() {
        // Required empty public constructor
    }

    public static FoodsDetailMapFragment newInstance() {
        FoodsDetailMapFragment foodsDetailMapFragment = new FoodsDetailMapFragment();
        return foodsDetailMapFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_foods_detail_map, container, false);
        return root;
    }

    @Override
    public void showMap() {

    }

    @Override
    public void setPrensenter(FoodsDetailsContract.FoodsDetailMapBasePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.presenter.start();
    }
}
