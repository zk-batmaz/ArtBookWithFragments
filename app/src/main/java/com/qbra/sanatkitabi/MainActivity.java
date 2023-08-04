package com.qbra.sanatkitabi;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.qbra.sanatkitabi.HomepageFragmentDirections;

public class MainActivity extends AppCompatActivity {

    ActivityResultLauncher activityResultLauncher;
    ActivityResultLauncher permissionLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.art_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add_art){
            com.qbra.sanatkitabi.HomepageFragmentDirections.ActionHomepageFragmentToAddArtFragment action = (com.qbra.sanatkitabi.HomepageFragmentDirections.ActionHomepageFragmentToAddArtFragment) HomepageFragmentDirections.actionHomepageFragmentToAddArtFragment("new");
            action.setInfo("new");
            Navigation.findNavController(this,R.id.fragmentContainerView).navigate(action);
        }
        return super.onOptionsItemSelected(item);
    }

}