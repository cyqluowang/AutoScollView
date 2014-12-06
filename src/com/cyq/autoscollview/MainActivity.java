package com.cyq.autoscollview;
//
//import java.util.ArrayList;
//import java.util.List;
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v4.view.ViewPager.OnPageChangeListener;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.TextView;
//
//
///**
// * AutoScrollViewPagerDemo
// * 
// * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2014-2-22
// */
//public class MainActivity extends Activity {
//
//    private AutoScrollViewPager viewPager;
//    private TextView            indexText;
//    private List<Integer>       imageIdList;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//    	super.onCreate(savedInstanceState);
//    	setContentView(R.layout.auto_scroll_view_pager_demo);
//
//        viewPager = (AutoScrollViewPager)findViewById(R.id.view_pager);
//        indexText = (TextView)findViewById(R.id.view_pager_index);
//
//        imageIdList = new ArrayList<Integer>();
//        imageIdList.add(R.drawable.banner1);
//        imageIdList.add(R.drawable.banner2);
//        imageIdList.add(R.drawable.banner3);
////        imageIdList.add(R.drawable.banner4);
//        viewPager.setAdapter(new ImagePagerAdapter(getApplicationContext(), imageIdList).setInfiniteLoop(true));
//        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
//
//        viewPager.setInterval(2000);
//        viewPager.startAutoScroll();
//        viewPager.setCurrentItem(Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % ListUtils.getSize(imageIdList));
//
//        // the more properties whose you can set
//        // // set whether stop auto scroll when touching, default is true
//        // viewPager.setStopScrollWhenTouch(false);
//        // // set whether automatic cycle when auto scroll reaching the last or first item
//        // // default is true
//        // viewPager.setCycle(false);
//        // /** set auto scroll direction, default is AutoScrollViewPager#RIGHT **/
//        // viewPager.setDirection(AutoScrollViewPager.LEFT);
//        // // set how to process when sliding at the last or first item
//        // // default is AutoScrollViewPager#SLIDE_BORDER_NONE
//        // viewPager.setBorderProcessWhenSlide(AutoScrollViewPager.SLIDE_BORDER_CYCLE);
//        // viewPager.setScrollDurationFactor(3);
//        // viewPager.setBorderAnimation(false);
//
//
//    }
//
//    public class MyOnPageChangeListener implements OnPageChangeListener {
//
//        @Override
//        public void onPageSelected(int position) {
//            indexText.setText(new StringBuilder().append((position) % ListUtils.getSize(imageIdList) + 1).append("/")
//                    .append(ListUtils.getSize(imageIdList)));
//        }
//
//        @Override
//        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
//
//        @Override
//        public void onPageScrollStateChanged(int arg0) {}
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        // stop auto scroll when onPause
//        viewPager.stopAutoScroll();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        // start auto scroll when onResume
//        viewPager.startAutoScroll();
//    }
//    
//    public static <V> int getSize(List<V> sourceList) {
//        return sourceList == null ? 0 : sourceList.size();
//    }
//}
