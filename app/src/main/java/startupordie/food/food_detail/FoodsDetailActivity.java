package startupordie.food.food_detail;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import startupordie.food.R;
import startupordie.food.util.ActivityUtils;

public class FoodsDetailActivity extends AppCompatActivity {
    private FoodsDetailPresenter foodsDetailPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods_detail);
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

        FoodsDetailFragment foodsDetailFragment =
                (FoodsDetailFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (foodsDetailFragment == null) {
            foodsDetailFragment = FoodsDetailFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), foodsDetailFragment, R.id.contentFrame
            );
        }

        foodsDetailPresenter = new FoodsDetailPresenter(foodsDetailFragment);
    }

}
