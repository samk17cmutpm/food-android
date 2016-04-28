package startupordie.food.restaurant;

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
    public void start() {

    }
}
