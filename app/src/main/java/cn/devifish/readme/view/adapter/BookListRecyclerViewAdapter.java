package cn.devifish.readme.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.devifish.readme.R;
import cn.devifish.readme.view.base.BaseRecyclerAdapter;
import cn.devifish.readme.view.base.BaseViewHolder;
import cn.devifish.readme.entity.Book;
import cn.devifish.readme.view.adapter.holder.BookListViewHolder;

import java.util.List;

/**
 * Created by zhang on 2017/2/28.
 *
 * 书架相关功能及数据加载实现逻辑
 * @author zhang
 */

public class BookListRecyclerViewAdapter extends BaseRecyclerAdapter<Book, BookListViewHolder, BaseViewHolder.OnItemClickListener> {

    public BookListRecyclerViewAdapter(List<Book> list) {super(list);}

    @Override
    protected BookListViewHolder onCreateView(ViewGroup group, int viewType) {
        View view = LayoutInflater.from(group.getContext()).inflate(R.layout.book_item_booklist, group, false);
        return new BookListViewHolder(view, getItemClickListener());
    }

    @Override
    protected void onBindView(BookListViewHolder holder, int position) {holder.bind(getItem(position));}

}