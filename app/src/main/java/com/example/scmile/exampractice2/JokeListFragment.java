package com.example.scmile.exampractice2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class JokeListFragment extends Fragment {
    public ArrayList<Joke> jokes;
    public int completedCount;
    public int jokeCount;
    private RecyclerView jokeRecycler;
    private JokeAdapter jokeAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        jokes = new ArrayList<>();
        ArrayList<String> lines = new ArrayList<>();
        lines.add("lol");
        lines.add("lmao");

        Joke newJoke = new Joke(lines);
        jokes.add(newJoke);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        jokeRecycler = (RecyclerView) view
                .findViewById(R.id.recyclerView);
        jokeRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));


        updateUI();
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
    private void updateUI() {
        if (jokeAdapter == null) {
            jokeAdapter = new JokeAdapter(jokes);
            jokeRecycler.setAdapter(jokeAdapter);
        } else {
            jokeAdapter.notifyDataSetChanged();
        }
    }

    public ArrayList<Joke> getJokes() {
        return jokes;
    }

    private class JokeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleTextView;
        private Joke joke;

        public JokeHolder (LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_joke, parent, false));
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.findViewById(R.id.joke_title);
        }
        public void bind(Joke joke) {
            joke = joke;
            mTitleTextView.setText(joke.getTitle());
        }
        @Override
        public void onClick(View view) {
//            Intent intent = CrimePagerActivity.newIntent(getActivity(), joke.getId());
//            startActivity(intent);
        }
    }

    private class JokeAdapter extends RecyclerView.Adapter<JokeHolder> {
        private List<Joke> jokes;

        public JokeAdapter(List<Joke> mjokes) {
            jokes = mjokes;
        }

        @Override
        public JokeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new JokeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(JokeHolder holder, int position) {
            Joke joke = jokes.get(position);
            holder.bind(joke);
        }

        @Override
        public int getItemCount() {
            return jokes.size();
        }

        public void setCrimes(List<Joke> mjokes) {
            jokes = mjokes;
        }
    }
}

