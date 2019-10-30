package com.lambdaschool.javaswapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SwPersonListAdapter extends RecyclerView.Adapter<SwPersonListAdapter.PersonViewHolder> {
    public List<Person> data;

    public SwPersonListAdapter(List<Person> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PersonViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(
                                R.layout.sw_person_layout,
                                parent,
                                false));
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = data.get(position);
        holder.titleView.setText(person.getName());
        holder.speciesView.setText(person.getSpecies().get(0));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        public TextView titleView, speciesView;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.title_view);
            speciesView = itemView.findViewById(R.id.species_view);
        }
    }

}
