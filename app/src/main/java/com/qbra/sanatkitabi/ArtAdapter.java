package com.qbra.sanatkitabi;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.qbra.sanatkitabi.AddArtFragmentDirections;
import com.qbra.sanatkitabi.HomepageFragmentDirections;
import com.qbra.sanatkitabi.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class ArtAdapter extends RecyclerView.Adapter<ArtAdapter.ArtHolder> {

    ArrayList<Art> arts = new ArrayList<>();
    public ArtAdapter(ArrayList<Art> arts) {
        this.arts = arts;
    }

    @NonNull
    @Override
    public ArtHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ArtHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtAdapter.ArtHolder holder, int position) {
        int temp = position;
        holder.binding.recyclerViewTextView.setText(arts.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.qbra.sanatkitabi.HomepageFragmentDirections.ActionHomepageFragmentToAddArtFragment action = (com.qbra.sanatkitabi.HomepageFragmentDirections.ActionHomepageFragmentToAddArtFragment) HomepageFragmentDirections.actionHomepageFragmentToAddArtFragment("old");
                action.setArtId(arts.get(temp).id);
                action.setInfo("old");
                Navigation.findNavController(view).navigate(action);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arts.size();
    }


    public class ArtHolder extends RecyclerView.ViewHolder{

        private RecyclerRowBinding binding;

        public ArtHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
