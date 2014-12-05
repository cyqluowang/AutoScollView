/*
 * Copyright 2014 trinea.cn All right reserved. This software is the confidential and proprietary information of
 * trinea.cn ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with trinea.cn.
 */
package com.cyq.autoscollview;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * ImagePagerAdapter
 * 
 */
public class ImagePagerAdapter extends RecyclingPagerAdapter {

    private Context       			context;
    private List<Object>  			imageIdList;
    private int           			size;
    private boolean       			isInfiniteLoop;
    private BannerListener 			bannerListener ; 

    public ImagePagerAdapter(Context context, List<Object> imageIdList) {
    	if(context instanceof BannerListener){
    		this.bannerListener = (BannerListener)context; 
    	}
        this.context = context;
        this.imageIdList = imageIdList;
        this.size = ListUtils.getSize(imageIdList);
        isInfiniteLoop = false;
    }

    @Override
    public int getCount() {
        return isInfiniteLoop ? Integer.MAX_VALUE : ListUtils.getSize(imageIdList);
    }

    /**
     * get really position
     * 
     * @param position
     * @return
     */
    private int getPosition(int position) {
        return isInfiniteLoop ? position % size : position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup container) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = holder.imageView = new ImageView(context);
            view.setTag(holder);
        } else {
            holder = (ViewHolder)view.getTag();
        }
        holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        MyBannerBean myBannerBean = (MyBannerBean) imageIdList.get(getPosition(position));
        holder.imageView.setImageResource(myBannerBean.getImageurl());
        view.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if(null != bannerListener){
					bannerListener.click(getPosition(position),imageIdList);
				}
			}
		});
        return view;
    }

    private static class ViewHolder {
        ImageView imageView;
    }

    /**
     * @return the isInfiniteLoop
     */
    public boolean isInfiniteLoop() {
        return isInfiniteLoop;
    }

    /**
     * @param isInfiniteLoop the isInfiniteLoop to set
     */
    public ImagePagerAdapter setInfiniteLoop(boolean isInfiniteLoop) {
        this.isInfiniteLoop = isInfiniteLoop;
        return this;
    }

    
    public interface BannerListener{
    	/**
    	 * 
    	 * @param position  当前点击的item位置
    	 * @param imageList 数据源
    	 */
    	 public void click(int position,List<Object> imageList);
    }
}
