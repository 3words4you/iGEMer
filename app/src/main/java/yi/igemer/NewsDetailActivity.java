package yi.igemer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class NewsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        //init values
        Bundle b = getIntent().getExtras();
        int newsID =b.getInt("newsID");
        DatabaseHelper db = new DatabaseHelper(this);
        News news = db.getNewsDetail(newsID);

        TextView tvTitle = (TextView)findViewById(R.id.tvNewsTitle);
        TextView tvDesc = (TextView)findViewById(R.id.tvNewsDetailDescription);
        ImageView ivLogo = (ImageView)findViewById(R.id.ivNewsDetailLogo);

        tvTitle.setText(news.getTitle());
        tvDesc.setText(news.getDescription());
        Picasso.with(this).load(news.getLogo()).into(ivLogo);
    }

    public void backToMain(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
