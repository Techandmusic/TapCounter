package com.apps.adam.tapcounter;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity
{
    CounterViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewModel = ViewModelProviders.of(this).get(CounterViewModel.class);
        displayCounter(mViewModel.currentCounter);
    }

    public void incrementCounter(View v)
    {
        mViewModel.currentCounter = mViewModel.currentCounter + 1;
        displayCounter(mViewModel.currentCounter);
    }

    public void displayCounter(int count)
    {
        TextView counterView = (TextView) findViewById(R.id.display);
        counterView.setText(String.valueOf(count));
    }

    public void resetCounter(View v)
    {
        mViewModel.currentCounter = 0;
        displayCounter(mViewModel.currentCounter);
    }


}
