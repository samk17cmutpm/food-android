package startupordie.food.food;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import startupordie.food.R;
import startupordie.food.data.Food;

/**
 * Created by samnguyen on 28/04/2016.
 */
public class FoodsMostPopularAdapter extends RecyclerView.Adapter<FoodsMostPopularAdapter.ViewHolder> {
    private List<Food> foods;


    private static OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(View itemVIew, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }



    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvDistance;
        public ViewHolder(final View itemView) {
            super(itemView);
            tvDistance = (TextView) itemView.findViewById(R.id.tv_distance);

            // attach events here
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(itemView, getLayoutPosition());
                    }
                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public FoodsMostPopularAdapter(List<Food> foods) {
        this.foods = foods;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public FoodsMostPopularAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.foods_popular_card_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        holder.tvDistance.setText(foods.get(position).getName());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return foods.size();
    }
}

