package com.numerology.digital.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.numerology.digital.Constant;
import com.numerology.digital.R;
import com.numerology.digital.Rasifal;
import com.numerology.digital.Scratch;


public class Affirmation_Fragment extends Fragment {
    private LinearLayout Aries, Taurus, Gemini, Cancer, Leo, Virgo, Libra, Scorpio, Sagittarius, Capricorn, Aquarius, Pisces, Affirmation;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Affirmation_Fragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Affirmation_Fragment newInstance(String param1, String param2) {
        Affirmation_Fragment fragment = new Affirmation_Fragment();
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
        View view = inflater.inflate(R.layout.fragment_affirmation_, container, false);


        Aries = view.findViewById(R.id.aries);
        Taurus = view.findViewById(R.id.taurus);
        Gemini = view.findViewById(R.id.Gemini);
        Cancer = view.findViewById(R.id.Cancer);
        Leo = view.findViewById(R.id.leo);
        Virgo = view.findViewById(R.id.Virgo);
        Libra = view.findViewById(R.id.libra);
        Scorpio = view.findViewById(R.id.Scorpio);
        Sagittarius = view.findViewById(R.id.Sattari);
        Capricorn = view.findViewById(R.id.Capricorn);
        Aquarius = view.findViewById(R.id.Aquarius);
        Pisces = view.findViewById(R.id.Pisces);
        Affirmation = view.findViewById(R.id.Scratchliner);
        onclick();
        return view;
    }

    private void onclick() {
        Aries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Rasifal.class);
                intent.putExtra(Constant.RASIFALTEXT, "Aries");
                startActivity(intent);
            }
        });
        Taurus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Rasifal.class);
                intent.putExtra(Constant.RASIFALTEXT, "Taurus");
                startActivity(intent);
            }
        });
        Gemini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Rasifal.class);
                intent.putExtra(Constant.RASIFALTEXT, "Gemini");
                startActivity(intent);
            }
        });
        Cancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Rasifal.class);
                intent.putExtra(Constant.RASIFALTEXT, "Cancer");
                startActivity(intent);
            }
        });
        Leo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Rasifal.class);
                intent.putExtra(Constant.RASIFALTEXT, "Leo");
                startActivity(intent);
            }
        });
        Virgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Rasifal.class);
                intent.putExtra(Constant.RASIFALTEXT, "Virgo");
                startActivity(intent);
            }
        });
        Libra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Rasifal.class);
                intent.putExtra(Constant.RASIFALTEXT, "Libra");
                startActivity(intent);
            }
        });
        Scorpio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Rasifal.class);
                intent.putExtra(Constant.RASIFALTEXT, "Scorpio");
                startActivity(intent);
            }
        });
        Sagittarius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Rasifal.class);
                intent.putExtra(Constant.RASIFALTEXT, "Sagittarius");
                startActivity(intent);
            }
        });
        Capricorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Rasifal.class);
                intent.putExtra(Constant.RASIFALTEXT, "Capricorn");
                startActivity(intent);
            }
        });
        Aquarius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Rasifal.class);
                intent.putExtra(Constant.RASIFALTEXT, "Aquarius");
                startActivity(intent);
            }
        });
        Pisces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Rasifal.class);
                intent.putExtra(Constant.RASIFALTEXT, "Pisces");
                startActivity(intent);
            }
        });
        Affirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Scratch.class));
            }
        });
    }
}