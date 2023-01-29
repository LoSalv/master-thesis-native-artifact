package losalv.android.masterthesisnativeartifact;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CPUActivity extends AppCompatActivity {

    private static final String LOG_TAG = CPUActivity.class.getSimpleName();
    TextView textView;

    void runTask() {
        Log.d(LOG_TAG, "Started task");
        Date startDate = new Date();

        Double result = 0d;

        for (double i = Math.pow(20, 7); i >= 0; i--) {
            result += Math.atan(i) * Math.tan(i);
        }

        Date endDate = new Date();
        Long difference = endDate.getTime() - startDate.getTime();
        Log.d(LOG_TAG, "End");
        String text = "Duration in ms: " + String.valueOf(difference) + "\nResult: " + String.valueOf(result);
        textView.setText(text);
    }

    public void runTaskBtn(View view) {
        runTask();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate");
        setContentView(R.layout.activity_cpu);
        textView = findViewById(R.id.textView);
    }

}
