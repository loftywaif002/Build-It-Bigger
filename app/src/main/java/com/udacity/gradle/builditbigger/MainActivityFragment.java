package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cmpny.wca.androidjokeslibrary.JokesActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Unbinder mUnBinder;

    public MainActivityFragment() {
    }

    /*Butterknife View Injection Here */
    @BindView( R.id.button_show_joke) Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        mUnBinder = ButterKnife.bind(this, root);
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
