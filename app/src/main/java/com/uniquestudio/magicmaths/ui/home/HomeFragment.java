package com.uniquestudio.magicmaths.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.uniquestudio.magicmaths.Help;
import com.uniquestudio.magicmaths.Magic_1;
import com.uniquestudio.magicmaths.MainActivity;
import com.uniquestudio.magicmaths.R;
import com.uniquestudio.magicmaths.ui.gallery.GalleryFragment;
import com.uniquestudio.magicmaths.ui.main.HelpFragment;
import com.uniquestudio.magicmaths.ui.slideshow.SlideshowFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        Button btn_cards = root.findViewById(R.id.button);
        Button btn_one = root.findViewById(R.id.btn_one);
        Button btn_family = root.findViewById(R.id.button3);
     // Button btn_help = root.findViewById(R.id.imageButton);




        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Magic_1.class));
            }
        });

        btn_cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Fragment fragment2 = new Fragment();
                //FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, new GalleryFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        btn_family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction2 = getParentFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.nav_host_fragment, new SlideshowFragment());
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();
            }
        });

     /*   btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Help.class));
                FragmentTransaction fragmentTransaction3 = getParentFragmentManager().beginTransaction();
                fragmentTransaction3.replace(R.id.nav_host_fragment, new HelpFragment());
                fragmentTransaction3.addToBackStack(null);
                fragmentTransaction3.commit();
            }
        });  */
        return root;
    }

 /*   @Override
    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.:
                fragment = new GalleryFragment();
                ReplaceFragment(fragment);
                break;
            case R.id.button3:
                fragment = new SlideshowFragment();
                ReplaceFragment(fragment);
                break;
        }
    }

    public void ReplaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment_container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }  */
}