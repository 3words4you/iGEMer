package yi.igemer;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
//        viewPager.setAdapter(new MyAdapter());
//    }
//
//    class MyAdapter extends PagerAdapter {
//
//        // page number
//        @Override
//        public int getCount() {
//            return 5;
//        }
//
//        @Override
//        public boolean isViewFromObject(View view, Object object) {
//            return view == object;
//        }
//
//        // init
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            // return super.instantiateItem(container, position);
//            TextView tv = new TextView(MainActivity.this);
//            tv.setGravity(Gravity.CENTER);
//            tv.setTextSize(20);
//            tv.setText("This is test view pager: " + position + "/4 --> scroll");
//            ImageView iv = new ImageView(MainActivity.this);
//
//            switch (position) {
//                case 0:
//                    tv.setBackgroundResource(R.drawable.test);
//                    tv.setHeight(200);
//                    tv.hei
//                    tv.layo
//                    break;
//                case 1:
//                    tv.setBackgroundColor(Color.RED);
//                    break;
//                case 2:
//                    tv.setBackgroundColor(Color.YELLOW);
//                    break;
//                case 3:
//                    tv.setBackgroundColor(Color.BLUE);
//                    break;
//                case 4:
//                    tv.setBackgroundColor(Color.CYAN);
//                    break;
//
//            }
//
//            // add to ViewPager container
//            container.addView(tv);
//
//            // return view
//            return tv;
//        }
//
//
//        // destroy object
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            // super.destroyItem(container, position, object);
//            container.removeView((View) object);
//        }
//    }≥
// 图片资源
private int[] mImages = {R.drawable.test, R.drawable.test,R.drawable.test,R.drawable.test};
    private List<ImageView> mList;
    Handler mHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
