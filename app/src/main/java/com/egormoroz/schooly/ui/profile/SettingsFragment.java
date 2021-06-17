package com.egormoroz.schooly.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.egormoroz.schooly.MainActivity;
import com.egormoroz.schooly.R;
import com.egormoroz.schooly.ui.profile.settingscomponents.AboutusFragment;
import com.egormoroz.schooly.ui.profile.settingscomponents.NontificationsFragment;
import com.egormoroz.schooly.ui.profile.settingscomponents.PersonaldataFragment;
import com.egormoroz.schooly.ui.profile.settingscomponents.PremiumFragment;
import com.egormoroz.schooly.ui.profile.settingscomponents.PrivacypolicyFragment;
import com.egormoroz.schooly.ui.profile.settingscomponents.SupportFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingsFragment extends Fragment {


    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
         View root =inflater.inflate(R.layout.fragment_settings,container,false);
         BottomNavigationView bnv = getActivity().findViewById(R.id.bottomNavigationView);
         bnv.setVisibility(bnv.GONE);
         return root;
    }

    @Override
    public void onViewCreated(@Nullable View view, @NonNull Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        LinearLayout linearLayout=view.findViewById(R.id.privacypolicy);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setCurrentFragment(PrivacypolicyFragment.newInstance());
            }
        });

        LinearLayout linearLayout2=view.findViewById(R.id.nontification);
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setCurrentFragment(NontificationsFragment.newInstance());
            }
        });

        LinearLayout linearLayout3=view.findViewById(R.id.about);
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setCurrentFragment(AboutusFragment.newInstance());
            }
        });

        LinearLayout linearLayout4=view.findViewById(R.id.personal);
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setCurrentFragment(PersonaldataFragment.newInstance());
            }
        });

        LinearLayout linearLayout5=view.findViewById(R.id.premiumlinear);
        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setCurrentFragment(PremiumFragment.newInstance());
            }
        });

        LinearLayout linearLayout6=view.findViewById(R.id.support);
        linearLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setCurrentFragment(SupportFragment.newInstance());
            }
        });

        ImageView imageView = view.findViewById(R.id.back_toprofile);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setCurrentFragment(ProfileFragment.newInstance());
            }
        });

    }



}
