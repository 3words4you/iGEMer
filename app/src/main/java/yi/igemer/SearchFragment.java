package yi.igemer;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by yimo on 2018-01-01.
 */

public class SearchFragment extends Fragment {
    private Button btnShowAll;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment,container,false);
        final Context thisContext = container.getContext();

        //set up click event
        btnShowAll = (Button) view.findViewById(R.id.btn_show_all_team);
        btnShowAll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),TeamListActivity.class);
                startActivity(i);
            }
        });

        return view;
    }
}
