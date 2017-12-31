package yi.igemer;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by yimo on 2017-12-30.
 * dwLT_iIm_7c:APA91bE6QAMTSI52LQqgUmjwURb99OlAyo2-X3GFfulZ3WrF8eBED6PcjWdG-ZmPlTAh-Z3DdKy-3sQFfcOi3L5G8Fan43OI5gErSPUaabMubaojcwaDt0qFeJvnyntBvUZytHyf-vmA
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

    }
}
