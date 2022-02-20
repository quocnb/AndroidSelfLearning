package com.quocnb.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class MyAsyncTask extends AsyncTask<Void, Void, String>  {
    private WeakReference<TextView> mTextView;
    MyAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }
    @Override
    protected String doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11);

        int s = n * 200;
        try {
            Thread.sleep(s / 2);
            publishProgress();
            Thread.sleep(s / 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    @Override
    protected void onPostExecute(String s) {
        mTextView.get().setText(s);

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        mTextView.get().setText("Still napping...");
    }
}
