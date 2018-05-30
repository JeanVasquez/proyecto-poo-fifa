package com.example.miguel_rojas.appmundial.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miguel_rojas.appmundial.Entidades.PersonajesVo;
import com.example.miguel_rojas.appmundial.R;

import java.util.ArrayList;

public class AdaptadorPersonajes extends RecyclerView.Adapter<AdaptadorPersonajes.PersonajesViewHolder> implements View.OnClickListener{
    ArrayList<PersonajesVo> listaPersonajes;
    private View.OnClickListener listener;

    public AdaptadorPersonajes(ArrayList<PersonajesVo> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    @Override
    public PersonajesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        view.setOnClickListener(this);

        return new PersonajesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonajesViewHolder holder, int position) {
        holder.txtNombre.setText(listaPersonajes.get(position).getNombre());
        holder.txtInformacion.setText(listaPersonajes.get(position).getInfo());
        holder.foto.setImageResource(listaPersonajes.get(position).getImagenId());

    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;

    }

 public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }

    }

    public class PersonajesViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre,txtInformacion;
        ImageView foto;

        public PersonajesViewHolder(View itemView) {
            super(itemView);
            txtNombre=(TextView) itemView.findViewById(R.id.idNombre);
            txtInformacion=(TextView) itemView.findViewById(R.id.idInfo);
            foto=(ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}
