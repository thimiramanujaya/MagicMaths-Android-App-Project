package com.uniquestudio.magicmaths.ui.gallery;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.uniquestudio.magicmaths.MainActivity;
import com.uniquestudio.magicmaths.R;

public class GalleryFragment extends Fragment {

    RadioGroup RG1, RG2, RG3, RG4, RG5;
    RadioButton RB1, RB2, RB3, RB4, RB5, SRB1,SRB2,SRB3,SRB4,SRB5;
    Button btnSum, yesb, nob, replaybtn;
    TextView txt32;
    VideoView congrvd;

    int c1,c2,c3,c4,c5,sum;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView gall = root.findViewById(R.id.text_gallery);
        final TextView txtS = root.findViewById(R.id.numind);
        final MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.congratsong);



        RG1 = root.findViewById(R.id.rg1);
        RG2 = root.findViewById(R.id.rg2);
        RG3 = root.findViewById(R.id.rg3);
        RG4 = root.findViewById(R.id.rg4);
        RG5 = root.findViewById(R.id.rg5);
        btnSum = root.findViewById(R.id.btn_fi);
        RB1 = root.findViewById(R.id.rd1);
        RB2 = root.findViewById(R.id.rd2);
        RB3 = root.findViewById(R.id.rd3);
        RB4 = root.findViewById(R.id.rd4);
        RB5 = root.findViewById(R.id.rd5);
        SRB1 = root.findViewById(R.id.srd1);
        SRB2 = root.findViewById(R.id.srd2);
        SRB3 = root.findViewById(R.id.srd3);
        SRB4 = root.findViewById(R.id.srd4);
        SRB5 = root.findViewById(R.id.srd5);
        yesb = root.findViewById(R.id.yesbtn);
        nob = root.findViewById(R.id.nobtn);
        replaybtn = root.findViewById(R.id.replay);
        txt32 = root.findViewById(R.id.textView32);
        congrvd = root.findViewById(R.id.congratsved);
        String videopath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.firework;
        Uri uri = Uri.parse(videopath);
        congrvd.setVideoURI(uri);



        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                gall.setText(s);
            }
        });

        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String p) {
                txtS.setText(p);
            }
        });




        RG1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(RB1.isChecked()) {
                        c1 =1;
                        gall.setText(String.valueOf(c1));
                }
                else if (SRB1.isChecked()) {
                        c1 = 0;
                        gall.setText(String.valueOf(c1));
                }else{
                       txtS.setText("!!? Oops!, Wrong match");
                }
            }


        });


        RG2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(RB2.isChecked()) {
                    c2 =8;
                    gall.setText(String.valueOf(c2));
                }
                else if (SRB2.isChecked()) {
                    c2 = 0;
                    gall.setText(String.valueOf(c2));
                }else{
                    txtS.setText("!!? Oops!, Wrong match");
                }
            }
        });

        RG3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(RB3.isChecked()) {
                    c3 =4;
                    gall.setText(String.valueOf(c3));
                }
                else if (SRB3.isChecked()) {
                    c3 = 0;
                    gall.setText(String.valueOf(c3));
                }else{
                    txtS.setText("!!? Oops!, Wrong match");
                }
            }
        });

        RG4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(RB4.isChecked()) {
                    c4 =2;
                    gall.setText(String.valueOf(c4));
                }
                else if (SRB4.isChecked()) {
                    c4 = 0;
                    gall.setText(String.valueOf(c4));
                }else{
                    txtS.setText("!!? Oops!, Wrong match");
                }
            }
        });

        RG5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(RB5.isChecked()) {
                    c5 =16;
                    gall.setText(String.valueOf(c5));
                }
                else if (SRB5.isChecked()) {
                    c5 = 0;
                    gall.setText(String.valueOf(c5));
                }else{
                    txtS.setText("!!? Oops!, Wrong match");
                }
            }
        });


        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 {
                     sum = c1 + c2 + c3 + c4 + c5;
                     if(sum>=31){
                         txtS.setTextSize(24);
                        txtS.setText("!!? Oops!, Wrong match");}
                     else if(sum==0) {
                         txtS.setTextSize(16);
                         txtS.setText("කණගාටුයි ! ඔබ කිසිම සංඛ්\u200Dයාවක් සිතාගෙන නැත.");
                     }
                     else {
                         txtS.setTextSize(36);
                         txtS.setText(String.valueOf(sum));

                         txt32.setVisibility(View.VISIBLE);
                         yesb.setVisibility(View.VISIBLE);
                         nob.setVisibility(View.VISIBLE);
                         nob.setFocusable(true);
                         nob.setFocusableInTouchMode(true);
                         nob.requestFocus();
                     }



            }
        }


        });
        yesb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sum==0) {
                    txtS.setTextSize(14);
                    txtS.setText("You have not mark any fields in this scene ! Please mark all the fields properly");
                }
                else if(sum>=31) {
                    txtS.setTextSize(16);
                    txtS.setText("!!? Oops!, Wrong match. Please mark fields again correctly");
                }
                else {
                    mp.start();
                    congrvd.setVisibility(View.VISIBLE);
                    congrvd.start();
                    replaybtn.setVisibility(View.VISIBLE);
                    replaybtn.setFocusable(true);
                    replaybtn.setFocusableInTouchMode(true);
                    replaybtn.requestFocus();
                }

            }
        });

        nob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.release();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, new GalleryFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        replaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.release();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, new GalleryFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });






        return root;

    }

}