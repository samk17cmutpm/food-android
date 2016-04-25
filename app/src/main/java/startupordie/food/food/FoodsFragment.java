package startupordie.food.food;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    private RecyclerView recyclerView;
    private RecyclerView.Adapter foodsAdapter;
    private RecyclerView.LayoutManager layoutManager;


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
        View root = inflater.inflate(R.layout.fragment_foods, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        presenter.loadFoods(true);
        return root;
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        Log.d("====>", "====>");

    }

    @Override
    public void showFoods(List<Food> foods) {
        foodsAdapter = new FoodsAdapter(foods);
        recyclerView.setAdapter(foodsAdapter);
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
