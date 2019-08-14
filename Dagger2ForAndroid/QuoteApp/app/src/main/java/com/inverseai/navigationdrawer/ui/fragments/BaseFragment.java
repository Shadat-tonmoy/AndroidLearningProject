package com.inverseai.navigationdrawer.ui.fragments;

import android.support.v4.app.Fragment;

import com.inverseai.navigationdrawer.common.CustomApplication;
import com.inverseai.navigationdrawer.common.dependencyInjection.ControllerCompositionRoot;

public class BaseFragment extends Fragment {

    private ControllerCompositionRoot controllerCompositionRoot;

    public ControllerCompositionRoot getCompositionRoot() {
        if(controllerCompositionRoot ==null)
        {
            controllerCompositionRoot = new ControllerCompositionRoot(
                    ((CustomApplication) requireActivity().getApplication()).getCompositionRoot(),
                    requireActivity());
        }
        return controllerCompositionRoot;
    }
}
