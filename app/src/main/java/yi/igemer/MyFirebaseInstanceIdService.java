package yi.igemer;

import android.os.AsyncTask;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by yimo on 2017-12-30.
 * dtC9_werVis:APA91bE6qTN2xkXld0Qq917xQxL72TN6_4VleDXc9J7EjWSE4vm0b9FAdp6HNooz0b14Y35wjknsPvg7ao6k8aYvbsEDHxCzA0Hjg_kCImw1Oua3ul-92sVI1AKWbmBWiP3RuAeeyMGf
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("FirebaseToken", "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendTokenToServer(refreshedToken);
    }

    private void sendTokenToServer(String token){
        final String params = formatDataAsJSON(token);

        new AsyncTask<Void,Void,String>(){

            @Override
            protected String doInBackground(Void... voids) {
                return getServerResponse(params);
            }

            @Override
            protected void onPostExecute(String result) {
                Log.d("sendToken",result);
            }
        }.execute();
    }

    private String formatDataAsJSON(String token){
        JSONObject params = new JSONObject();
        try {
            params.put("token",token);
            return params.toString();
        } catch (JSONException e) {
            Log.d("format","Format token to JSON failed");
        }
        return null;
    }

    private String getServerResponse(String params){
        Log.d("params",params);
//        HttpPost post = new HttpPost("http://10.0.2.2:3010/api/token/addToken");
        HttpPost post = new HttpPost("http://112.124.98.9:3010/api/token/addToken");
        try {
            StringEntity entity = new StringEntity(params);
            post.setEntity(entity);
            post.setHeader("Content-type","application/json");
            DefaultHttpClient client = new DefaultHttpClient();
            BasicResponseHandler handler = new BasicResponseHandler();
            String response = client.execute(post,handler);
            return response;
        } catch (UnsupportedEncodingException e) {
            Log.d("res",e.toString());
        } catch (ClientProtocolException e) {
            Log.d("res",e.toString());
        } catch (IOException e) {
            Log.d("res",e.toString());
        }
        return "contact to server failed";
    }
}
