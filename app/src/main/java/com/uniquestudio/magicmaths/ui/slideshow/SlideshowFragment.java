package com.uniquestudio.magicmaths.ui.slideshow;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.uniquestudio.magicmaths.R;
import com.uniquestudio.magicmaths.ui.gallery.GalleryFragment;

public class SlideshowFragment extends Fragment {

    EditText magicText;
    TextView firstNum, secondNum, thirdNum, frstMem, SecnMem, ThrdMem;
    Button AdvMagicBTN, rgt1, rgt2, rgt3, wrg1, wrg2, wrg3, resetMagic;
    VideoView firstAnim, SecondAnim, ThirdAnim, congratsAnim;

    public double magicNum0, magicNum;
    public int fstn, secn, thrn;

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        final MediaPlayer mp0 = MediaPlayer.create(getActivity(), R.raw.congratsong);

        magicText = root.findViewById(R.id.magicnum);
        firstNum = root.findViewById(R.id.firstVAL);
        secondNum = root.findViewById(R.id.secondVAL);
        thirdNum = root.findViewById(R.id.thirdVAL);
        AdvMagicBTN = root.findViewById(R.id.btn2_magic);
        rgt1 = root.findViewById(R.id.rgt1);
        rgt2 = root.findViewById(R.id.rgt2);
        rgt3 = root.findViewById(R.id.rgt3);
        wrg1 = root.findViewById(R.id.wrong1);
        wrg2 = root.findViewById(R.id.wrong2);
        wrg3 = root.findViewById(R.id.wrong3);
        frstMem = root.findViewById(R.id.textView65);
        SecnMem = root.findViewById(R.id.textView66);
        ThrdMem = root.findViewById(R.id.textView67);
        resetMagic = root.findViewById(R.id.replayMagic);

        firstAnim = root.findViewById(R.id.videoView);
        String videopath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.firstmagicanim;
        Uri uri = Uri.parse(videopath);
        firstAnim.setVideoURI(uri);

        SecondAnim = root.findViewById(R.id.videoView2);
        String videopath2 = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.secondmagicanim;
        Uri uri2 = Uri.parse(videopath2);
        SecondAnim.setVideoURI(uri2);

        ThirdAnim = root.findViewById(R.id.videoView3);
        String videopath3 = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.thirdmagicanim;
        Uri uri3 = Uri.parse(videopath3);
        ThirdAnim.setVideoURI(uri3);

        congratsAnim = root.findViewById(R.id.videoView4);
        String videopath4 = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.firework;
        Uri uri4 = Uri.parse(videopath4);
        congratsAnim.setVideoURI(uri4);

        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        magicText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                magicText.setHint("");
            }
        });

        AdvMagicBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(magicText.getText().toString().length() == 0) {
                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.nav_host_fragment, new SlideshowFragment());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    Toast.makeText(getContext(), "ඔබ මායාව සදහා නිවැරදි ව දායක වී නැත ! , නැවත උත්සහ කරන්න.", Toast.LENGTH_LONG).show();
                }
                else {
                    magicNum0 = Double.parseDouble(magicText.getText().toString());

                    if(magicNum0>6999999993.0) {
                        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host_fragment, new SlideshowFragment());
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        Toast.makeText(getContext(), "Oops!! උපදෙස් නිවැරදිව අනුගමනය කර නොමැත. !  නැවත උත්සහ කරන්න.", Toast.LENGTH_LONG).show();
                    }
                    else {
                        magicNum = magicNum0 / 7;

                        thrn = (int) ((magicNum % 10000) % 100);
                        secn = (int) (((magicNum - thrn) % 10000) / 100);
                        fstn = (int) ((magicNum - (magicNum % 10000)) / 10000);

                        frstMem.setVisibility(View.VISIBLE);
                        firstNum.setVisibility(View.VISIBLE);
                        rgt1.setVisibility(View.VISIBLE);
                        wrg1.setVisibility(View.VISIBLE);
                        firstAnim.setVisibility(View.VISIBLE);
                        firstAnim.setFocusable(true);
                        firstAnim.setFocusableInTouchMode(true);
                        firstAnim.requestFocus();
                        magicText.setEnabled(false);

                        firstAnim.start();

                        firstNum.setText(String.valueOf(fstn));

                        firstAnim.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                firstAnim.setVisibility(View.INVISIBLE);
                            }
                        });
                    }
                }
            }
        });
        //firstAnim.setVisibility(View.INVISIBLE);

        rgt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                magicNum0 = Double.parseDouble(magicText.getText().toString());

                magicNum = magicNum0/7;

                thrn = (int) ((magicNum % 10000) % 100);
                secn = (int) (((magicNum - thrn) % 10000) / 100);
                fstn = (int) ((magicNum - (magicNum % 10000)) / 10000);

                SecnMem.setVisibility(View.VISIBLE);
                secondNum.setVisibility(View.VISIBLE);
                rgt2.setVisibility(View.VISIBLE);
                wrg2.setVisibility(View.VISIBLE);
                SecondAnim.setVisibility(View.VISIBLE);
                SecondAnim.setFocusable(true);
                SecondAnim.setFocusableInTouchMode(true);
                SecondAnim.requestFocus();
                magicText.setEnabled(false);

                secondNum.setText(String.valueOf(secn));

                SecondAnim.start();

                SecondAnim.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        SecondAnim.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        //SecondAnim.setVisibility(View.INVISIBLE);

        wrg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp0.release();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, new SlideshowFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                magicText.setEnabled(true);
                Toast.makeText(getContext(), "ඔබ මායාව සදහා නිවැරදි ව දායක වී නැත ! , නැවත උත්සහ කරන්න.", Toast.LENGTH_LONG).show();
            }
        });

        rgt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                magicNum0 = Double.parseDouble(magicText.getText().toString());

                magicNum = magicNum0/7;

                thrn = (int) ((magicNum % 10000) % 100);
                secn = (int) (((magicNum - thrn) % 10000) / 100);
                fstn = (int) ((magicNum - (magicNum % 10000)) / 10000);

                ThrdMem.setVisibility(View.VISIBLE);
                thirdNum.setVisibility(View.VISIBLE);
                rgt3.setVisibility(View.VISIBLE);
                wrg3.setVisibility(View.VISIBLE);
                ThirdAnim.setVisibility(View.VISIBLE);
                ThirdAnim.setFocusable(true);
                ThirdAnim.setFocusableInTouchMode(true);
                ThirdAnim.requestFocus();
                magicText.setEnabled(false);

                thirdNum.setText(String.valueOf(thrn));

                ThirdAnim.start();

                ThirdAnim.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        ThirdAnim.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
        //ThirdAnim.setVisibility(View.INVISIBLE);

        wrg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp0.release();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, new SlideshowFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                magicText.setEnabled(true);
                Toast.makeText(getContext(), "ඔබ මායාව සදහා නිවැරදි ව දායක වී නැත ! , නැවත උත්සහ කරන්න.", Toast.LENGTH_LONG).show();
            }
        });


        rgt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                congratsAnim.setVisibility(View.VISIBLE);
                congratsAnim.start();
                mp0.start();
                resetMagic.setVisibility(View.VISIBLE);
                resetMagic.setFocusable(true);
                resetMagic.setFocusableInTouchMode(true);
                resetMagic.requestFocus();
                firstNum.setText("");
                secondNum.setText("");
                thirdNum.setText("");
                magicText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        Toast.makeText(getContext(), "ඔබ නව අගයක් ඇතුල් කරන බැවින් පෙර ප්‍රතිඵල අවසන් කරන ", Toast.LENGTH_LONG).show();
                    }
                });
                magicText.setEnabled(false);

            }
        });
        wrg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp0.release();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, new SlideshowFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                magicText.setEnabled(true);
                Toast.makeText(getContext(), "ඔබ මායාව සදහා නිවැරදි ව දායක වී නැත ! , නැවත උත්සහ කරන්න.", Toast.LENGTH_LONG).show();
            }
        });

     /*   magicText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(magicText.isFocused()) {
                    frstMem.setVisibility(View.GONE);
                    firstNum.setVisibility(View.GONE);
                    rgt1.setVisibility(View.GONE);
                    wrg1.setVisibility(View.GONE);
                    firstAnim.setVisibility(View.GONE);
                    SecnMem.setVisibility(View.GONE);
                    secondNum.setVisibility(View.GONE);
                    rgt2.setVisibility(View.GONE);
                    wrg2.setVisibility(View.GONE);
                    SecondAnim.setVisibility(View.GONE);
                    ThrdMem.setVisibility(View.GONE);
                    thirdNum.setVisibility(View.GONE);
                    rgt3.setVisibility(View.GONE);
                    wrg3.setVisibility(View.GONE);
                    ThirdAnim.setVisibility(View.GONE);
                    congratsAnim.setVisibility(View.GONE);
                    congratsAnim.stopPlayback();
                    mp0.release();
                    Toast.makeText(getContext(), "ඔබ නව අගයක් ඇතුල් කරන බැවින් පෙර ප්‍රතිඵල අවසන් කරන ", Toast.LENGTH_LONG).show();

                }
            }
        });  */

        resetMagic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                congratsAnim.stopPlayback();
                mp0.release();

                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, new SlideshowFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                magicText.setEnabled(true);
            }
        });


        return root;
    }
}