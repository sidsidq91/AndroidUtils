package personal.com.sample.Utils;

import android.os.AsyncTask;

public class MyAsyncTask extends AsyncTask<String,String,String> {

    @Override
    protected void onPreExecute() {
        // Access to ui
        // gets Executed before running the task
    }

    @Override
    protected String doInBackground(String... strings) {
        publishProgress("progress");
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        // Access to ui
        // gets Executed after running the task
    }

    @Override
    protected void onProgressUpdate(String... values) {
        // update ui elements of progress
    }
}
