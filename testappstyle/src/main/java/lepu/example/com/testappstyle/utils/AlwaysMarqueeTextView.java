package lepu.example.com.testappstyle.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author Liujy
 *          
 * @ClassName AlwaysMarqueeTextView
 * @Description 文字水平滚动（跑马灯）
 */
public class AlwaysMarqueeTextView extends TextView {

    public AlwaysMarqueeTextView(Context context) {
        super(context);
    }

    public AlwaysMarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AlwaysMarqueeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}