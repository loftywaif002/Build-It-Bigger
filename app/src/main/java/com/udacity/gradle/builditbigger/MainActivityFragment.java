package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cmpny.wca.androidjokeslibrary.JokesActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Unbinder mUnBinder;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        mUnBinder = ButterKnife.bind(this, root);
        Button button = ButterKnife.findById(root, R.id.button_show_joke);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new EndpointsAsyncTask(new EndpointsAsyncTask.Listener() {
                    @Override
                    public void onJokeLoaded(String joke) {
                        Intent intent = new Intent(getContext(), JokesActivity.class);
                        intent.putExtra(JokesActivity.EXTRA_JOKE, joke);
                        startActivity(intent);
                    }
                }).execute();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnBinder.unbind();
    }
}
