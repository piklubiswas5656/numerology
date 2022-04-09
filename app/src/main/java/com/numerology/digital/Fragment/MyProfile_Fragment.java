package com.numerology.digital.Fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.numerology.digital.Constant;
import com.numerology.digital.FillYourDetail;
import com.numerology.digital.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyProfile_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyProfile_Fragment extends Fragment {

    private Button newUser;
    private TextView Personality_numberText;
    private String Personality_number;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MyProfile_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyProfile_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyProfile_Fragment newInstance(String param1, String param2) {
        MyProfile_Fragment fragment = new MyProfile_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile_, container, false);
        newUser = view.findViewById(R.id.newUser);
        Personality_numberText = view.findViewById(R.id.Personality_number);
        SharedPreferences getShared = getContext().getSharedPreferences(Constant.USER, MODE_PRIVATE);
        Personality_number = getShared.getString(Constant.NAMENUMBER, "namenumber");
        Personality_numberText.setText(String.valueOf(Personality_number));
        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), FillYourDetail.class));
            }
        });
        return view;
    }
}