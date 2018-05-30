package com.example.miguel_rojas.appmundial.fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.miguel_rojas.appmundial.Adapters.AdaptadorPersonajes;
import com.example.miguel_rojas.appmundial.Entidades.PersonajesVo;
import com.example.miguel_rojas.appmundial.Interface.IComunicaFragments;
import com.example.miguel_rojas.appmundial.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EstadiosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EstadiosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EstadiosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<PersonajesVo> listaPersonajes;
    RecyclerView recyclerPersonajes;

    Activity activity;
    IComunicaFragments interfaceComunicaFragments;

    public EstadiosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EstadiosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EstadiosFragment newInstance(String param1, String param2) {
        EstadiosFragment fragment = new EstadiosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista=inflater.inflate(R.layout.fragment_estadios, container, false);

        listaPersonajes= new ArrayList<>();
        recyclerPersonajes=vista.findViewById(R.id.recyclerId);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarListaPersonajes();

        AdaptadorPersonajes adapter=new AdaptadorPersonajes(listaPersonajes);
        recyclerPersonajes.setAdapter(adapter);

       adapter.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {

                Toast.makeText(getContext(),"Selecciona: "+listaPersonajes.get(recyclerPersonajes.getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_SHORT).show();

                interfaceComunicaFragments.enviarPersonaje(listaPersonajes.get(recyclerPersonajes.getChildAdapterPosition(view)));

            }
        });
        return vista;

    }

    public void llenarListaPersonajes(){
        listaPersonajes.add(new PersonajesVo("Ekaterimburgo",getString(R.string.Ekaterimburgo_port),getString(R.string.Ekaterimburgo_des),R.drawable.ekati,R.drawable.ekati));
        listaPersonajes.add(new PersonajesVo("Cosmos",getString(R.string.cosmos_port),getString(R.string.cosmos_des),R.drawable.co,R.drawable.co));
        listaPersonajes.add(new PersonajesVo("Kaliningrado",getString(R.string.Kaliningrado_port),getString(R.string.Kaliningrado_des),R.drawable.cali,R.drawable.cali));
        listaPersonajes.add(new PersonajesVo("krestovski",getString(R.string.krestovski_port),getString(R.string.krestovski_des),R.drawable.crev,R.drawable.crev));
        listaPersonajes.add(new PersonajesVo("kazan",getString(R.string.kazan_port),getString(R.string.kazan_des),R.drawable.cas,R.drawable.cas));
        listaPersonajes.add(new PersonajesVo("luzhniki",getString(R.string.luzhniki_port),getString(R.string.luzhniki_des),R.drawable.cus,R.drawable.cus));
        listaPersonajes.add(new PersonajesVo("mordovia",getString(R.string.mordovia_port),getString(R.string.mordovia_des),R.drawable.mor,R.drawable.mor));
        listaPersonajes.add(new PersonajesVo("novgorod",getString(R.string.novgorod_port),getString(R.string.novgorod_des),R.drawable.no,R.drawable.no));

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


        if(context instanceof Activity){

            this.activity=(Activity)context;
            interfaceComunicaFragments= (IComunicaFragments) this.activity;

        }



        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
