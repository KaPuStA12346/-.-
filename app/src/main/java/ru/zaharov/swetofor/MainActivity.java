package ru.zaharov.swetofor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout b_1;
    private LinearLayout b_2, b_3;
    private Button btn;
    private Boolean  isStarted = false;
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_1 = findViewById(R.id.bulb_1);
        b_2 = findViewById(R.id.bulb_2);
        b_3 = findViewById(R.id.bulb_3);
        btn = findViewById(R.id.BTN1);
    }

    public void onClickStart(View view) {
        if (!isStarted) {
            isStarted = true;
            btn.setText("STOP");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (isStarted) {
                        counter++;
                        switch (counter) {
                            case 1:
                                b_1.setBackgroundColor(getResources().getColor(R.color.green));
                                b_2.setBackgroundColor(getResources().getColor(R.color.gray));
                                b_3.setBackgroundColor(getResources().getColor(R.color.gray));
                                break;
                            case 2:
                                b_1.setBackgroundColor(getResources().getColor(R.color.gray));
                                b_2.setBackgroundColor(getResources().getColor(R.color.yellow));
                                b_3.setBackgroundColor(getResources().getColor(R.color.gray));
                                break;
                                case 3:
                                    b_1.setBackgroundColor(getResources().getColor(R.color.gray));
                                    b_2.setBackgroundColor(getResources().getColor(R.color.gray));
                                    b_3.setBackgroundColor(getResources().getColor(R.color.red));
                            counter= 0;
                            break;
                        }
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }).start();
        } else{
            isStarted = false;
            btn.setText("START");
            b_1.setBackgroundColor(getResources().getColor(R.color.gray));
            b_2.setBackgroundColor(getResources().getColor(R.color.gray));
            b_3.setBackgroundColor(getResources().getColor(R.color.gray));
            counter= 0;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isStarted= false;
    }
}
