package com.bmob.im.demo.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.bmob.im.bean.BmobRecent;

import com.bmob.im.demo.bean.Book;

import com.bmob.im.demo.R;
import com.bmob.im.demo.adapter.base.BaseListAdapter;
import com.bmob.im.demo.adapter.base.ViewHolder;
import com.bmob.im.demo.util.ImageLoadOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class BookListAdapter extends ArrayAdapter<Book> {

	private LayoutInflater inflater;
	private List<Book> mData;
	private Context mContext;
	
	public BookListAdapter(Context context, int textViewResourceId, List<Book> objects) {
		super(context, textViewResourceId, objects);
		inflater = LayoutInflater.from(context);
		this.mContext = context;
		mData = objects;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_book_homepage, null);
		}
		final Book book = mData.get(arg0);		
		ImageView iv_avatar = ViewHolder.get(convertView, R.id.book_avatar);
		TextView tv_bookname = ViewHolder.get(convertView, R.id.tv_bookname);
		TextView tv_bookowner = ViewHolder.get(convertView, R.id.tv_bookowner);
		
		String avatar = book.getBookAvater();
		if (avatar != null && !avatar.equals("")) {
			ImageLoader.getInstance().displayImage(avatar, iv_avatar, ImageLoadOptions.getOptions());
		} else {
			iv_avatar.setImageResource(R.drawable.default_head);
		}
		tv_bookname.setText(book.getBookName());
		tv_bookowner.setText("zx");
		//tv_bookowner.setText(book.getUser().getUserName());
		return convertView;
	}

}
