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
import android.widget.LinearLayout;

/**
 * Created by yimo on 2017-10-18.
 */

public class MeFragment extends Fragment {
    private LinearLayout lyPicture,lyAbout,lyContact;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me_fragment,container,false);
        final Context thisContext = container.getContext();

        //set up tab click
        lyPicture = (LinearLayout) view.findViewById(R.id.linearLayout_Picture);
        lyPicture.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),DownloadActivity.class);
                startActivity(i);
            }
        });

        lyContact = (LinearLayout) view.findViewById(R.id.linearLayout_Contact);
        lyContact.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String phone = "+5197296682";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });

        lyAbout = (LinearLayout) view.findViewById(R.id.linearLayout_About);
        lyAbout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String url = "http://www.conestogac.on.ca";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        return view;
    }
}
