package losalv.android.masterthesisnativeartifact;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class GUIActivity extends AppCompatActivity {

    private static final String LOG_TAG = GUIActivity.class.getSimpleName();

    TabLayout tabLayout;
    ViewPager2 viewPager2;

    ViewPagerFragmentAdapter adapter;

    private String[] labels = new String[]{"List", "Input", "Image"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        Log.d(LOG_TAG, "onCreate");

        init();

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setText(labels[position]);
        }).attach();

        // set default position to 1 instead of default 0
        viewPager2.setCurrentItem(0, false);

    }

    private void init() {
        // initialize tabLayout
        tabLayout = findViewById(R.id.tabLayout);
        // initialize viewPager2
        viewPager2 = findViewById(R.id.viewPager2);
        // create adapter instance
        adapter = new ViewPagerFragmentAdapter(this);
        // set adapter to viewPager2
        viewPager2.setAdapter(adapter);

        // remove default elevation of actionbar
        getSupportActionBar().setElevation(0);
    }

    // create adapter to attach fragments to viewpager2 using FragmentStateAdapter
    private class ViewPagerFragmentAdapter extends FragmentStateAdapter {

        public ViewPagerFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        // return fragments at every position
        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new ListFragment(); // calls fragment
                case 1:
                    return new InputFragment(); // chats fragment
                case 2:
                    return new ImageFragment(); // status fragment
            }
            return new ListFragment(); //chats fragment
        }

        // return total number of tabs in our case we have 3
        @Override
        public int getItemCount() {
            return labels.length;
        }
    }


}
