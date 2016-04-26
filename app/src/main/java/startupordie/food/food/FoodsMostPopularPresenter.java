package startupordie.food.food;

/**
 * Created by samnguyen on 26/04/2016.
 */
public class FoodsMostPopularPresenter implements  FoodsContract.FoodsMostPopularBasePresenter{

    private final FoodsContract.FoodsMostPopularView foodsMostPopularView;

    public FoodsMostPopularPresenter(FoodsContract.FoodsMostPopularView foodsMostPopularView) {
        this.foodsMostPopularView = foodsMostPopularView;
        this.foodsMostPopularView.setPrensenter(this);
    }

    @Override
    public void loadFoodsMostPopularData() {
        foodsMostPopularView.showData(null);

    }

    @Override
    public void start() {

    }
}
