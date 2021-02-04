/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.ordersapp;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class OrdersActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<orders>> {

    private static final String LOG_TAG = OrdersActivity.class.getName();

    private static final String ORDERS_REQUEST_URL =
            "https://script.google.com/macros/s/AKfycbzqETeh7FYbILpKuCGan1NwJh9D6Kc9OSSmkWQ97A-iUF8P786TaSdI/exec";
    /**
     * Constant value for the sports loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int ORDERS_LOADER_ID = 1;

    private OrdersAdapter mAdapter;

    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orders_activity);


        // Find a reference to the {@link ListView} in the layout
        ListView ordersListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        mAdapter = new OrdersAdapter(this, new ArrayList<orders>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        ordersListView.setAdapter(mAdapter);


        // Get a reference to the LoaderManager, in order to interact with loaders.
        LoaderManager loaderManager = getLoaderManager();

        // Initialize the loader. Pass in the int ID constant defined above and pass in null for
        // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
        // because this activity implements the LoaderCallbacks interface).
        loaderManager.initLoader(ORDERS_LOADER_ID, null, this);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        ordersListView.setEmptyView(mEmptyStateTextView);

    }

    @Override
    public Loader<List<orders>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        return new OrdersLoader(this, ORDERS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<orders>> loader, List<orders> orders) {
        // Clear the adapter of previous earthquake data
        mAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (orders != null && !orders.isEmpty()) {
            mAdapter.addAll(orders);
        }
        // Set empty state text to display "No news found."
        mEmptyStateTextView.setText("No orders found.");

        // Hide loading indicator because the data has been loaded
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        // Set empty state text to display "No news found."
        mEmptyStateTextView.setText("No orders found.");

        // Clear the adapter of previous earthquake data
        mAdapter.clear();

        // If there is a valid list of {@link Sports}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (orders != null && !orders.isEmpty()) {
            mAdapter.addAll(orders);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<orders>> loader) {
        // Loader reset, so we can clear out our existing data.
        mAdapter.clear();
    }
}



