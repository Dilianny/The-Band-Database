package com.example.diana.thebanddatabase;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListActivity extends AppCompatActivity
        implements ListFragment.OnBandSelectedListener{
    //public interface OnBandSelectedListener {
    //  void onBandSelected(int bandId);
    //}

    // implements ListFragment.onClick{
    // Reference to the activity
    // private ListFragment.BandHolder.OnBandSelectedListener mListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.list_fragment_container);

        if (fragment == null) {
            fragment = new ListFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.list_fragment_container, fragment)
                    .commit();
        }
    }

    @Override
    public void onBandSelected(int bandId) {
        // Send the band ID of the clicked button to DetailsActivity
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(DetailsActivity.EXTRA_BAND_ID, bandId);
        startActivity(intent);
    }
}

