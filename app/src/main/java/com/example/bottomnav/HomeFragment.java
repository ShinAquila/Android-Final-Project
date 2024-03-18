package com.example.bottomnav;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.example.bottomnav.Activity2;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private Button button;
    public CardView philippines;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        CardView philippines = view.findViewById(R.id.philCard);
        philippines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openPhilippines();}
        });
        CardView france = view.findViewById(R.id.franceCard);
        france.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openFrance();}
        });
        CardView usa = view.findViewById(R.id.usaCard);
        usa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openUSA();}
        });
        CardView england = view.findViewById(R.id.englandCard);
        england.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openEngland();}
        });
        CardView india = view.findViewById(R.id.indiaCard);
        india.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {openIndia();}
        });


        button = view.findViewById(R.id.next_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    public void openActivity2(){
        Intent intent = new Intent(getActivity(), Activity2.class);
        startActivity(intent);
    }

    public void openPhilippines(){
        Intent intent = new Intent(getActivity(), Philippines.class);
        startActivity(intent);
    }
    public void openFrance(){
        Intent intent = new Intent(getActivity(), France.class);
        startActivity(intent);
    }
    public void openUSA(){
        Intent intent = new Intent(getActivity(), USA.class);
        startActivity(intent);
    }
    public void openEngland(){
        Intent intent = new Intent(getActivity(), England.class);
        startActivity(intent);
    }
    public void openIndia(){
        Intent intent = new Intent(getActivity(), India.class);
        startActivity(intent);
    }
}