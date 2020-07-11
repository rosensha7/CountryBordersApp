package com.example.mycountries3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final Context context;
    private List<CountryDbEntity> countries;
    private CountryClickListener listener;

    public MyAdapter(Context context, CountryClickListener listener){
        this.context = context;
        countries = new ArrayList<>();
        this.listener = listener;
    }

    public void setCountries(List<CountryDbEntity> countries) {
        this.countries = countries;
        notifyDataSetChanged(); // refresh the Adapter
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { // add real data to the views
        CountryDbEntity country = countries.get(position);

        holder.nameTextView.setText(country.getName());
        holder.nativeNameTextView.setText(country.getNativeName());
        holder.areaTextView.setText(country.getArea() + "");
        holder.populationTextView.setText(country.getPopulation() + "");

        holder.rowParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){ // to make it work only on the first fragment
                    listener.onCountryClicked(country.getAlpha3Code());
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView nameTextView;
        public final TextView nativeNameTextView;
        public final TextView populationTextView;
        public final TextView areaTextView;
        public final ImageView flagImageView;
        public final View rowParent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.row_name);
            nativeNameTextView = itemView.findViewById(R.id.row_native_name);
            populationTextView = itemView.findViewById(R.id.row_population);
            areaTextView = itemView.findViewById(R.id.row_area);
            flagImageView = itemView.findViewById(R.id.row_flag);
            rowParent = itemView.findViewById(R.id.row_parent);
        }
    }

    public interface CountryClickListener{
        void onCountryClicked(String alpha3Code);
    }
}
