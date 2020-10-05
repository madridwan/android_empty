package com.project.bris.emptys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

public class SchemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO : Apa perlu di tambahkan pengecekan kembali sebelum menampilkan view
        //Put the package name here...
        boolean installed = appInstalledOrNot("com.project.bris.emptys");
        if(installed) {
            //This intent will help you to launch if the package is already installed
            setContentView(R.layout.activity_scheme);
        } else {
            // Do whatever we want to do if application not installed
            // For example, Redirect to play store
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.skype.raider")));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.skype.raider")));
            }
        }
    }

    private boolean appInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }
}