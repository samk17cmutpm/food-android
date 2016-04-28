package startupordie.food.food_popular;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import startupordie.food.R;
import startupordie.food.util.ActivityUtils;

public class FoodsPopularActivity extends AppCompatActivity {
    private FoodsPopularContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods_popular);
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

        FoodsPopularFragment foodsPopularFragment =
                (FoodsPopularFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (foodsPopularFragment == null) {
            foodsPopularFragment = FoodsPopularFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), foodsPopularFragment, R.id.contentFrame
            );
        }
        presenter = new FoodsPopularPresenter(foodsPopularFragment);
    }

}
