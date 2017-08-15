package kr.ac.korea.kucc.study6.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kr.ac.korea.kucc.study6.R;
import kr.ac.korea.kucc.study6.adapter.ItemAdapter;

/**
 * Created by ffaass on 2017-08-15.
 */

public class MenuListFragment extends Fragment {

    private List<String> itemList = new ArrayList<>();
    private ItemAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_list, container, false);
        adapter = new ItemAdapter(itemList);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.menu_list);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        Button addButton = (Button) view.findViewById(R.id.button_add);
        Button resultButton = (Button) view.findViewById(R.id.button_result);
        addButton.setOnClickListener(onAddButtonClickListener);
        resultButton.setOnClickListener(onResultButtonClickListener);

        return view;
    }

    private View.OnClickListener onAddButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                Listener listener = (Listener) getActivity();
                listener.onAddButtonClick();
            } catch (ClassCastException e) {
                Toast.makeText(getActivity(),
                        "액티비티가 리스너를 구현하지 않았습니다.",
                        Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }
    };

    private View.OnClickListener onResultButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (itemList.size() == 0) {
                Toast.makeText(getActivity(), "리스트가 비어있습니다", Toast.LENGTH_LONG).show();
                return;
            }

            Random random = new Random();
            String result = itemList.get(random.nextInt(itemList.size()));

            try {
                Listener listener = (Listener) getActivity();
                listener.onResultButtonClick(result);
            } catch (ClassCastException e) {
                Toast.makeText(getActivity(),
                        "액티비티가 리스너를 구현하지 않았습니다.",
                        Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }
    };


    public void addMenu(String menu) {
        itemList.add(0, menu);
        adapter.notifyItemInserted(0);
    }

    public interface Listener {
        void onResultButtonClick(String result);
        void onAddButtonClick();
    }
}