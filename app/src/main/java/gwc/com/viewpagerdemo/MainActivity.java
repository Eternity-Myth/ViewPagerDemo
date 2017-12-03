package gwc.com.viewpagerdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener, OnPageChangeListener {
    // 底部菜单4个Linearlayout
    private LinearLayout ll_first;
    private LinearLayout ll_second;
    private LinearLayout ll_third;
    private LinearLayout ll_fourth;


    // 底部菜单4个菜单标题
    private TextView tv_first;
    private TextView tv_second;
    private TextView tv_third;
    private TextView tv_fourth;

    // 中间内容区域
    private ViewPager viewPager;

    // ViewPager适配器ContentAdapter
    private ContentAdapter adapter;
    private List<View> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化控件
        initView();
        // 初始化底部按钮事件
        initEvent();
    }

    private void initEvent() {
        // 设置按钮监听
        ll_first.setOnClickListener(this);
        ll_second.setOnClickListener(this);
        ll_third.setOnClickListener(this);
        ll_fourth.setOnClickListener(this);

        //设置ViewPager滑动监听
        viewPager.setOnPageChangeListener(this);
    }

    private void initView() {
        // 底部菜单4个Linearlayout
        this.ll_first = (LinearLayout) findViewById(R.id.ll_first);
        this.ll_second = (LinearLayout) findViewById(R.id.ll_second);
        this.ll_third = (LinearLayout) findViewById(R.id.ll_third);
        this.ll_fourth = (LinearLayout) findViewById(R.id.ll_fourth);


        // 底部菜单4个菜单标题
        this.tv_first = (TextView) findViewById(R.id.tv_first);
        this.tv_second = (TextView) findViewById(R.id.tv_second);
        this.tv_third = (TextView) findViewById(R.id.tv_third);
        this.tv_fourth = (TextView) findViewById(R.id.tv_fourth);

        // 中间内容区域ViewPager
        this.viewPager = (ViewPager) findViewById(R.id.vp_content);

        // 适配器
        View page_01 = View.inflate(MainActivity.this, R.layout.page_01, null);
        View page_02 = View.inflate(MainActivity.this, R.layout.page_02, null);
        View page_03 = View.inflate(MainActivity.this, R.layout.page_03, null);
        View page_04 = View.inflate(MainActivity.this, R.layout.page_04, null);

        views = new ArrayList<View>();
        views.add(page_01);
        views.add(page_02);
        views.add(page_03);
        views.add(page_04);

        this.adapter = new ContentAdapter(views);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        // 在每次点击后将所有的底部按钮(ImageView,TextView)颜色改为灰色，然后根据点击着色
        restartButton();
        // ImageView和TetxView置为绿色，页面随之跳转
        switch (v.getId()) {
            case R.id.ll_first:
                tv_first.setTextColor(0xff00ff00);
                viewPager.setCurrentItem(0);
                break;
            case R.id.ll_second:
                tv_second.setTextColor(0xff00ff00);
                viewPager.setCurrentItem(1);
                break;
            case R.id.ll_third:
                tv_third.setTextColor(0xff00ff00);
                viewPager.setCurrentItem(2);
                break;
            case R.id.ll_fourth:
                tv_fourth.setTextColor(0xff00ff00);
                viewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

    private void restartButton() {
        // TextView置为灰色
        tv_first.setTextColor(0xff7F7F7F);
        tv_second.setTextColor(0xff7F7F7F);
        tv_third.setTextColor(0xff7F7F7F);
        tv_fourth.setTextColor(0xff7F7F7F);
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {
        restartButton();
        //当前view被选择的时候,改变底部菜单图片，文字颜色
        switch (arg0) {
            case 0:
                tv_first.setTextColor(0xff00ff00);
                break;
            case 1:
                tv_second.setTextColor(0xff00ff00);
                break;
            case 2:
                tv_third.setTextColor(0xff00ff00);
                break;
            case 3:
                tv_fourth.setTextColor(0xff00ff00);
                break;

            default:
                break;
        }

    }
}
