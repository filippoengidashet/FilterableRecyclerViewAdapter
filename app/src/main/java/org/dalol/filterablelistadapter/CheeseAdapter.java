package org.dalol.filterablelistadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 4/24/2016
 */
public class CheeseAdapter extends RecyclerView.Adapter<CheeseAdapter.Holder> {

    private final LayoutInflater mInflater;
    private List<String> mDefaultCheeses;
    private List<String> mFilteredCheeses;

    public CheeseAdapter(LayoutInflater inflater) {
        mInflater = inflater;
        mDefaultCheeses = Arrays.asList(Cheeses.sCheeseStrings);
        mFilteredCheeses = mDefaultCheeses;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(mInflater.inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        View itemView = holder.itemView;
        TextView title = (TextView) itemView.findViewById(R.id.cheeseName);
        title.setText(mFilteredCheeses.get(position));
    }

    @Override
    public int getItemCount() {
        return mFilteredCheeses.size();
    }

    public void filter(String query) {
        mFilteredCheeses = new ArrayList<>();
        for (String cheese : mDefaultCheeses) {
            if(cheese.toLowerCase().contains(query.toLowerCase())) {
                mFilteredCheeses.add(cheese);
            }
        }
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public Holder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), mFilteredCheeses.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }
    }
}
