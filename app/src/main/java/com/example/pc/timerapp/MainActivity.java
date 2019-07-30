package com.example.pc.timerapp;

import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private int value;
    private FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout=findViewById(R.id.framelayout);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

    }

    public void buttonPressed(View view) {
        String s = editText.getText().toString();
        if (s.isEmpty()) {
            Snackbar.make(frameLayout,"Field can't be empty",Snackbar.LENGTH_LONG).show();
        } else {
            value = Integer.parseInt(s);
            final Handler handler = new Handler();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (value > 0) {
                        value--;
                        editText.setText(value + "s");
                        button.setText("STARTED");
                        handler.postDelayed(this, 1000);

                    } else  {
                        Toast.makeText(MainActivity.this, "Timer Completed", Toast.LENGTH_LONG).show();
                        button.setText("START");
                        editText.setText("");
                    }
                }

            });
        }
    }
}

