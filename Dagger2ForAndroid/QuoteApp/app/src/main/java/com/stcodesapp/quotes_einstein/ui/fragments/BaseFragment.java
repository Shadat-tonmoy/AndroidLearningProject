package com.stcodesapp.quotes_einstein.ui.fragments;

import android.support.v4.app.Fragment;

import com.stcodesapp.quotes_einstein.common.CustomApplication;
import com.stcodesapp.quotes_einstein.common.dependencyInjection.FragmentCompositionRoot;

public class BaseFragment extends Fragment {

    private FragmentCompositionRoot compositionRoot;

    public FragmentCompositionRoot getCompositionRoot() {
        if(compositionRoot ==null)
        {
            compositionRoot = new FragmentCompositionRoot(
                    ((CustomApplication) requireActivity().getApplication()).getCompositionRoot(),
                    requireActivity(), requireActivity().getSupportFragmentManager());
        }
        return compositionRoot;
    }


}
