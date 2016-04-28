package startupordie.food.restaurant;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import startupordie.food.R;
import startupordie.food.util.ActivityUtils;

public class RestaurantsActivity extends AppCompatActivity {
    private RestaurantsContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

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
