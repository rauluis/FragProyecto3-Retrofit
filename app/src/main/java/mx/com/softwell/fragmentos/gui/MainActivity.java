package mx.com.softwell.fragmentos.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

import java.util.HashMap;

import mx.com.softwell.fragmentos.R;
import mx.com.softwell.fragmentos.core.FragmentosApplication;
import mx.com.softwell.fragmentos.gui.components.NavigationHost;

public class MainActivity extends AppCompatActivity implements NavigationHost {

    public static HashMap<String, Object> GLOBALS = new HashMap<>();

    private MaterialButton mnTop;
    private MaterialButton mnRanked;
    private MaterialButton mnFreeToPlay;
        private MaterialButton mnOldSchool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configContext();
        configGlobals();
        configFragmentManager(savedInstanceState);
        mnTop = findViewById(R.id.mnTopJuegos);
        mnRanked = findViewById(R.id.mnTopRanked);
        mnFreeToPlay = findViewById(R.id.mnFreetoPlay);
        mnOldSchool = findViewById(R.id.mnOldSchool);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.appBar);
        setSupportActionBar(myToolbar);

    }

    private void configContext() {
        FragmentosApplication.setAppContext(getApplicationContext());
    }

    private void configGlobals() {
        GLOBALS.put("app", this);
    }

    private void configFragmentManager(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentPanel, new LoginFragment())
                    .commit();
        }
    }

    @Override
    public void navigateTo(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right, R.animator.slide_in_right, R.animator.slide_out_left)
                        .replace(R.id.contentPanel, fragment);
        if (addToBackStack)
            transaction.addToBackStack(null);
        transaction.commit();
    }


    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.mnFreetoPlay:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.contentPanel, new FreeToPlay())
                        .commit();
                break;

            case R.id.mnOldSchool:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.contentPanel, new OldSchool())
                        .commit();

                break;
            case R.id.mnPerfil:
                break;
            case R.id.mnTopJuegos:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.contentPanel, new TopJuegos())
                        .commit();
                break;
            case R.id.mnTopRanked:

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.contentPanel, new Rank())
                        .commit();
                break;


        }

    }
}