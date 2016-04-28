package startupordie.food.restaurant;

import android.os.Bundle;
import startupordie.food.BaseActivity;
import startupordie.food.R;
import startupordie.food.util.ActivityUtils;

public class RestaurantsActivity extends BaseActivity {
    private RestaurantsContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        RestaurantsFragment restaurantsFragment =
                (RestaurantsFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (restaurantsFragment == null) {
            restaurantsFragment = RestaurantsFragment.newInstance();

            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), restaurantsFragment, R.id.contentFrame
            );
        }
        presenter = new RestaurantsPresenter(restaurantsFragment);

    }
}
