package com.egormoroz.schooly.ui.people;

import androidx.lifecycle.ViewModelProvider;

import android.app.MediaRouteButton;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.egormoroz.schooly.R;
import com.google.android.material.appbar.AppBarLayout;

public class PeopleFragment extends Fragment {

    private PeopleViewModel peopleViewModel;

    public static PeopleFragment newInstance() {
        return new PeopleFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_people, container, false);
        AppBarLayout abl=getActivity().findViewById(R.id.AppBarLayout);
        abl.setVisibility(abl.VISIBLE);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        peopleViewModel = new ViewModelProvider(this).get(PeopleViewModel.class);
    }

}