package com.bmob.im.demo.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.bmob.im.bean.BmobChatUser;

import com.bmob.im.demo.R;
import com.bmob.im.demo.adapter.base.BaseListAdapter;
import com.bmob.im.demo.adapter.base.ViewHolder;
import com.bmob.im.demo.bean.BmobBook;
import com.bmob.im.demo.util.ImageLoadOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class BookListAdapter extends BaseListAdapter<BmobBook>{

	public BookListAdapter(Context context, List<BmobBook> list) {
		super(context, list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View bindView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_booklist, null);
		}
		final BmobBook book = getList().get(arg0);
		TextView tv_book_name = ViewHolder.get(convertView, R.id.tv_friend_name);
		ImageView iv_avatar = ViewHolder.get(convertView, R.id.img_friend_avatar);
		String avatar = book.getBookImage();
		if (avatar != null && !avatar.equals("")) {
			ImageLoader.getInstance().displayImage(avatar, iv_avatar, ImageLoadOptions.getOptions());
		} else {
			iv_avatar.setImageResource(R.drawable.default_book);
		}
		tv_book_name.setText(book.getBookName());
		return convertView;
		
		return null;
	}

}
