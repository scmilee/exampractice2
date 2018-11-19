package com.example.scmile.exampractice2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;
import java.util.UUID;

public class JokeFragment extends Fragment {
    private static final String DIALOG_DATE = "DialogDate";
    private static final String ARG_Joke_ID = "Joke_id";

    private static final int REQUEST_DATE = 0;

    private Joke mJoke;
    private TextView mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    public static JokeFragment newInstance(UUID JokeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_Joke_ID, JokeId);
        JokeFragment fragment = new JokeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID JokeId = (UUID) getArguments().getSerializable(ARG_Joke_ID);
        //mJoke = JokeListFragment.get(getActivity()).getmJoke(JokeId);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_fragment, container, false);
        mTitleField =  v.findViewById(R.id.joke_title);

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

}
