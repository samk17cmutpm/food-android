package startupordie.food.restaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import startupordie.food.R;
import startupordie.food.data.FoodsRestaurant;

/**
 * Created by samnguyen on 28/04/2016.
 */
public class RestaurantsFoodAdapter extends ArrayAdapter<FoodsRestaurant> {

    private static class ViewHolder {
        TextView tv_distance;
    }

    public RestaurantsFoodAdapter(Context context, ArrayList<FoodsRestaurant> foodsRestaurants) {
        super(context, R.layout.foods_restaurant_card_view, foodsRestaurants);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        FoodsRestaurant foodsRestaurant = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.foods_restaurant_card_view, parent, false);
            viewHolder.tv_distance = (TextView) convertView.findViewById(R.id.tv_distance);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
//        viewHolder.tv_distance.setText("");
        // Return the completed view to render on screen
        return convertView;
    }
}
