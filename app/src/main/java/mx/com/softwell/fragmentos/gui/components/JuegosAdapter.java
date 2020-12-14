package mx.com.softwell.fragmentos.gui.components;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import mx.com.softwell.fragmentos.R;
import mx.com.softwell.fragmentos.model.Juego;

public class JuegosAdapter extends RecyclerView.Adapter<JuegosAdapter.ViewHolder> {

    private List<Juego> juegos;
    private Context context;

    public JuegosAdapter(List<Juego> juegos) {
        this.juegos = juegos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_juego,parent,false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Juego juego = juegos.get(position);
     //   String imgUri = "@drawable/" + juego.getImagen();
      //  int imgResource = context.getResources().getIdentifier
                //(imgUri,null,context.getPackageName());
       //holder.imgJuego.setImageResource(imgResource);
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(juegos.get(position).getImagen())
                .placeholder(R.drawable.ic_logo)
                .error(R.drawable.ic_error)
                .into(holder.imgJuego);
        holder.txtNombre.setText(juego.getNombre());
        holder.rbClasificacion.setRating(juego.getClasificacion());
        holder.txtDescripcion.setText(juego.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return juegos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private AppCompatImageView imgJuego;
        private TextView txtNombre;
        private AppCompatRatingBar rbClasificacion;
        private TextView txtDescripcion;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgJuego = itemView.findViewById(R.id.imgJuego);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            rbClasificacion =  itemView.findViewById(R.id.rbClasificacion);
            txtDescripcion= itemView.findViewById(R.id.txtDescripcion);
            this.view = itemView;
        }
    }
}
