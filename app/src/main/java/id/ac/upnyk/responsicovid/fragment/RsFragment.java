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

import id.ac.upnyk.responsicovid.R;
import id.ac.upnyk.responsicovid.RS.RSAdapter;


public class RsFragment extends Fragment {

    private RSViewModel rsViewModel;
    private RecyclerView rsrv;
    private RSAdapter rsAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rs, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rsViewModel = new ViewModelProvider(this).get(RSViewModel.class);
        rsrv = view.findViewById(R.id.rs_rv);
        rsAdapter = new RSAdapter(getActivity(), new ArrayList<>());

        rsrv.setHasFixedSize(true);
        rsrv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        rsrv.setAdapter(rsAdapter);

        rsViewModel.getDataItem().observe(requireActivity(), dataItems -> {
            rsAdapter.setDataItems(dataItems);
            rsAdapter.notifyDataSetChanged();

        });

        rsViewModel.loadrs();
    }
}