package cn.iwgang.countdownviewdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import cn.iwgang.countdownview.CountupView;

public class MainActivity extends AppCompatActivity implements CountupView.OnCountdownEndListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountupView mCvCountupViewTest1 = (CountupView)findViewById(R.id.cv_CountupViewTest1);
        mCvCountupViewTest1.setTag("test1");
        long time1 = (long)5 * 60 * 60 * 1000;
        mCvCountupViewTest1.start(time1);

        CountupView mCvCountupViewTest2 = (CountupView)findViewById(R.id.cv_CountupViewTest2);
        mCvCountupViewTest1.setTag("test2");
        long time2 = (long)30 * 60 * 1000;
        mCvCountupViewTest2.start(time2);

        CountupView mCvCountupViewTest3 = (CountupView)findViewById(R.id.cv_CountupViewTest3);
        long time3 = (long)9 * 60 * 60 * 1000;
        mCvCountupViewTest3.start(time3);

        CountupView mCvCountupViewTest4 = (CountupView)findViewById(R.id.cv_CountupViewTest4);
        long time4 = (long)150 * 24 * 60 * 60 * 1000;
        mCvCountupViewTest4.start(time4);


        CountupView mCvCountupViewTest6 = (CountupView)findViewById(R.id.cv_CountupViewTest6);
        long time6 = (long)2 * 60 * 60 * 1000;
        mCvCountupViewTest6.start(time6);

    }

    @Override
    public void onEnd(CountupView cv) {
        Object tag = cv.getTag();
        if (null != tag) {
            Log.i("wg", "tag = " + tag.toString());
        }
    }
}


