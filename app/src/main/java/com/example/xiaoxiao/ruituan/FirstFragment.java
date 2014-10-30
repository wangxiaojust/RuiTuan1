package com.example.xiaoxiao.ruituan;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class FirstFragment extends Fragment{
    private TextView textView;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View layout = inflater.inflate(R.layout.layout_first, null);
        textView = (TextView) layout.findViewById(R.id.textTextView);
        textView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(getActivity(), "FirstFragment", Toast.LENGTH_SHORT).show();
            }
        });
        listView = (ListView) layout.findViewById(R.id.firstFragmentListView);
        MenuListViewAdapter adapter = new MenuListViewAdapter(getActivity(), DataBuiltUtils.getFirstMapList());
        listView.setAdapter(adapter);
        return layout;
    }
}
