package com.zhang.readme.view;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.zhang.readme.R;
import com.zhang.readme.entity.Chapter;
import com.zhang.readme.provider.ChapterProvider;
import com.zhang.readme.util.ProviderUtil;

import java.util.ArrayList;

public class ReadActivity extends AppCompatActivity {

    private ArrayList<Chapter> list;
    private int index;
    private TextView title;
    private TextView text;
    private ProgressBar progressBar;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        //获取内容信息
        list = this.getIntent().getParcelableArrayListExtra("chapter_list");
        index = this.getIntent().getIntExtra("chapter_index", -1);
        initView();
        new ChapterDataInit().execute(list.get(index).getUrl());
    }

    /**
     * 初始化View对象
     */
    private void initView() {
        title = (TextView) findViewById(R.id.read_title);
        text = (TextView) findViewById(R.id.read_text);
        progressBar = (ProgressBar) findViewById(R.id.read_progressBar);
        scrollView = (ScrollView) findViewById(R.id.read_context_layout);
    }

    private class ChapterDataInit extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... strings) {
            Log.i("text_path", strings[0]);
            ChapterProvider provider = ProviderUtil.Builder(ProviderUtil.PROVIDER_8DUSHU).getChapterProvider(strings[0]);
            return provider.getBookChapterText();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            title.setText(list.get(index).getName());
            text.setText(s);

            scrollView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }
    }
}