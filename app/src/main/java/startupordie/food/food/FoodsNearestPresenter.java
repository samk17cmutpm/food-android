package startupordie.food.food;

/**
 * Created by samnguyen on 26/04/2016.
 */
public class FoodsNearestPresenter implements FoodsContract.FoodsNearestBasePresenter {
    private final FoodsContract.FoodsNearestView foodsNearestView;

    public FoodsNearestPresenter(FoodsContract.FoodsNearestView foodsMostPopularView) {
        this.foodsNearestView = foodsMostPopularView;
        this.foodsNearestView.setPrensenter(this);
    }
    @Override
    public void loadFoodsNearest() {
        foodsNearestView.showData(null);
    }

    @Override
    public void start() {

    }
}
