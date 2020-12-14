package mx.com.softwell.fragmentos.gui;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import mx.com.softwell.fragmentos.R;
import mx.com.softwell.fragmentos.gui.components.NavigationHost;

public class AddFragment extends Fragment {


    private Button guardar;
    private Button cancelar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // return inflater.inflate(R.layout.fragment_add, container, false);
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        guardar = view.findViewById(R.id.btnGuardar);
        cancelar = view.findViewById(R.id.btnCancelar);


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "No programado", Toast.LENGTH_SHORT).show();
                ((NavigationHost) getActivity()).navigateTo(new TopJuegos(), true);

            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((NavigationHost) getActivity()).navigateTo(new TopJuegos(), true);

            }
        });
return view;
    }


}
