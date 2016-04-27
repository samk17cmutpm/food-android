package startupordie.food.food;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import startupordie.food.R;
import startupordie.food.data.Food;


public class FoodsMostPopularFragment extends Fragment
        implements FoodsContract.FoodsMostPopularView{

    private FoodsContract.FoodsMostPopularBasePresenter presenter;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter foodsAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private View root;
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
        root = inflater.inflate(R.layout.fragment_foods_most_popular, container, false);
        presenter.loadFoodsMostPopularData();
        return root;
    }


    @Override
    public void showData(List<Food> foods) {
        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        foodsAdapter = new FoodsAdapter(foods);
        recyclerView.setAdapter(foodsAdapter);
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
