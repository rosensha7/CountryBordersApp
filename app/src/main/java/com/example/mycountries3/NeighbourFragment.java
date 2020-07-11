package com.example.mycountries3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NeighbourFragment extends Fragment {

    private NeighbourViewModel mViewModel;
    private MyAdapter adapter;
    private RecyclerView recyclerView;

    public static NeighbourFragment newInstance() {
        return new NeighbourFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.neighbour_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NeighbourViewModel.class);
        mViewModel.setContext(getContext());

        String alpha3 = getArguments().getString("alpha3");

        adapter = new MyAdapter(getContext(), null);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mViewModel.getNeighbours(alpha3).observe(getViewLifecycleOwner(), countryDbEntities -> {
            adapter.setCountries(countryDbEntities);
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.neighbour_recycler);
    }
}
