package com.example.xiaoxiao.ruituan;

import android.app.Activity;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabTwoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabOneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TabTwoFragment newInstance(String param1, String param2) {
        TabTwoFragment fragment = new TabTwoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public TabTwoFragment() {
        // Required empty public constructor
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

        view = inflater.inflate(R.layout.fragment_tab_two, container, false);
        TextView text1 = (TextView) view.findViewById(R.id.oldprice1);
        TextView text2 = (TextView) view.findViewById(R.id.oldprice2);
        TextView text3 = (TextView) view.findViewById(R.id.oldprice3);
        TextView text4 = (TextView) view.findViewById(R.id.oldprice4);

        text1.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        text2.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        text3.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        text4.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        return view;




    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
