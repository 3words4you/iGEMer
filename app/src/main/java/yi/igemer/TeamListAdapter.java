package yi.igemer;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by yimo on 2017-12-30.
 */

public class TeamListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Team> mTeamList;
    private TextView tvName,tvRegion,tvCountry,tvTrack,tvKind,tvAbstract;

    public TeamListAdapter(Context mContext, List<Team> mTeamList) {
        this.mContext = mContext;
        this.mTeamList = mTeamList;
    }

    @Override
    public int getCount() {
        return mTeamList.size();
    }

    @Override
    public Object getItem(int i) {
        return mTeamList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(mContext,R.layout.list_item_team,null);
        tvName = (TextView)v.findViewById(R.id.txt_team_list_name);
        tvRegion = (TextView)v.findViewById(R.id.txt_team_list_region);
        tvCountry = (TextView)v.findViewById(R.id.txt_team_list_country);
        tvKind = (TextView)v.findViewById(R.id.txt_team_list_kind);
        tvTrack = (TextView)v.findViewById(R.id.txt_team_list_track_value);
        tvAbstract = (TextView)v.findViewById(R.id.txt_team_list_abstract_value);

        tvName.setText(mTeamList.get(i).getName());
        tvRegion.setText(mTeamList.get(i).getRegion());
        tvCountry.setText(mTeamList.get(i).getCountry());
        tvKind.setText(mTeamList.get(i).getKind());
        tvTrack.setText(mTeamList.get(i).getTrack());
        tvAbstract.setText(mTeamList.get(i).getDescription());
        v.setTag(mTeamList.get(i).getTeamID());
        return v;
    }
}
