package startupordie.food.food;


import android.annotation.SuppressLint;
import android.content.Intent;
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
import startupordie.food.food_detail.FoodsDetailActivity;
import startupordie.food.food_popular.FoodsPopularActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodsNearestFragment extends Fragment implements FoodsContract.FoodsNearestView{

    private FoodsContract.FoodsNearestBasePresenter presenter;
    private RecyclerView recyclerView;
    private View root;
    private FoodsNearestAdapter foodsNearestAdapter;
    private RecyclerView.LayoutManager layoutManager;
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
        root = inflater.inflate(R.layout.fragment_foods_nearest, container, false);
        presenter.loadFoodsNearest();
        return root;
    }

    @Override
    public void showData(final List<Food> foods) {
        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        foodsNearestAdapter = new FoodsNearestAdapter(foods);
        recyclerView.setAdapter(foodsNearestAdapter);
        // attach event for each item in recycleview
        foodsNearestAdapter.setOnItemClickListener(new FoodsNearestAdapter.OnItemClickListener() {

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
    public void setPrensenter(FoodsContract.FoodsNearestBasePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.presenter.start();
    }
}
