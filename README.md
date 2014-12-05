AutoScollView
=============
# 轮播图

## 使用
### 只需要在xml中配置一个banner控件
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" >

    

    <com.cyq.autoscollview.MyBanner
        android:id="@+id/banner"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content" 
        android:background="#ffdd33"/>

</RelativeLayout>
```


### 代码中加入注入数据
myBanner.setImgData(imageIdList);

### 设置监听
当点击广告的时候响应事件
```
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

```

## 效果
![img](/demo.gif)
