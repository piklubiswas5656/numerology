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
import com.numerology.digital.Number_Activity;
import com.numerology.digital.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Comatibility_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Comatibility_Fragment extends Fragment {

    private TextView button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private TextView Lifepath_number_Text;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Comatibility_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Comatibility_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Comatibility_Fragment newInstance(String param1, String param2) {
        Comatibility_Fragment fragment = new Comatibility_Fragment();
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
        View view = inflater.inflate(R.layout.fragment_comatibility_, container, false);
        Lifepath_number_Text = view.findViewById(R.id.Lifepath_number_Text);
        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);
        button3 = view.findViewById(R.id.button3);
        button4 = view.findViewById(R.id.button4);
        button5 = view.findViewById(R.id.button5);
        button6 = view.findViewById(R.id.button6);
        button7 = view.findViewById(R.id.button7);
        button8 = view.findViewById(R.id.button8);
        button9 = view.findViewById(R.id.button9);
        SharedPreferences getShared = getContext().getSharedPreferences(Constant.USER, MODE_PRIVATE);
        getShared.getString(Constant.NAMENUMBER, "namenumber");
        Lifepath_number_Text.setText("Your Life Path Number is " + getShared.getString(Constant.NAMENUMBER, "nodatefound"));
        onclick();


        return view;
    }

    private void onclick() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Number_Activity.class);
                intent.putExtra(Constant.PERSONALITYNUMBER, Constant.ONE);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Number_Activity.class);
                intent.putExtra(Constant.PERSONALITYNUMBER, Constant.TWO);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Number_Activity.class);
                intent.putExtra(Constant.PERSONALITYNUMBER, Constant.TREE);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Number_Activity.class);
                intent.putExtra(Constant.PERSONALITYNUMBER, Constant.FOUR);
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Number_Activity.class);
                intent.putExtra(Constant.PERSONALITYNUMBER, Constant.FIVE);
                startActivity(intent);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Number_Activity.class);
                intent.putExtra(Constant.PERSONALITYNUMBER, Constant.SIX);
                startActivity(intent);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Number_Activity.class);
                intent.putExtra(Constant.PERSONALITYNUMBER, Constant.SEVEN);
                startActivity(intent);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Number_Activity.class);
                intent.putExtra(Constant.PERSONALITYNUMBER, Constant.EIGHT);
                startActivity(intent);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Number_Activity.class);
                intent.putExtra(Constant.PERSONALITYNUMBER, Constant.NINE);
                startActivity(intent);
            }
        });


    }


}