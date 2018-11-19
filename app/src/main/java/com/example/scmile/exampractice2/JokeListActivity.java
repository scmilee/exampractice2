package com.example.scmile.exampractice2;

import android.support.v4.app.Fragment;

import com.example.scmile.exampractice2.JokeListFragment;
import com.example.scmile.exampractice2.SingleFragmentActivity;

public class JokeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new JokeListFragment();
    }
}