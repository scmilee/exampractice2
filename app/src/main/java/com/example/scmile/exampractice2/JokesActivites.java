package com.example.scmile.exampractice2;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class JokesActivites extends SingleFragmentActivity {
    private static final String EXTRA_CRIME_ID =
            "com.example.scmile.criminalintent.crime_id";
    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent intent = new Intent(packageContext, JokesActivites.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }
    @Override
    protected Fragment createFragment() {
        UUID crimeId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_CRIME_ID);
        return JokeFragment.newInstance(crimeId);    }
}
