package com.example.bottomnav;

import static androidx.core.content.ContextCompat.getSystemService;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SideMessageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SideMessageFragment extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button createButton;
    NotificationManagerCompat notificationManagerCompat;
    Notification notification;

    public SideMessageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SideMessageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SideMessageFragment newInstance(String param1, String param2) {
        SideMessageFragment fragment = new SideMessageFragment();
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

        View view = inflater.inflate(R.layout.fragment_side_message, container, false);



        CardView msg1 = view.findViewById(R.id.msg1);
        msg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.msg1) {
                    triggerToastMSG(v);
                }
            }
        });

        CardView msg2 = view.findViewById(R.id.msg2);
        msg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.msg2) {
                    triggerToastMSG(v);
                }
            }
        });

        CardView msg3 = view.findViewById(R.id.msg3);
        msg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.msg3) {
                    triggerToastMSG(v);
                }
            }
        });

        CardView msg4 = view.findViewById(R.id.msg4);
        msg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.msg4) {
                    triggerToastMSG(v);
                }
            }
        });



        //button push notification
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("myCh", "My Channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = requireActivity().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireActivity().getApplicationContext(), "myCh")
                .setSmallIcon(android.R.drawable.btn_star_big_on)
                .setContentTitle("Error")
                .setContentText("Could not create a message right now");

        notification = builder.build();
        notificationManagerCompat = NotificationManagerCompat.from(requireActivity());



        return view;
    }

    public void triggerToastMSG(View v) {
        Toast.makeText(requireView().getContext(),
                "Message could not be loaded right now",
                Toast.LENGTH_LONG).show();
    }

    public void pushNotifMSG (View v){
        notificationManagerCompat.notify(1, notification);
    }
}