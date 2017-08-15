package kr.ac.korea.kucc.study6.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kr.ac.korea.kucc.study6.R;

/**
 * Created by ffaass on 2017-08-15.
 */

public class MenuInputFragment  extends Fragment {
    public static final String KEY_ITEM = "item";

    private EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_input, container, false);
        editText = (EditText) view.findViewById(R.id.edit_new_menu);


        Button submitButton = (Button) view.findViewById(R.id.button_submit);
        submitButton.setOnClickListener(onSubmitButtonClickListener);

        return view;
    }

    private View.OnClickListener onSubmitButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String result = editText.getText().toString();
            if (result.length() == 0)
                return;

            try {
                OnSubmitButtonClickListener listener = (OnSubmitButtonClickListener) getActivity();
                listener.onMenuSubmitButtonClick(result);
            } catch (ClassCastException e) {
                Toast.makeText(getActivity(),
                        "액티비티가 리스너를 구현하지 않았습니다.",
                        Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }
    };

    public interface OnSubmitButtonClickListener {
        void onMenuSubmitButtonClick(String result);
    }
}