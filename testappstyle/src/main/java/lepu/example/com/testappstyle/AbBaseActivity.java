package lepu.example.com.testappstyle;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class AbBaseActivity extends AppCompatActivity {
    private static final int BASE_VIEW_ID = R.layout.activity_main;
    private static final ViewGroup.LayoutParams LAYOUT_PARAMS =
            new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    public Context mContext;
    private Toolbar mToolBar;
    LinearLayout mParentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(BASE_VIEW_ID);
        mContext = this;
        //写在后面
    }

    @Override
    public void setContentView(int layoutResID) {
        if (BASE_VIEW_ID == layoutResID) {
            super.setContentView(layoutResID);
            mParentView = (LinearLayout) findViewById(R.id.relative_container);
            mToolBar = (Toolbar) findViewById(R.id.demo_toolbar);
            initToolbar(mToolBar);
            return;
        }
        mParentView.addView(getLayoutInflater().inflate(layoutResID, null), LAYOUT_PARAMS);
    }

    @Override
    public void setContentView(View view) {
        mParentView.addView(view, LAYOUT_PARAMS);
    }

    private void initToolbar(Toolbar mToolBar) {
        mToolBar.setLogo(R.drawable.ic_launcher);
        setSupportActionBar(mToolBar);
        setNavigationIsShow(true);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                LKeyBoardUtils.closeKeybord(mContext);
                finish();
            }
        });
    }

    /**
     * 设置返回键显示 or 隐藏
     *
     * @param hasShow true:显示 false:隐藏
     */
    public void setNavigationIsShow(boolean hasShow) {
        if (hasShow) {
            // 显示返回键
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } else {
            // 隐藏返回键
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    /**
     * 标题通过AndroidManifest设置Activity的lable属性,会自动显示到这个TextView中
     *
     * @param title 标题
     * @param color 标题颜色
     */
    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        if (mToolBar != null) {
            mToolBar.setTitle(title);
        }
    }

    /**
     * 得到 Toolbar
     *
     * @return Toolbar
     */
    public Toolbar getToolBar() {
        return mToolBar;
    }

    /**
     * 设置父布局背景颜色
     *
     * @param colorId 颜色ID
     */
    public void setBackground(int colorId) {
        if (null != mParentView) {
            mParentView.setBackgroundColor(getResources().getColor(colorId));
        }
    }


}
