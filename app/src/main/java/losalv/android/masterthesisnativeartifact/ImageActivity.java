package losalv.android.masterthesisnativeartifact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ImageActivity  extends AppCompatActivity {
    ImageView selectedImage;
    private int zoomed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        selectedImage = (ImageView) findViewById(R.id.selectedImage); // init a ImageView
        Intent intent = getIntent(); // get Intent which we set from Previous Activity
        selectedImage.setImageResource(intent.getIntExtra("image", 0)); // get image from Intent and set it in ImageView

    }

    public void onImageTap(View view) {
        switch (zoomed) {
            case 0:
                selectedImage.setScaleX(0.75f);
                selectedImage.setScaleY(0.75f);
                zoomed = 1;
                break;
            case 1:
                selectedImage.setScaleX(0.5f);
                selectedImage.setScaleY(0.5f);
                zoomed = 2;
                break;
            case 2:
                selectedImage.setScaleX(1.0f);
                selectedImage.setScaleY(1.0f);
                zoomed = 0;
                break;
        }
    }

}
