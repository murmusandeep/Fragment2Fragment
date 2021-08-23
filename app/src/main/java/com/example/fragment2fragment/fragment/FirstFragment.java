package com.example.fragment2fragment.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fragment2fragment.R;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        Button DataTOFragment2 = view.findViewById(R.id.sendDataToFragment2);

        DataTOFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText dataTo2 = view.findViewById(R.id.dataToFragment2);
                Bundle result = new Bundle();

                result.putString("df1", dataTo2.getText().toString().trim());
                getParentFragmentManager().setFragmentResult("dataFrom1", result);
                dataTo2.setText("");
            }
        });

        getParentFragmentManager().setFragmentResultListener("dataFrom2", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                String data = result.getString("df2");
                TextView textView = view.findViewById(R.id.dataFrom1);
                textView.setText(data);
            }
        });

        return view;
    }
}