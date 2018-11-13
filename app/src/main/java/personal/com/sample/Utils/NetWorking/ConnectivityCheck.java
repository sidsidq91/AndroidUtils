package personal.com.sample.Utils.NetWorking;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.jetbrains.annotations.NotNull;

class ConnectivityCheck {
    public static boolean checkConnection(@NotNull Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }
}
