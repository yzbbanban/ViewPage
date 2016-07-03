package com.wangban.viewpage;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	private Fragment f1;
	private Fragment f2;
	private Fragment f3;

	private TextView tvChat;
	private TextView tvFound;
	private TextView tvContact;

	private ViewPager mViewPager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> fragments;

	private Resources res;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		res=getResources();
		
		initView();
		
		mViewPager=(ViewPager) findViewById(R.id.vp_viewPage);
		
		//mAdapter=new FragmentAdapter(getSupportFragmentManager(), fragments);
		
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

			@Override
			public int getCount() {
				return fragments.size();
			}

			@Override
			public Fragment getItem(int position) {
				return fragments.get(position);
			}
		};
		
		mViewPager.setAdapter(mAdapter);
		Log.i("supergirl", "setadapter");
		mViewPager.setOnPageChangeListener(new TabOnPageChangeListener());
		Log.i("supergirl", "setOnpage");
		
	}

	private void initView() {

		tvChat = (TextView) findViewById(R.id.tv_chat);
		tvFound = (TextView) findViewById(R.id.tv_found);
		tvContact = (TextView) findViewById(R.id.tv_contact);

		tvChat.setOnClickListener(new tabOnClickListener(0));
		tvFound.setOnClickListener(new tabOnClickListener(1));
		tvContact.setOnClickListener(new tabOnClickListener(2));
		
		fragments = new ArrayList<Fragment>();
		f1 = new CharmainTab01();
		f2 = new CharmainTab02();
		f3 = new CharmainTab03();
		fragments.add(f1);
		fragments.add(f2);
		fragments.add(f3);

	}

	private class tabOnClickListener implements OnClickListener {
		private int index ;

		public tabOnClickListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			mViewPager.setCurrentItem(index);
			Toast.makeText(MainActivity.this, ""+index, Toast.LENGTH_SHORT).show();
			
		}

	}

	private class TabOnPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int arg0) {
			resetTextView();
			switch (arg0) {
			case 0:
				tvChat.setTextColor(res.getColor(R.color.green_color));
				Toast.makeText(MainActivity.this, "the first", Toast.LENGTH_SHORT).show();
				Log.i("supergirl", "the first");
				break;
			case 1:
				tvFound.setTextColor(res.getColor(R.color.green_color));
				Toast.makeText(MainActivity.this, "the second", Toast.LENGTH_SHORT).show();
				Log.i("supergirl", "the second");

				break;
			case 2:
				tvContact.setTextColor(res.getColor(R.color.green_color));
				Toast.makeText(MainActivity.this, "the third", Toast.LENGTH_SHORT).show();
				Log.i("supergirl", "the second");

				break;
			}
		}

	}

	private void resetTextView() {
		tvChat.setTextColor(res.getColor(R.color.black_color));
		tvFound.setTextColor(res.getColor(R.color.black_color));
		tvContact.setTextColor(res.getColor(R.color.black_color));

	}
}
