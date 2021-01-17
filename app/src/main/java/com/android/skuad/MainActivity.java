package com.android.skuad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchFragment(
                ProductFragment.newInstance("")
                , ProductFragment.class.getSimpleName(),
                false);
    }

    protected void launchFragment(Fragment fragment, String tag, boolean shouldAddToBackStack) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment oldFragment = fm.findFragmentByTag(tag);
        if (oldFragment != null) {
            ft.remove(oldFragment);
        }
        ft.replace(R.id.container, fragment, tag);
        if (shouldAddToBackStack) ft.addToBackStack(null);
        ft.commitAllowingStateLoss();
    }
}
