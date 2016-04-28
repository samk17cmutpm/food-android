package startupordie.food.restaurant;

import java.util.ArrayList;

import startupordie.food.data.FoodsRestaurant;

/**
 * Created by samnguyen on 28/04/2016.
 */
public class RestaurantsPresenter implements RestaurantsContract.Presenter{
    private final RestaurantsContract.View restaurantView;
    public RestaurantsPresenter(RestaurantsContract.View restaurantscView) {
        this.restaurantView = restaurantscView;
        this.restaurantView.setPrensenter(this);
    }
    @Override
    public void loadRestaurantDetail() {

    }

    @Override
    public void loadFoodsOfRestaurant() {
        ArrayList<FoodsRestaurant> foodsRestaurant = new ArrayList();
        for (int i = 0; i < 10; i++) {
            foodsRestaurant.add(new FoodsRestaurant("name" + i));
        }
        restaurantView.showFoodsOfRestaurant(foodsRestaurant);
    }

    @Override
    public void start() {

    }
}
