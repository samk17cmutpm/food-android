package startupordie.food.restaurant;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import startupordie.food.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment implements RestaurantsContract.View{

    private RestaurantsContract.Presenter presenter;

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    public static RestaurantsFragment newInstance() {
        return new RestaurantsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurants, container, false);
    }

    @Override
    public void showRestaurantDetail() {

    }

    @Override
    public void setPrensenter(RestaurantsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.presenter.start();
    }
}
