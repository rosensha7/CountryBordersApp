package com.example.mycountries3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CountryFragment extends Fragment {

    private CountryViewModel mViewModel;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private View view;

    public static CountryFragment newInstance() {
        return new CountryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.country_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CountryViewModel.class);
        mViewModel.setContext(getContext());

        adapter = new MyAdapter(getContext(), alpha3Code -> {
            Bundle bundle = new Bundle();
            bundle.putString("alpha3", alpha3Code);
            Navigation.findNavController(view).navigate(R.id.action_countryFragment_to_neighbourFragment, bundle);
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mViewModel.getCountries().observe(getViewLifecycleOwner(), countryDbEntities -> {
            adapter.setCountries(countryDbEntities);
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.view = view;

        recyclerView = view.findViewById(R.id.country_recycler);

        view.findViewById(R.id.country_sort_poplation).setOnClickListener(v ->
        {
            mViewModel.sortByPopulation();
        });

        view.findViewById(R.id.country_sort_name).setOnClickListener(v ->
        {
            mViewModel.sortByName();
        });

        view.findViewById(R.id.country_sort_area).setOnClickListener(v ->
        {
            mViewModel.sortByArea();
        });
    }
}
