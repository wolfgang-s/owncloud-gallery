package md.steuer.mobile.utils;

import org.robovm.apple.uikit.UIView;

public class DebugUtils {
    public static void debugUI(UIView v, int depth) {
	System.out.println(String.format("%s: %s\t%s\t%s\t%s\t%s", depth, v
		.getClass().getSimpleName(), v.getBounds().getMinX(), v
		.getBounds().getMinY(), v.getBounds().getWidth(), v.getBounds()
		.getHeight()));
	depth++;
	for (UIView childView : v.getSubviews()) {
	    debugUI(childView, depth);
	}
    }
}
