package es.appmaster.swiperefreshlayoutdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import es.appmaster.swiperefreshlayoutdemo.util.StringUtils;

/**
 * List activity
 *
 * @author manolovn
 */
public class ListActivity extends ActionBarActivity implements SwipeRefreshLayout.OnRefreshListener, AbsListView.OnScrollListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout);
        swipeRefreshLayout.setColorScheme(android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light);
        swipeRefreshLayout.setOnRefreshListener(this);
        listView = (ListView) findViewById(R.id.item_list);
        listView.setOnScrollListener(this);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, StringUtils.generateStrings(40));
        listView.setAdapter(adapter);

        swipeRefreshLayout.setEnabled(false);
    }

    // SwipeRefreshLayout callback

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 3000);
    }

    // ListView callbacks

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
        // empty method
    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem == 0) {
            swipeRefreshLayout.setEnabled(true);
        } else {
            swipeRefreshLayout.setEnabled(false);
        }
    }

}
