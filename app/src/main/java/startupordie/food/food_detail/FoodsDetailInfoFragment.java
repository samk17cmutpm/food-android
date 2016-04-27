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
public class FoodsDetailInfoFragment extends Fragment
        implements FoodsDetailsContract.FoodsDetailInfoView{

    private FoodsDetailsContract.FoodsDetailInfoBasePresenter presenter;
    public FoodsDetailInfoFragment() {
        // Required empty public constructor
    }

    public static FoodsDetailInfoFragment newInstance() {
        FoodsDetailInfoFragment foodsDetailInfoFragment = new
                FoodsDetailInfoFragment();
        return foodsDetailInfoFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_foods_detail_info, container, false);
    }

    @Override
    public void showDetail() {

    }

    @Override
    public void setPrensenter(FoodsDetailsContract.FoodsDetailInfoBasePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.presenter.start();
    }

}
