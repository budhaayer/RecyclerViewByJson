package csitmnr.recyclerviewbyjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Datum> list = new ArrayList<>();
    RecyclerView recyclerView;

    private static final String url = "http://news.radiodhangadhi.com/api/news/list?_format=json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {


                try {
                    JSONObject object = new JSONObject(s);
                    JSONArray array = object.getJSONArray("data");
                    for (int i=0;i<array.length();i++){
                        JSONObject o = array.getJSONObject(i);

                        int id = o.getInt("id");
                        String title = o.getString("title");
                        String intro = o.getString("intro");
                        String image = o.getString("image");
                        String author = o.getString("author");
                        String dateEn = o.getString("date_en");
                        String dateNp = o.getString("date_np");

                        Datum data = new Datum(id,title,image,intro,author,dateEn,dateNp);
                        list.add(data);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                DatumAdapter adapter = new DatumAdapter(MainActivity.this,list);
                recyclerView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}
