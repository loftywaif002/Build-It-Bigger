package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.opengl.Visibility;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import butterknife.BindView;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    @SuppressWarnings("unused")
    public static String LOG_TAG = EndpointsAsyncTask.class.getSimpleName();
    private final Listener mListener;
    private static MyApi myApiService = null;



    /**
     * Interface definition for a callback to be invoked when reviews are loaded.
     */
    interface Listener {
        void onJokeLoaded(String joke);
    }

    public EndpointsAsyncTask(Listener listener) {
        mListener = listener;
    }


    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?>
                                                       abstractGoogleClientRequest)
                                throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        try {
            return myApiService.getRandomJoke().execute().getData();
        } catch (IOException e) {
            Log.e(LOG_TAG, e.getMessage(), e);
            return "";
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        mListener.onJokeLoaded(joke);
    }
}