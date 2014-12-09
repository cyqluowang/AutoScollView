package com.cyq.autoscollview;

import java.util.ArrayList;
import java.util.List;

import com.cyq.autoscollview.ImagePagerAdapter.BannerListener;

import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MyBanner extends  RelativeLayout{

    private AutoScrollViewPager 					viewPager;
    private List<Object>       					    imageIdList;
    private LinearLayout        					mLinearLayout;
    private List<ImageView>     					dotViewsList;
    private RelativeLayout      					banner;
    private Context            						mContext;
    private long                 					interval            	        = 2000;
    private MyOnPageChangeListener                  myOnPageChangeListener;
    private ImagePagerAdapter 						imagePagerAdapter;
	public  MyBanner(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView(context);
	}

	public MyBanner(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	public MyBanner(Context context) {
		super(context);
		initView(context);
	}

	
	private void initView(Context context){
		mContext = context;
		banner = (RelativeLayout)LayoutInflater.from(context).inflate(R.layout.banner, this, false);
		viewPager = (AutoScrollViewPager)banner.findViewById(R.id.view_pager);
		mLinearLayout = (LinearLayout)banner.findViewById(R.id.linearlayout);
		this.addView(banner);
		
		imageIdList = new ArrayList<Object>();
		myOnPageChangeListener = new MyOnPageChangeListener();
	}
	

	
	 public class MyOnPageChangeListener implements OnPageChangeListener {

	        @Override
	        public void onPageSelected(int position) {
	        	setImageBackground((position) % ListUtils.getSize(imageIdList));
	        }

	        @Override
	        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

	        @Override
	        public void onPageScrollStateChanged(int arg0) {}
	    }
	
    private void setImageBackground(int selectItems){  
        for(int i=0; i<dotViewsList.size(); i++){  
            if(i == selectItems){  
            	dotViewsList.get(i).setBackgroundResource(R.drawable.main_dot_white);  
            }else{  
            	dotViewsList.get(i).setBackgroundResource(R.drawable.main_dot_light);  
            }  
        }  
    } 
    
    private void initDot(){  
    	LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		lp.setMargins(dp2px(mContext,8), 0, 0, 0);
		dotViewsList = new ArrayList<ImageView>();
		for (int i = 0; i < ListUtils.getSize(imageIdList); i++) {
			ImageView viewDot = new ImageView(mContext);
			if (Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2
					% ListUtils.getSize(imageIdList) == i) {
				viewDot.setBackgroundResource(R.drawable.main_dot_white);
			} else {
				viewDot.setBackgroundResource(R.drawable.main_dot_light);
			}
			viewDot.setLayoutParams(lp);
			dotViewsList.add(viewDot);
			mLinearLayout.addView(viewDot);
		}
    } 
    
    
    public void  setInterval(int interval){
    	this.interval = interval;
    	viewPager.setInterval(interval);
    }
    
    public void setImgData(List<Object> imageIdList){
    	if(ListUtils.getSize(imageIdList) > 0){
			this.imageIdList.clear();
			this.imageIdList.addAll(imageIdList);
			initDot();
			imagePagerAdapter = new ImagePagerAdapter(mContext, imageIdList);
			imagePagerAdapter.setInfiniteLoop(true);
			viewPager.setAdapter(imagePagerAdapter);
			viewPager.setOnPageChangeListener(myOnPageChangeListener);
			if (ListUtils.getSize(this.imageIdList) < 2) {
				imagePagerAdapter.setInfiniteLoop(false);
			}
			viewPager.setInterval(interval);
			viewPager.startAutoScroll();
			viewPager.setCurrentItem(Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2
					% ListUtils.getSize(this.imageIdList));
    	}
	}
    
    public void setBannerListener(BannerListener bannerListener){
    	imagePagerAdapter.setBannerListener(bannerListener);
    }
    
    public final static int dp2px(Context context, float dpValue) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * density + 0.5f);
    }
}
