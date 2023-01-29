package losalv.android.masterthesisnativeartifact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ImageFragment extends Fragment {
    GridView gridView;
    int logos[] = {R.drawable.image,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image,
            R.drawable.image1,
            R.drawable.image2};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_image, container, false);
        gridView = view.findViewById(R.id.gridView);
        CustomAdapter customAdapter = new CustomAdapter(getActivity().getApplicationContext(), logos);
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                Intent intent = new Intent(ImageFragment.this.getContext(), ImageActivity.class);
                intent.putExtra("image", logos[position]); // put image data in Intent
                startActivity(intent); // start Intent
            }
        });
        return view;
    }

    public class CustomAdapter extends BaseAdapter {
        Context context;
        int logos[];
        LayoutInflater inflter;
        public CustomAdapter(Context applicationContext, int[] logos) {
            this.context = applicationContext;
            this.logos = logos;
            inflter = (LayoutInflater.from(applicationContext));
        }
        @Override
        public int getCount() {
            return logos.length;
        }
        @Override
        public Object getItem(int i) {
            return null;
        }
        @Override
        public long getItemId(int i) {
            return 0;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = inflter.inflate(R.layout.activity_gridview, null); // inflate the layout
            ImageView icon = (ImageView) view.findViewById(R.id.icon); // get the reference of ImageView
            icon.setImageResource(logos[i]); // set logo images
            return view;
        }
    }

}
