package yi.igemer;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yimo on 2017-10-04.
 */

public class HomeFragment extends Fragment {
    private String content;
    private TextView mTextView;
    private ListView newsListView;
    private List<News> newsList;
    private NewsListAdapter newsAdapter;

    private int[] mImages = {R.drawable.test, R.drawable.test,R.drawable.test,R.drawable.test};
    private List<ImageView> mList;
    Handler mHandler = new Handler();

    public HomeFragment(String content){
        this.content = content;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
//        mTextView = (TextView)view.findViewById(R.id.txt_content);
//        mTextView.setText(context);

        final Context thisContext = container.getContext();

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        final LinearLayout pointGroup = (LinearLayout) view.findViewById(R.id.pointgroup);

        mList = new ArrayList<>();
        for (int i = 0; i < mImages.length; i++) {
            ImageView imageView = new ImageView(thisContext);

            imageView.setImageResource(mImages[i]);

            mList.add(imageView);

            // make point
            ImageView pointImage = new ImageView(thisContext);
            pointImage.setImageResource(R.drawable.shape_point_selector);

            // set point
            int PointSize = getResources().getDimensionPixelSize(R.dimen.point_size);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(PointSize, PointSize);

            if (i > 0) {
                params.leftMargin = getResources().getDimensionPixelSize(R.dimen.point_margin);
                pointImage.setSelected(false);
            } else {
                pointImage.setSelected(true);
            }
            pointImage.setLayoutParams(params);
            // add to container
            pointGroup.addView(pointImage);
        }

        viewPager.setAdapter(new HomeFragment.MyAdapter());

        // ViewPager set listener
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            int lastPosition;
            @Override
            public void onPageSelected(int position) {

                // modify position
                position = position % mList.size();

                // set current selected page
                pointGroup.getChildAt(position).setSelected(true);
                // set pre selected page unselected
                pointGroup.getChildAt(lastPosition).setSelected(false);

                // change position
                lastPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int currentPosition = viewPager.getCurrentItem();

                if(currentPosition == viewPager.getAdapter().getCount() - 1){
                    // last page
                    viewPager.setCurrentItem(0);
                }else{
                    viewPager.setCurrentItem(currentPosition + 1);
                }

                mHandler.postDelayed(this,3000);
            }
        },3000);


        //set up list view news
        newsListView = (ListView)view.findViewById(R.id.lvNews);

        newsList = new ArrayList<>();
        newsList.add(new News(1,"Title1","2017-01-02 10:23:12","http://icons.iconarchive.com/icons/graphicloads/medical-health/96/dna-icon.png"));
        newsList.add(new News(2,"Title2","2017-01-02 10:23:12","http://icons.iconarchive.com/icons/iconshock/real-vista-education/128/laboratory-icon.png"));
        newsList.add(new News(3,"Title3","2017-01-02 10:23:12","http://icons.iconarchive.com/icons/icons8/ios7/96/Healthcare-Virus-icon.png"));

        newsAdapter = new NewsListAdapter(thisContext,newsList);
//        newsAdapter.notifyDataSetChanged();
        newsListView.setAdapter(newsAdapter);

        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(view.getContext(), NewsDetailActivity.class);
                startActivity(intent);
            }
        });



        return view;
    }

    private class MyAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // return super.instantiateItem(container, position);

            position = position % mList.size();
            container.addView(mList.get(position));

            return mList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }
}