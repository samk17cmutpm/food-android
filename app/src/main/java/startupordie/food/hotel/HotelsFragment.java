package startupordie.food.hotel;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import startupordie.food.R;
import startupordie.food.data.Hotel;


public class HotelsFragment extends Fragment implements HotelsContract.View{
    private HotelsContract.Presenter presenter;
    public HotelsFragment() {
        // Required empty public constructor
    }
    public static HotelsFragment newInstance() {
        return new HotelsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hotels, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        this.presenter.start();
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showHotels(List<Hotel> hotels) {

    }

    @Override
    public void setPrensenter(HotelsContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
