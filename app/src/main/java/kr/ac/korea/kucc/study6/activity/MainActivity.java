package kr.ac.korea.kucc.study6.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import kr.ac.korea.kucc.study6.R;
import kr.ac.korea.kucc.study6.fragment.MenuInputFragment;
import kr.ac.korea.kucc.study6.fragment.MenuListFragment;
import kr.ac.korea.kucc.study6.fragment.ResultFragment;

public class MainActivity extends AppCompatActivity
    implements MenuInputFragment.OnSubmitButtonClickListener,
        MenuListFragment.Listener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        MenuListFragment menuListFragment = new MenuListFragment();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.content_panel, menuListFragment, getString(R.string.menulistfragment));
        transaction.commit();
    }

    @Override
    public void onMenuSubmitButtonClick(String result) {
        FragmentManager fm = getSupportFragmentManager();
        MenuListFragment menuListFragment =
                (MenuListFragment) fm.findFragmentByTag(getString(R.string.menulistfragment));
        menuListFragment.addMenu(result);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.content_panel, menuListFragment);
        transaction.commit();
    }

    @Override
    public void onResultButtonClick(String result) {

        FragmentManager fm = getSupportFragmentManager();
        ResultFragment resultFragment = new ResultFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ResultFragment.KEY_MENU, result);
        resultFragment.setArguments(bundle);

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.content_panel, resultFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onAddButtonClick() {
        FragmentManager fm = getSupportFragmentManager();

        MenuInputFragment inputFragment = new MenuInputFragment();

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.content_panel, inputFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
