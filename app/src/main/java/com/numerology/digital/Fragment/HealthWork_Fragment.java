package com.numerology.digital.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.numerology.digital.Alltext;
import com.numerology.digital.Constant;
import com.numerology.digital.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HealthWork_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HealthWork_Fragment extends Fragment {
    private CardView Behaviour;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HealthWork_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HealthWork_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HealthWork_Fragment newInstance(String param1, String param2) {
        HealthWork_Fragment fragment = new HealthWork_Fragment();
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
       View view=inflater.inflate(R.layout.fragment_health_work_, container, false);
        Behaviour=view.findViewById(R.id.Behaviour);
        Behaviour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Alltext.class);
                intent.putExtra(Constant.ALLTEXTREADING, "Behaviour");
                startActivity(intent);
            }
        });

       return view;
    }
}