package com.bahrani.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FunFactsActivity extends AppCompatActivity {
    public static final String TAG = FunFactsActivity.class.getSimpleName();
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    //Declare our view Varialbels
    private TextView mFactTextView;
    private Button mShowFactButton;
    private RelativeLayout mRelativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        //Assign the Views from the layout file to the corresponding variables
        mFactTextView = (TextView) findViewById(R.id.showMessage);
        mShowFactButton = (Button) findViewById(R.id.showAnotherFact);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fact =mFactBook.getFact();
                int color = mColorWheel.getColor();

                // update the string with our dynamic fact
                mRelativeLayout.setBackgroundColor(color);
                mShowFactButton.setTextColor(color);
                mFactTextView.setText(fact);


            }
        };
        mShowFactButton.setOnClickListener(listener);
        //Toast.makeText(this, "Generate new Fact", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "We are logging from the on Create Method ");
    }
}
