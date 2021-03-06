package customization;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by HUZY-KAMZ on 1/16/2016.
 */
public class MarigoldText extends TextView {
    public MarigoldText(Context context) {
        super(context);
        setFont();
    }
    public MarigoldText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }
    public MarigoldText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont();
    }

    private void setFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/Marigold-Regular.ttf");
        setTypeface(font, Typeface.NORMAL);
    }
}
