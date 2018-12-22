package com.apps.adam.tapcounter;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity
{
    //Instance of our ViewModel subclass
    CounterViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Connects ViewModel subclass to the Activity
        mViewModel = ViewModelProviders.of(this).get(CounterViewModel.class);
        displayCounter(mViewModel.currentCounter);
    }

    //Increments counter by 1, used in onClick property of btn1
    public void incrementCounter(View v)
    {
        mViewModel.currentCounter = mViewModel.currentCounter + 1;
        displayCounter(mViewModel.currentCounter);
    }

    //Displays current counter value
    public void displayCounter(int count)
    {
        TextView counterView = (TextView) findViewById(R.id.display);
        counterView.setText(String.valueOf(count));
    }

    //Sets counter back to 0, used in onClick property of btn2
    public void resetCounter(View v)
    {
        mViewModel.currentCounter = 0;
        displayCounter(mViewModel.currentCounter);
    }


}
