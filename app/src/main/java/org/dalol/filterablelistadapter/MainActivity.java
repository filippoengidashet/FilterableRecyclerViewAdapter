package org.dalol.filterablelistadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private EditText mSearchField;
    private CheeseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configViews();
        handleList();
        mSearchField.addTextChangedListener(mQueryWatcher);
    }

    private void handleList() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mAdapter = new CheeseAdapter(getLayoutInflater());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void configViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mSearchField = (EditText) findViewById(R.id.searchField);
    }

    private TextWatcher mQueryWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            mAdapter.filter(s.toString());
        }
    };
}
