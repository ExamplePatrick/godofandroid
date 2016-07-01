package com.example.asynctask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountAsyncTask asyncTask = new CountAsyncTask();
        asyncTask.execute(1);
    }

    private class CountAsyncTask extends AsyncTask<Integer, Integer, Integer> {

        private ProgressDialog mProgressDlg = null;
        private TextView thistxt = null;


        @Override
        protected void onPreExecute(){

            thistxt = (TextView)MainActivity.this.findViewById(R.id.thistxt);
            mProgressDlg = new ProgressDialog(MainActivity.this);
            mProgressDlg.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDlg.setMessage("sum = 0");
            mProgressDlg.setMax(100);
            mProgressDlg.show();
        }

        @Override
        protected Integer doInBackground(Integer... params){
            int i = params[0];
            int sum = 0;

            while( i< 3){
                i++;
                sum += i;

                this.publishProgress(i, sum);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
            }
            return sum;
        }

        @Override
        protected void onProgressUpdate(Integer... values){

            mProgressDlg.setMessage("i = " + values[0] + "sum = " +
            values[1]);
            mProgressDlg.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Integer result){
            mProgressDlg.dismiss();
            thistxt.setText("it works!");
        }
    }

}



