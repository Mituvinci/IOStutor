package com.gsl.gsl.iostutor;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {


    private RecyclerView mRecyclerView;
    private AdapterItems mAdapterItem;
    private String[] items = {"Demo","Dhaka","Genusys","Home Office","HR & Admin","PBX_MP","Technical","Undefined","Lab Plexstar"};


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapterItem = new AdapterItems(getActivity(), Arrays.asList(items));
        mRecyclerView.setAdapter(mAdapterItem);
        mAdapterItem.setOnItemClickListener(new AdapterItems.customInterface() {
            @Override
            public void onItemClick(int position, View v) {

                Fragment fragment = DemoFragment.newInstance("fd");
                FragmentManager fragmentManager = getActivity().getFragmentManager();
                FragmentTransaction fragmentTransactionForDetailsFeed = fragmentManager.beginTransaction();
                fragmentTransactionForDetailsFeed.replace(R.id.containerHome, fragment);
                fragmentTransactionForDetailsFeed.addToBackStack(null);
                fragmentTransactionForDetailsFeed.commit();


            }
        });
        return  view;

    }

}
