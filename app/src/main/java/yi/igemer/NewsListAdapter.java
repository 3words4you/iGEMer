package yi.igemer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by yimo on 2017-10-17.
 */

public class NewsListAdapter extends BaseAdapter {
    private Context mContext;
    private List<News> mNewsList;

    public NewsListAdapter(Context mContext, List<News> mNewsList) {
        this.mContext = mContext;
        this.mNewsList = mNewsList;
    }

    @Override
    public int getCount() {
        return mNewsList.size();
    }

    @Override
    public Object getItem(int i) {
        return mNewsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(mContext,R.layout.list_item_news,null);
        ImageView ivLogo = (ImageView)v.findViewById(R.id.ivNewsLogo);
        TextView tvTitle = (TextView)v.findViewById(R.id.tvNewsTitle);
        TextView tvCreatedAt = (TextView)v.findViewById(R.id.tvNewsCreatedAt);
        tvTitle.setText(mNewsList.get(i).getTitle());
        tvCreatedAt.setText(mNewsList.get(i).getCreatedAt());

        String logo = mNewsList.get(i).getLogo();
        Picasso.with(v.getContext()).load(logo).into(ivLogo);
//        ivLogo.setImageResource(R.drawable.mail);
//        Toast.makeText(mContext, logo,Toast.LENGTH_SHORT).show();
        v.setTag(mNewsList.get(i).getNewsID());
        return v;
    }
}
