package com.gsl.gsl.iostutor;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * A simple {@link Fragment} subclass.
 */
public class DemoFragment extends Fragment {

    private TextView mTextViewTitle;
    private TextView mTextViewDemo;
    private static String file;


    public DemoFragment() {
        // Required empty public constructor
    }


    public static DemoFragment newInstance(String param12) {
        DemoFragment fragment = new DemoFragment();
        file = param12;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_demo, container, false);
        mTextViewTitle = (TextView) view.findViewById(R.id.textViewTitle);

        mTextViewDemo = (TextView) view.findViewById(R.id.codeText);

        String FileName =  file.replace(".txt","");
        mTextViewTitle.setText(FileName);
        try {
            String mString =  readFromAssets(getActivity(),file);
            mTextViewDemo.setText(mString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  view;

    }

    public static String readFromAssets(Context context, String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(filename)));

        // do reading, usually loop until end of file reading
        StringBuilder sb = new StringBuilder();
        String mLine = reader.readLine();
        int i=0;
        while (mLine != null) {
            sb.append(mLine+"\n"); // process line
            mLine = reader.readLine();
            // Log.d("mLine",mLine);

        }
        reader.close();
        return sb.toString();
    }

}
