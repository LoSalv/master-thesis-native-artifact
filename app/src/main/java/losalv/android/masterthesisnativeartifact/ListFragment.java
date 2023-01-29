package losalv.android.masterthesisnativeartifact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Arrays;
import java.util.List;

public class ListFragment extends Fragment {

    ListView listView;
    List<String> list = Arrays.asList("Hello",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World",
            "World");

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        listView = view.findViewById(R.id.listView);
        CustomAdapter listAdapter = new CustomAdapter(list);
        listView.setAdapter(listAdapter);
        return view;

    }

    class CustomAdapter extends BaseAdapter {
        List<String> items;

        public CustomAdapter(List<String> items) {
            super();
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return items.get(i).hashCode();
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(getContext());
            textView.setText(items.get(i));
            textView.setTextSize(25);
            return textView;
        }
    }

}
