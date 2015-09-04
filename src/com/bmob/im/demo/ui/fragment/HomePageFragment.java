package com.bmob.im.demo.ui.fragment;

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
import cn.bmob.v3.listener.SQLQueryListener;

import com.bmob.im.demo.R;
import com.bmob.im.demo.adapter.BookListAdapter;
import com.bmob.im.demo.adapter.MessageRecentAdapter;
import com.bmob.im.demo.bean.Book;
import com.bmob.im.demo.ui.ChatActivity;
import com.bmob.im.demo.ui.FragmentBase;
import com.bmob.im.demo.view.ClearEditText;
import com.bmob.im.demo.view.dialog.DialogTips;


/*
 * created by xiangzhang
 * 
 */
public class HomePageFragment extends FragmentBase implements OnItemClickListener,OnItemLongClickListener{

	ClearEditText mClearEditText;
	
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
		initTopBarForOnlyTitle("会话");
		listview = (ListView)findViewById(R.id.book_list);
		listview.setOnItemClickListener(this);
		listview.setOnItemLongClickListener(this);
		//adapter = new BookListAdapter(getActivity(), R.layout.item_booklist, getBookList());
		listview.setAdapter(adapter);
		

	}
	
	private void getBookList()
	{
		//------------缓存查询------------------------------------------------------------
		String sql = "select bookName from Book;";
		BmobQuery<Book> query = new BmobQuery<Book>();
		query.setSQL(sql);		
		//执行SQL查询操作
		query.doSQLQuery(getActivity(), sql, new SQLQueryListener<Book>(){
			@Override
			public void done(BmobQueryResult<Book> result, BmobException e) {
				// TODO Auto-generated method stub
				if(e ==null){
					List<Book> list = (List<Book>) result.getResults();
					if(list!=null && list.size()>0){
						for(int i=0;i<list.size();i++){
							Book p = list.get(i);
							Log.i("smile", " "+p.getBookName());
						}
					}else{
						Log.i("smile", "查询成功，无数据返回");
					}
				}else{
					Log.i("smile", "错误码："+e.getErrorCode()+"，错误描述："+e.getMessage());
				}
			}
		});
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
					//adapter = new BookListAdapter(, R.layout.item_booklist, getBookList());
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
