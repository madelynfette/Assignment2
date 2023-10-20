package com.example.assignment2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListViewFragment extends Fragment {

    ListView listView;
    private TickerViewModel mViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ListViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListViewFragment newInstance(String param1, String param2) {
        ListViewFragment fragment = new ListViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentList = inflater.inflate(R.layout.fragment_list_view,container,false);
        listView = fragmentList.findViewById(R.id.list_view);
        LinkedList<Ticker> tickers = new LinkedList<>();


        ArrayAdapter<Ticker> adapter = new ArrayAdapter<Ticker>(getActivity(), android.R.layout.simple_list_item_1,tickers);
        listView.setAdapter(adapter);
        return fragmentList;

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInsuranceState){
        super.onActivityCreated(savedInsuranceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(TickerViewModel.class);
        mViewModel.getTickers().observe(getViewLifecycleOwner(), new Observer<LinkedList<Ticker>>() {
            @Override
            public void onChanged(LinkedList<Ticker> tickers) {

            ArrayAdapter<Ticker> adapter = new ArrayAdapter<Ticker>(getActivity(), android.R.layout.simple_list_item_1, tickers);
            listView.setAdapter(adapter);

            }
        });
    }

}