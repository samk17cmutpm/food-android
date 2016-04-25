package startupordie.food.food;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import startupordie.food.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodsCasesFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    public FoodsCasesFragment() {
        // Required empty public constructor
    }

    public static FoodsCasesFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FoodsCasesFragment fragment = new FoodsCasesFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_foods_cases, container, false);
        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        tvTitle.setText("Fragment #" + mPage);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }
}
