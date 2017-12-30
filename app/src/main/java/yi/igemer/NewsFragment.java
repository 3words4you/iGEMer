package yi.igemer;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

/**
 * Created by yimo on 2017-10-18.
 */

public class NewsFragment extends Fragment {

    private ListView newsListView;
    private List<News> newsList;
    private NewsListAdapter newsAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment,container,false);
        final Context thisContext = container.getContext();

        //set up list view news
        newsListView = (ListView) view.findViewById(R.id.lvAllNews);

        DatabaseHelper db = new DatabaseHelper(thisContext);
        newsList = db.getNewsList("all");
        newsAdapter = new NewsListAdapter(thisContext,newsList);
        newsListView.setAdapter(newsAdapter);

        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), NewsDetailActivity.class);
                Bundle b = new Bundle();
                b.putInt("newsID", Integer.parseInt(view.getTag().toString()));
                intent.putExtras(b);
                startActivity(intent);
            }
        });


        return view;


    }
}
