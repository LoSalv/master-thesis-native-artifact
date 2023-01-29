package losalv.android.masterthesisnativeartifact;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AccelerometerActivity extends AppCompatActivity {

    private static final String LOG_TAG = AccelerometerActivity.class.getSimpleName();
    private SensorManager sensorManager;

    TextView averageText;
    TextView minText;
    TextView maxText;
    TextView accelerometerValuesText;

    ArrayList<Long> durations = new ArrayList<Long>();
    long time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        averageText = findViewById(R.id.averageText);
//        minText = findViewById(R.id.minText);
//        maxText= findViewById(R.id.maxText);
        accelerometerValuesText = findViewById(R.id.accValuesText);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sensorManager != null) {
            sensorManager.unregisterListener(listener);
        }
    }

    private SensorEventListener listener = new SensorEventListener() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onSensorChanged(SensorEvent event) {
            float xValue = Math.abs(event.values[0]);
            float yValue = Math.abs(event.values[1]);
            float zValue = Math.abs(event.values[2]);

            accelerometerValuesText.setText("X: " + xValue + ", Y: " + yValue + ", Z: " + zValue + ".");

            long newTime = System.currentTimeMillis();
            long duration = newTime - time;
            time = newTime;

            Log.d(LOG_TAG, String.valueOf(duration));
            durations.add(duration);
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    public void onStartTaskClick(View view) {
        time = System.currentTimeMillis();

        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onStopTaskClick(View view) {
        if (sensorManager != null) {
            sensorManager.unregisterListener(listener);
        }

        Long _average = 0l;
        Long _max = 0l;
        Long _min = 5000l;

        for (Long duration: durations) {
            _average += duration;
            if (duration > _max) _max = duration;
            if (duration < _min) _min = duration;
        }

        _average /= durations.size();

        averageText.setText("Average time between measurements: " + _average);
//        minText.setText("Min: " + _min);
//        maxText.setText("Max: " + _max);
    }
}