package startupordie.food.food_popular;

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
import startupordie.food.data.Restaurant;
import startupordie.food.restaurant.RestaurantsActivity;


public class FoodsPopularFragment extends Fragment implements FoodsPopularContract.View{
    private FoodsPopularContract.Presenter presenter;
    private RecyclerView recyclerView;
    private FoodsPopularAdapter foodsPopularAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private View root;
    private final String TAG = "FoodsPopularFragment";
    public FoodsPopularFragment() {
        // Required empty public constructor
    }

    public static FoodsPopularFragment newInstance() {
        FoodsPopularFragment fragment = new FoodsPopularFragment();
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
        root = inflater.inflate(R.layout.fragment_foods_popular, container, false);
        presenter.loadRestaurants();
        return root;
    }

    @Override
    public void showRestaurants(final List<Restaurant> restaurants) {
        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        foodsPopularAdapter = new FoodsPopularAdapter(restaurants);
        recyclerView.setAdapter(foodsPopularAdapter);
        foodsPopularAdapter.setOnItemClickListener(new FoodsPopularAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemVIew, int position) {
                presenter.loadRestaurantDetail(restaurants.get(position));
            }
        });
    }

    @Override
    public void showRestaurantDetail(Restaurant restaurant) {
        Intent intent = new Intent(getContext(), RestaurantsActivity.class);
        startActivity(intent);
    }

    @Override
    public void setPrensenter(FoodsPopularContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.presenter.start();
    }
}
