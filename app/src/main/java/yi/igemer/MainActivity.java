package yi.igemer;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int[] mImages = {R.drawable.test, R.drawable.test,R.drawable.test,R.drawable.test};
    private List<ImageView> mList;
    Handler mHandler = new Handler();

    private TextView tabHome;
    private TextView tabSearch;
    private TextView tabNews;
    private TextView tabMe;

    private FrameLayout ly_content;

    private HomeFragment fHome,fSearch,fNews,fMe;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        final LinearLayout pointGroup = (LinearLayout) findViewById(R.id.pointgroup);

        mList = new ArrayList<>();
        for (int i = 0; i < mImages.length; i++) {
            ImageView imageView = new ImageView(this);

            imageView.setImageResource(mImages[i]);

            mList.add(imageView);

            // make point
            ImageView pointImage = new ImageView(this);
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

        viewPager.setAdapter(new MyAdapter());

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

    //UI组件初始化与事件绑定
    private void bindView() {
        tabHome = (TextView)this.findViewById(R.id.txt_home);
        tabSearch = (TextView)this.findViewById(R.id.txt_search);
        tabMe = (TextView)this.findViewById(R.id.txt_me);
        tabNews = (TextView)this.findViewById(R.id.txt_news);
        ly_content = (FrameLayout) findViewById(R.id.fragment_container);

        tabHome.setOnClickListener((View.OnClickListener) this);
        tabNews.setOnClickListener((View.OnClickListener) this);
        tabMe.setOnClickListener((View.OnClickListener) this);
        tabSearch.setOnClickListener((View.OnClickListener) this);

    }

    //重置所有文本的选中状态
    public void selected(){
        tabHome.setSelected(false);
        tabNews.setSelected(false);
        tabSearch.setSelected(false);
        tabMe.setSelected(false);
    }

    //隐藏所有Fragment
    public void hideAllFragment(FragmentTransaction transaction){
        if(fHome!=null){
            transaction.hide(fHome);
        }
        if(fSearch!=null){
            transaction.hide(fSearch);
        }
        if(fNews!=null){
            transaction.hide(fNews);
        }
        if(fMe!=null){
            transaction.hide(fMe);
        }
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch(v.getId()){
            case R.id.txt_home:
                selected();
                tabHome.setSelected(true);
                if(fHome==null){
                    fHome = new HomeFragment("homeFragment");
                    transaction.add(R.id.fragment_container,fHome);
                }else{
                    transaction.show(fHome);
                }
                break;

            case R.id.txt_search:
                selected();
                tabSearch.setSelected(true);
                if(fSearch==null){
                    fSearch = new HomeFragment("searchFragment");
                    transaction.add(R.id.fragment_container,fSearch);
                }else{
                    transaction.show(fSearch);
                }
                break;

            case R.id.txt_news:
                selected();
                tabNews.setSelected(true);
                if(fNews==null){
                    fNews = new HomeFragment("newsFragment");
                    transaction.add(R.id.fragment_container,fNews);
                }else{
                    transaction.show(fNews);
                }
                break;

            case R.id.txt_me:
                selected();
                tabMe.setSelected(true);
                if(fMe==null){
                    fMe = new HomeFragment("meFragment");
                    transaction.add(R.id.fragment_container,fMe);
                }else{
                    transaction.show(fMe);
                }
                break;
        }

        transaction.commit();
    }
}
