package md.steuer.mobile.owncloudgallery;

import md.steuer.mobile.owncloudgallery.viewcontroller.LoginViewController;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIColor;
import org.robovm.apple.uikit.UINavigationController;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIWindow;

public class OwncloudGallery extends UIApplicationDelegateAdapter {
    private UIWindow window;
    private UINavigationController startViewController;

    @Override
    public void didFinishLaunching(UIApplication application) {
	CGRect bounds = new CGRect(0, 0, UIScreen.getMainScreen()
		.getCurrentMode().getSize().width(), UIScreen.getMainScreen()
		.getCurrentMode().getSize().height());
	window = new UIWindow(bounds);

	// TODO load GalleryViewController if already logged in
	if (startViewController == null) {
	    startViewController = new UINavigationController();
	    startViewController.pushViewController(new LoginViewController(
		    window), false);
	}

	window.setBackgroundColor(UIColor.createFromRGBA(74f / 255f,
		135f / 255f, 238f / 255f, 1f));
	window.setRootViewController(startViewController);
	window.makeKeyAndVisible();

	application.addStrongRef(window);
    }

    public static void main(String[] args) {
	NSAutoreleasePool pool = new NSAutoreleasePool();
	UIApplication.main(args, null, OwncloudGallery.class);
	pool.close();
    }
}
