package id.ac.upnyk.responsicovid.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.ac.upnyk.responsicovid.Info.InfoAdapter;
import id.ac.upnyk.responsicovid.R;


public class InfoFragment extends Fragment {

    private InfoViewModel infoViewModel;
    private RecyclerView rvInfo;
    private InfoAdapter infoAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        infoViewModel = new ViewModelProvider(this).get(InfoViewModel.class);
        rvInfo = view.findViewById(R.id.info_rv);
        infoAdapter = new InfoAdapter(getActivity(),new ArrayList<>());

        rvInfo.setHasFixedSize(true);
        rvInfo.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL, true));
        rvInfo.setAdapter(infoAdapter);

        infoViewModel.getInfoContentItems().observe(requireActivity(), infoContentItems -> {
            infoAdapter.setInfoContentItems(infoContentItems);
            infoAdapter.notifyDataSetChanged();
            rvInfo.scrollToPosition(infoAdapter.getItemCount()-1);
        });
        infoViewModel.loadInfo();
    }

}