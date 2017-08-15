package kr.ac.korea.kucc.study6.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import kr.ac.korea.kucc.study6.R;

/**
 * Created by ffaass on 2017-08-10.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.StoreViewHolder> {
    private List<String> storeList;

    public ItemAdapter(List<String> storeList) {
        this.storeList = storeList;
    }

    @Override
    public StoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_menu, parent, false);
        return new StoreViewHolder(v);
    }

    @Override
    public void onBindViewHolder(StoreViewHolder holder, int position) {
        holder.textView.setText(storeList.get(position));
    }

    @Override
    public int getItemCount() {
        return storeList.size();
    }

    class StoreViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public StoreViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }
}
