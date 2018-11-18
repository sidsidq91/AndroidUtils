package personal.com.sample.Utils.NetWorking;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class VolleyStringRequest {

    public static StringRequest volleyStringRequest(String url){
        StringRequest request = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        /*
                          response is the raw response from internet
                          data can ber managed with json parser or xml parser form here
                         */
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error can be reported to the user
                        error.getMessage();
                    }
                }
        );
        return request;
    }

    public static void volleyRequest(Context context, String url){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(volleyStringRequest(url));
    }
}
