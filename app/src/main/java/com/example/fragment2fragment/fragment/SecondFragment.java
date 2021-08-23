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

public class SecondFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_second, container, false);

        Button DataTOFragment1 = view.findViewById(R.id.sendDataToFragment1);

        DataTOFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText dataTo1 = view.findViewById(R.id.dataToFragment1);
                Bundle result = new Bundle();

                result.putString("df2", dataTo1.getText().toString().trim());
                getParentFragmentManager().setFragmentResult("dataFrom2", result);
                dataTo1.setText("");
            }
        });

        getParentFragmentManager().setFragmentResultListener("dataFrom1", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                String data = result.getString("df1");
                TextView textView = view.findViewById(R.id.dataFrom1);
                textView.setText(data);
            }
        });

        return view;
    }
}