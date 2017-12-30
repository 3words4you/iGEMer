package yi.igemer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by yimo on 2017-12-30.
 */

public class TeamListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Team> mTeamList;

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
//        ImageView ivLogo = (ImageView)v.findViewById(R.id.ivNewsLogo);
//        TextView tvTitle = (TextView)v.findViewById(R.id.tvNewsTitle);
//        TextView tvCreatedAt = (TextView)v.findViewById(R.id.tvNewsCreatedAt);
//        tvTitle.setText(mNewsList.get(i).getTitle());
//        tvCreatedAt.setText(mNewsList.get(i).getCreatedAt());
//
//        String logo = mNewsList.get(i).getLogo();
//        Picasso.with(v.getContext()).load(logo).into(ivLogo);
        v.setTag(mTeamList.get(i).getTeamID());
        return v;
    }
}
