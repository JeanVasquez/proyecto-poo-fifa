package com.example.miguel_rojas.appmundial;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.miguel_rojas.appmundial.Entidades.PersonajesVo;
import com.example.miguel_rojas.appmundial.Interface.IComunicaFragments;
import com.example.miguel_rojas.appmundial.fragments.DetallesPersonajes;
import com.example.miguel_rojas.appmundial.fragments.EquiposFragment;
import com.example.miguel_rojas.appmundial.fragments.EstadiosFragment;
import com.example.miguel_rojas.appmundial.fragments.GruposFragment;
import com.example.miguel_rojas.appmundial.fragments.MapasFragment;
import com.example.miguel_rojas.appmundial.fragments.PartidosFragment;
import com.example.miguel_rojas.appmundial.fragments.ResultadosFragment;

public class Home extends AppCompatActivity implements EstadiosFragment.OnFragmentInteractionListener,
        DetallesPersonajes.OnFragmentInteractionListener, IComunicaFragments {

    EstadiosFragment listaFragament;
    DetallesPersonajes detalleFragment;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listaFragament=new EstadiosFragment();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
     //   getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,listaFragament).commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void enviarPersonaje(PersonajesVo personajesVo) {
        detalleFragment = new DetallesPersonajes();
        Bundle bundleEnvio=new Bundle();
        bundleEnvio.putSerializable("objeto",personajesVo);
        detalleFragment.setArguments(bundleEnvio);


      getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor,detalleFragment).addToBackStack(null).commit();


    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_home, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){

                case 0:
                    GruposFragment gruposFragment=new GruposFragment();
                    return gruposFragment;
                case 1:
                    MapasFragment mapasFragment= new MapasFragment();
                    return mapasFragment;
                case 2:
                    EstadiosFragment estadiosFragment=new EstadiosFragment();
                    return estadiosFragment;
                case 3:
                    EquiposFragment equiposFragment=new EquiposFragment();
                    return equiposFragment;
                case 4:
                    PartidosFragment partidosFragment=new PartidosFragment();
                    return partidosFragment;
                case 5:
                    ResultadosFragment resultadosFragment=new ResultadosFragment();
                    return resultadosFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 6;
        }
    }
    public CharSequence getPageTitle(int position){
        switch (position){

            case 0:
                return "Grupos";
            case 1:
                return "Mapas";
            case 2:
                return "Estadios";
            case 3:
                return "Equipos";
            case 4:
                return "Partidos";
            case 5:
                return "Resultados";
        }

        return null;
    }
}
