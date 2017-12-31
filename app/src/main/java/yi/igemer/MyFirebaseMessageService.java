package yi.igemer;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


/**
 * Created by yimo on 2017-12-30.
 */

public class MyFirebaseMessageService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d("FirebaseFrom", "From: " + remoteMessage.getFrom());
        Log.d("FirebaseBody", "Message Notification Body: " + remoteMessage.getNotification().getBody());

        MyNotificationManager m = new MyNotificationManager(getApplicationContext());
        m.showNotification(remoteMessage.getFrom(),remoteMessage.getNotification().getBody(),new Intent(getApplication(),MainActivity.class));
    }

}
