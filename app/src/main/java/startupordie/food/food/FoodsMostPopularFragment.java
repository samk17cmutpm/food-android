package startupordie.food.food;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import startupordie.food.food_detail.FoodsDetailActivity;


public class FoodsMostPopularFragment extends Fragment
        implements FoodsContract.FoodsMostPopularView {

    private FoodsContract.FoodsMostPopularBasePresenter presenter;
    private RecyclerView recyclerView;
    private FoodsAdapter foodsAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private View root;
    private final String TAG = "FoodsMostPopularFragment";
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
    public void showData(final List<Food> foods) {
        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        foodsAdapter = new FoodsAdapter(foods);
        recyclerView.setAdapter(foodsAdapter);
        // attach event for each item in recycleview
        foodsAdapter.setOnItemClickListener(new FoodsAdapter.OnItemClickListener() {

            @SuppressLint("LongLogTag")
            @Override
            public void onItemClick(View itemVIew, int position) {
                presenter.loadFoodsDetail(foods.get(position));
            }
        });


    }

    @Override
    public void showFoodsDetail(Food food) {
        Intent intent = new Intent(getContext(), FoodsDetailActivity.class);
        startActivity(intent);
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
