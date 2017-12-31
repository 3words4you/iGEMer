package yi.igemer;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;

/**
 * Created by yimo on 2017-12-30.
 */

public class FileDownloadTask extends AsyncTask<String,Integer,String>{

    private String url;
    private ProgressDialog progressDialog;
    private Context mContext;

    public FileDownloadTask(String url,Context context){
        this.url = url;
        this.mContext = context;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setTitle("Download in Progress...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(100);
        progressDialog.setProgress(0);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            URL myurl = new URL(url);
            URLConnection connection = myurl.openConnection();
            connection.connect();

            File rootDirectory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"iGEMer Pictures");
            if(!rootDirectory.exists()){
                rootDirectory.mkdirs();
            }

            String nameOfFile = URLUtil.guessFileName(url,null, MimeTypeMap.getFileExtensionFromUrl(url));
            File file = new File(rootDirectory, nameOfFile);

            InputStream inputStream = connection.getInputStream();
            OutputStream outputStream = new FileOutputStream(file);

            byte[] buffer = new byte[1024];
            int total = 0;
            int count = 0;
            int FILE_LENGTH = connection.getContentLength();
            while((count = inputStream.read(buffer)) != -1 ){
                total += count;
                outputStream.write(buffer,0,count);
                int progress = (int) total*100/FILE_LENGTH;
                publishProgress(progress);
            }
            inputStream.close();
            outputStream.close();

            Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri uri = Uri.fromFile(file);
            intent.setData(uri);
            mContext.sendBroadcast(intent);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Completed";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        progressDialog.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        progressDialog.hide();
        Toast.makeText(mContext,result,Toast.LENGTH_SHORT).show();

    }
}

