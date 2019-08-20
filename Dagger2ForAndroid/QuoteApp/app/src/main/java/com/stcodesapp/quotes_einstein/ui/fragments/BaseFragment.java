package com.stcodesapp.quotes_einstein.ui.fragments;

import android.support.v4.app.Fragment;

import com.stcodesapp.quotes_einstein.common.CustomApplication;
import com.stcodesapp.quotes_einstein.common.dependencyInjection.ControllerCompositionRoot;

public class BaseFragment extends Fragment {

    private ControllerCompositionRoot compositionRoot;

    public ControllerCompositionRoot getCompositionRoot() {
        if(compositionRoot ==null)
        {
            compositionRoot = new ControllerCompositionRoot(
                    ((CustomApplication) requireActivity().getApplication()).getCompositionRoot(),
                    requireActivity(), requireActivity().getSupportFragmentManager());
        }
        return compositionRoot;
    }


}
