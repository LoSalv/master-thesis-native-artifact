package losalv.android.masterthesisnativeartifact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    Button cpuBtn;
    Button uiBtn;
    Button accelerometerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cpuBtn = (Button) findViewById(R.id.cpuBtn);
        cpuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCPUBtn();
            }
        });
        uiBtn = (Button) findViewById(R.id.uiBtn);
        uiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUIBtnClick();
            }
        });
        accelerometerBtn = (Button) findViewById(R.id.accelerometerBtn);
        accelerometerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAccelerometerClick();
            }
        });

    }

    public void onAccelerometerClick() {
        Intent intent = new Intent(this, AccelerometerActivity.class);
        startActivity(intent);
    }

    public void onUIBtnClick() {
        Intent intent = new Intent(this, GUIActivity.class);
        startActivity(intent);
    }

    public void onCPUBtn() {
        Intent intent = new Intent(this, CPUActivity.class);
        startActivity(intent);
    }
}