package com.cyq.autoscollview;

import java.util.ArrayList;
import java.util.List;

import com.cyq.autoscollview.ImagePagerAdapter.BannerListener;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class TestActivity extends Activity implements BannerListener{
	private MyBanner myBanner;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		myBanner = (MyBanner) findViewById(R.id.banner);
		List<Object>       imageIdList =new ArrayList<Object>();
		imageIdList.add(new MyBannerBean());
		imageIdList.add(new MyBannerBean());
		imageIdList.add(new MyBannerBean());
		imageIdList.add(new MyBannerBean());
		myBanner.setImgData(imageIdList);
	}

	@Override
	public void click(int position,List<Object> imageList) {
		MyBannerBean m= (MyBannerBean) imageList.get(position);
		Toast.makeText(TestActivity.this, "默认Toast样式"+position+"<-->"+m.getImageurl(),
			     Toast.LENGTH_SHORT).show();
	}



}
