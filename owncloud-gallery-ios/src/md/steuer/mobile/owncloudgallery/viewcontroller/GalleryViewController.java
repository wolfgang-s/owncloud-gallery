package md.steuer.mobile.owncloudgallery.viewcontroller;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.NSLayoutAttribute;
import org.robovm.apple.uikit.NSLayoutConstraint;
import org.robovm.apple.uikit.NSLayoutRelation;
import org.robovm.apple.uikit.UICollectionViewController;
import org.robovm.apple.uikit.UIScrollView;
import org.robovm.apple.uikit.UITextView;
import org.robovm.apple.uikit.UIWindow;

public class GalleryViewController extends UICollectionViewController {

    private UIWindow window;
    private UIScrollView scrollView;
    private UITextView textViewIntro;

    public GalleryViewController(UIWindow window) {
	this.window = window;
    }

    private void setupViews() {

	this.scrollView = new UIScrollView(this.getView().getBounds());
	this.getView().addSubview(scrollView);

	textViewIntro = new UITextView(new CGRect());
	textViewIntro.setText("Lorem ipsum dolor sit amet");
	textViewIntro.setTranslatesAutoresizingMaskIntoConstraints(false);
	this.scrollView.addSubview(textViewIntro);
	this.scrollView.addConstraint(NSLayoutConstraint.create(textViewIntro,
		NSLayoutAttribute.Top, NSLayoutRelation.Equal, this.scrollView,
		NSLayoutAttribute.Top, 1, 30));
	this.scrollView.addConstraint(NSLayoutConstraint.create(textViewIntro,
		NSLayoutAttribute.Width, NSLayoutRelation.Equal,
		this.scrollView, NSLayoutAttribute.Width, 1, 0));
	this.scrollView.addConstraint(NSLayoutConstraint.create(textViewIntro,
		NSLayoutAttribute.Height, NSLayoutRelation.Equal,
		this.scrollView, NSLayoutAttribute.Height, 0.5, 0));
	this.scrollView.addSubview(textViewIntro);
	// TODO dynamic height ?

	// Selector selector = Selector.register("back:");
	// this.getNavigationItem().getBackBarButtonItem().setTarget(this);
	// this.getNavigationItem().getBackBarButtonItem().setAction(selector);
    }

    //
    // @Method
    // private void back(UIBarButtonItem button) {
    // this.getNavigationController().popViewController(true);
    // this.getNavigationController().
    // }

    @Override
    public void viewDidLoad() {
	setupViews();
    }
}
