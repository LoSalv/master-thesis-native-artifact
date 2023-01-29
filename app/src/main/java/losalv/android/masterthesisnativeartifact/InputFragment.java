package losalv.android.masterthesisnativeartifact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InputFragment extends Fragment {

    EditText firstEditText;
    EditText secondEditText;
    EditText thirdEditText;

    Button clearBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        firstEditText = view.findViewById(R.id.editText);
        secondEditText = view.findViewById(R.id.editText1);
        thirdEditText = view.findViewById(R.id.editText2);

        clearBtn = view.findViewById(R.id.button);
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstEditText.setText("");
                secondEditText.setText("");
                thirdEditText.setText("");
            }
        });
        return view;
    }
}
