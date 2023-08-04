package com.qbra.sanatkitabi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.qbra.sanatkitabi.databinding.FragmentAddArtBinding;
import com.qbra.sanatkitabi.databinding.FragmentHomepageBinding;
import com.qbra.sanatkitabi.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class HomepageFragment extends Fragment {

    FragmentHomepageBinding binding;
    ArrayList<Art> artArrayList;
    ArtAdapter artAdapter;
    SQLiteDatabase sqLiteDatabase;
    String info;

    public HomepageFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        artArrayList = new ArrayList<>();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomepageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        artAdapter = new ArtAdapter(artArrayList);
        binding.recyclerView.setAdapter(artAdapter);
        getData();

        sqLiteDatabase = requireActivity().openOrCreateDatabase("Posts", Context.MODE_PRIVATE, null);
        super.onViewCreated(view, savedInstanceState);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void getData()
    {
        try
        {
            SQLiteDatabase sqLiteDatabase = requireActivity().openOrCreateDatabase("Posts", Context.MODE_PRIVATE, null);

            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM posts", null);
            int nameIx = cursor.getColumnIndex("artname");
            int idIx = cursor.getColumnIndex("id");

            while (cursor.moveToNext()){
                String name = cursor.getString(nameIx);
                int id = cursor.getInt(idIx);
                Art art = new Art(name, id);
                artArrayList.add(art);
            }

            artAdapter.notifyDataSetChanged();
            cursor.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}