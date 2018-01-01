package yi.igemer;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
//
//    private List<ImageView> mList;
//    Handler mHandler = new Handler();

    public TextView tabHome;
    public TextView tabSearch;
    public TextView tabNews;
    public TextView tabMe;

    private FrameLayout ly_content;

    public HomeFragment fHome;
    public SearchFragment fSearch;
    public MeFragment fMe;
    public NewsFragment fNews;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();

        //show fragment
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        selected();

        Bundle b = getIntent().getExtras();
        if(b!=null){
            String tabShow =b.getString("tab");
            switch(tabShow){
                case "tabNews":
                    tabNews.setSelected(true);
                    if(fNews==null){
                        fNews = new NewsFragment();
                        transaction.add(R.id.fragment_container,fNews);
                    }else{
                        transaction.show(fNews);
                    }
                    transaction.commit();
                    break;
                case "tabSearch":
                    tabSearch.setSelected(true);
                    if(fSearch==null){
                        fSearch = new SearchFragment();
                        transaction.add(R.id.fragment_container,fSearch);
                    }else{
                        transaction.show(fSearch);
                    }
                    transaction.commit();
                    break;
                default:
                    tabHome.setSelected(true);
                    if(fHome==null){
                        fHome = new HomeFragment();
                        transaction.add(R.id.fragment_container,fHome);
                    }else{
                        transaction.show(fHome);
                    }
                    transaction.commit();
            }
        }
        else{
            tabHome.setSelected(true);
            if(fHome==null){
                fHome = new HomeFragment();
                transaction.add(R.id.fragment_container,fHome);
            }else{
                transaction.show(fHome);
            }
            transaction.commit();
        }


    }

    //UI init and bind event
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

    //reset selected
    public void selected(){
        tabHome.setSelected(false);
        tabNews.setSelected(false);
        tabSearch.setSelected(false);
        tabMe.setSelected(false);
    }

    //hide all Fragment
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
                    fHome = new HomeFragment();
                    transaction.add(R.id.fragment_container,fHome);
                }else{
                    transaction.show(fHome);
                }
                break;

            case R.id.txt_search:
                selected();
                tabSearch.setSelected(true);
                if(fSearch==null){
                    fSearch = new SearchFragment();
                    transaction.add(R.id.fragment_container,fSearch);
                }else{
                    transaction.show(fSearch);
                }
                break;

            case R.id.txt_news:
                selected();
                tabNews.setSelected(true);
                if(fNews==null){
                    fNews = new NewsFragment();
                    transaction.add(R.id.fragment_container,fNews);
                }else{
                    transaction.show(fNews);
                }
                break;

            case R.id.txt_me:
                selected();
                tabMe.setSelected(true);
                if(fMe==null){
                    fMe = new MeFragment();
                    transaction.add(R.id.fragment_container,fMe);
                }else{
                    transaction.show(fMe);
                }
                break;
        }

        transaction.commit();
    }
}
