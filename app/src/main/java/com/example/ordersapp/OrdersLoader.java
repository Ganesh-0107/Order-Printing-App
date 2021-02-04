package com.example.ordersapp;
import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Loads a list of sports news by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class OrdersLoader extends AsyncTaskLoader<List<orders>> {

    /** Tag for log messages */
    private static final String LOG_TAG = OrdersLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /**
     * Constructs a new {@link OrdersLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public OrdersLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<orders> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of sports.
        List<orders> orders = QueryUtils.fetchOrdersData(mUrl);
        return orders;
    }
}