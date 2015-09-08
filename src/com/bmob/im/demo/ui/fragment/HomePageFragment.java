package com.bmob.im.demo.ui.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.SimpleAdapter;
import cn.bmob.im.bean.BmobChatUser;
import cn.bmob.im.bean.BmobRecent;
import cn.bmob.im.db.BmobDB;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobQuery.CachePolicy;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SQLQueryListener;

import com.bmob.im.demo.R;
import com.bmob.im.demo.adapter.BookListAdapter;
import com.bmob.im.demo.adapter.MessageRecentAdapter;
import com.bmob.im.demo.bean.Book;
import com.bmob.im.demo.ui.ChatActivity;
import com.bmob.im.demo.ui.FragmentBase;


/*
 * created by xiangzhang
 * 
 */
public class HomePageFragment extends FragmentBase implements OnItemClickListener,OnItemLongClickListener{
	
	ListView listview;	
	BookListAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_homepage, container, false);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initView();
	}
	
	private void initView(){
		initTopBarForOnlyTitle("Ê×Ò³");
		listview = (ListView)findViewById(R.id.book_list);
		listview.setOnItemClickListener(this);
		listview.setOnItemLongClickListener(this);
		adapter = new BookListAdapter(getActivity(), R.layout.item_booklist, getBookList());
		listview.setAdapter(adapter);
	}
	
	private List<Book> list = new ArrayList<Book>();
	private List<Book> getBookList()
	{
		//------------»º´æ²éÑ¯------------------------------------------------------------
		BmobQuery<Book> query = new BmobQuery<Book>();		
		query.findObjects(getActivity(),new FindListener<Book>(){

			@Override
			public void onError(int arg0, String arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<Book> arg0) {
				// TODO Auto-generated method stub
				list = arg0;				
				for (Book g: list)
				{
					System.out.println("hello");
				}
			}});
		return list;
	}
	
	@Override
	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
	}
	
	private boolean hidden;
	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
		this.hidden = hidden;
		if(!hidden){
			refresh();
		}
	}
	
	public void refresh(){
		try {
			getActivity().runOnUiThread(new Runnable() {
				public void run() {
					adapter = new BookListAdapter(getActivity(), R.layout.item_booklist, getBookList());
					listview.setAdapter(adapter);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if(!hidden){
			refresh();
		}
	}
	
}
