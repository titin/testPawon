package com.titinkurniati.pawon;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by Titin Kurniati on 01-Jun-16.
 */
public class TitleListActivity extends Activity {
    private ListView title;
    private ListAdapter adapterList;
    private List<DataModel> dataModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_title);
        title = (ListView) findViewById(R.id.list);
        requestData();
    }

    private void requestData(){
        String url = "http://jsonplaceholder.typicode.com/posts";

        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        System.out.println("Site: " + response.toString());
                        Gson gson = new Gson();
                        dataModels = gson.fromJson(response.toString(),
                                new TypeToken<List<DataModel>>() {
                                }.getType());

                        adapterList = new ListAdapter(TitleListActivity.this,dataModels);
                        title.setAdapter(adapterList);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("", "Error: " + error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(req);
    }
}
