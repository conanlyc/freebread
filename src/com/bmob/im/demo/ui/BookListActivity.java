package com.bmob.im.demo.ui;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import cn.bmob.im.bean.BmobChatUser;

import com.bmob.im.demo.adapter.AddFriendAdapter;
import com.bmob.im.demo.bean.BmobBook;
import com.bmob.im.demo.view.xlist.XListView;
import com.bmob.im.demo.view.xlist.XListView.IXListViewListener;

public class BookListActivity extends ActivityBase implements IXListViewListener,OnItemClickListener {
	
	List<BmobBook> books = new ArrayList<BmobBook>();
	XListView mListView;
	AddFriendAdapter adapter;
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLoadMore() {
		// TODO Auto-generated method stub
		
	}

}
