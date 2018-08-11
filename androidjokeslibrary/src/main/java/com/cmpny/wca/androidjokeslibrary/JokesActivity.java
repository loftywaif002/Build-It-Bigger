package com.cmpny.wca.androidjokeslibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JokesActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "EXTRA_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        if (getIntent() != null && getIntent().hasExtra(EXTRA_JOKE)) {
            TextView jokeTextView = ButterKnife.findById(this, R.id.text_view_joke);
            jokeTextView.setText(getIntent().getStringExtra(EXTRA_JOKE));
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case (android.R.id.home):
            default:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
