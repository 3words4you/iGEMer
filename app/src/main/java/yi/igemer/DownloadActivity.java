package yi.igemer;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DownloadActivity extends AppCompatActivity {
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        iv = (ImageView) findViewById(R.id.img_downloaded_picture);
    }

    public void downloadClick(View v){
        FileDownloadTask downloadTask = new FileDownloadTask("http://oxuf82agx.bkt.clouddn.com/banner.jpg",this,iv);
        downloadTask.execute();
    }
}
