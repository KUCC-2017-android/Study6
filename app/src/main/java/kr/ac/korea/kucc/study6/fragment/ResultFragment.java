package kr.ac.korea.kucc.study6.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.ac.korea.kucc.study6.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {
    public static final String KEY_MENU = "menu";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        TextView resultView = (TextView) view.findViewById(R.id.text_result);
        String result = getArguments().getString(KEY_MENU, "");
        resultView.setText(result);


        return view;
    }

}
