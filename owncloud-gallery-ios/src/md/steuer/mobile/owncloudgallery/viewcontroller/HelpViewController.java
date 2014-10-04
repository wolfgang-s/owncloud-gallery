package md.steuer.mobile.owncloudgallery.viewcontroller;

import md.steuer.mobile.utils.DebugUtils;

import org.robovm.apple.uikit.NSLayoutAttribute;
import org.robovm.apple.uikit.NSLayoutConstraint;
import org.robovm.apple.uikit.NSLayoutRelation;
import org.robovm.apple.uikit.NSLineBreakMode;
import org.robovm.apple.uikit.NSTextAlignment;
import org.robovm.apple.uikit.UIFont;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UIScrollView;
import org.robovm.apple.uikit.UIView;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.apple.uikit.UIWindow;

public class HelpViewController extends UIViewController {

    private UIWindow window;
    private UIScrollView scrollView;
    private UIView mainView;
    private UIView introText;

    public HelpViewController(UIWindow window) {
	this.window = window;
    }

    private void setupViews() {
	scrollView = new UIScrollView(getView().getBounds());
	scrollView.setTranslatesAutoresizingMaskIntoConstraints(false);
	getView().addSubview(scrollView);
	mainView = new UIView(this.getView().getBounds());
	mainView.setTranslatesAutoresizingMaskIntoConstraints(false);
	scrollView.addSubview(mainView);
	scrollView.addConstraint(NSLayoutConstraint.create(mainView,
		NSLayoutAttribute.Height, NSLayoutRelation.Equal, scrollView,
		NSLayoutAttribute.Height, 1, 0));
	scrollView.addConstraint(NSLayoutConstraint.create(mainView,
		NSLayoutAttribute.Width, NSLayoutRelation.Equal, scrollView,
		NSLayoutAttribute.Width, 1, 0));

	introText = generateTextArea(
		"Lorem ipsum dolor",
		"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas euismod tellus non massa aliquet, in tristique justo ultrices. Donec lacinia dapibus sapien, eget fermentum dolor lobortis ut. Nullam euismod enim nulla, id sagittis ipsum auctor vel. Etiam id nisl orci. Donec dictum ipsum vel libero elementum pretium. Fusce tincidunt posuere ullamcorper. Duis vel ante eget odio ultrices accumsan. Mauris rhoncus sodales efficitur. Pellentesque vulputate neque sem, nec ultrices erat lacinia in. Duis aliquam tristique mattis. Cras tempor auctor cursus. Quisque rhoncus pulvinar mi sit amet tempus. Cras condimentum imperdiet ex, a pretium nunc auctor eget. Phasellus scelerisque blandit dui, eu egestas risus tristique eget. Quisque varius a justo ac varius. Sed vitae sapien consequat, condimentum nisi scelerisque, consequat metus.",
		null);

	UIView secondText = generateTextArea(
		"Sed id lacinia mi",
		"Sed id lacinia mi. Suspendisse arcu nunc, suscipit non augue at, faucibus scelerisque nisl. In iaculis vel enim non hendrerit. Sed viverra auctor interdum. Donec leo sapien, posuere id eleifend ut, malesuada a nulla. Sed rhoncus eget nisl vitae semper. Integer erat orci, ornare at lobortis vitae, vulputate nec neque. Donec sed neque mollis, cursus diam nec, aliquet ligula. Donec et hendrerit turpis. Phasellus rutrum vehicula fermentum. Donec at justo finibus, venenatis nibh a, lobortis nisi. In gravida purus a diam dignissim congue. Etiam pulvinar neque id sem dictum, vulputate convallis ligula volutpat. Pellentesque ultricies felis ac dolor auctor, quis placerat elit sagittis. Maecenas non urna feugiat, pharetra magna quis, egestas risus.",
		introText);

	scrollView.addConstraint(NSLayoutConstraint.create(secondText,
		NSLayoutAttribute.Bottom, NSLayoutRelation.Equal, mainView,
		NSLayoutAttribute.Bottom, 1, 10));
	getView().addConstraint(
		NSLayoutConstraint.create(scrollView, NSLayoutAttribute.Width,
			NSLayoutRelation.Equal, getView(),
			NSLayoutAttribute.Width, 1, 10));
	getView().addConstraint(
		NSLayoutConstraint.create(scrollView, NSLayoutAttribute.Top,
			NSLayoutRelation.Equal, getView(),
			NSLayoutAttribute.Top, 1, 10));
    }

    private UIView generateTextArea(String title, String text,
	    UIView previousView) {
	UILabel textViewTitle = new UILabel();
	textViewTitle.setTranslatesAutoresizingMaskIntoConstraints(false);
	textViewTitle.setLineBreakMode(NSLineBreakMode.TruncatingTail);
	textViewTitle.setNumberOfLines(0);
	textViewTitle.setText(title);
	textViewTitle.setTextAlignment(NSTextAlignment.Center);
	textViewTitle.setFont(UIFont.getBoldSystemFont(UIFont
		.getButtonFontSize()));
	UILabel textViewText = new UILabel();
	textViewText.setTranslatesAutoresizingMaskIntoConstraints(false);
	textViewText.setLineBreakMode(NSLineBreakMode.WordWrapping);
	textViewText.setNumberOfLines(0);
	textViewText.setText(text);
	textViewText.setFont(UIFont.getSystemFont(UIFont
		.getSmallSystemFontSize()));
	mainView.addSubview(textViewTitle);
	mainView.addSubview(textViewText);
	// mainView.addSubview(toReturn);
	// uiview
	// if (previousView == null) {
	// mainView.addConstraint(NSLayoutConstraint.create(toReturn,
	// NSLayoutAttribute.Top, NSLayoutRelation.Equal, mainView,
	// NSLayoutAttribute.Top, 1, 10));
	// } else {
	// mainView.addConstraint(NSLayoutConstraint.create(toReturn,
	// NSLayoutAttribute.Top, NSLayoutRelation.Equal,
	// previousView, NSLayoutAttribute.Bottom, 1, 10));
	// }
	// mainView.addConstraint(NSLayoutConstraint.create(toReturn,
	// NSLayoutAttribute.Width, NSLayoutRelation.Equal, mainView,
	// NSLayoutAttribute.Width, 1, 0));
	// mainView.addConstraint(NSLayoutConstraint.create(toReturn,
	// NSLayoutAttribute.CenterX, NSLayoutRelation.Equal, mainView,
	// NSLayoutAttribute.CenterX, 1, 0));

	// title
	mainView.addConstraint(NSLayoutConstraint.create(textViewTitle,
		NSLayoutAttribute.Width, NSLayoutRelation.Equal, mainView,
		NSLayoutAttribute.Width, 1, -40));
	mainView.addConstraint(NSLayoutConstraint.create(textViewTitle,
		NSLayoutAttribute.CenterX, NSLayoutRelation.Equal, mainView,
		NSLayoutAttribute.CenterX, 1, 0));
	if (previousView == null) {
	    mainView.addConstraint(NSLayoutConstraint.create(textViewTitle,
		    NSLayoutAttribute.Top, NSLayoutRelation.Equal, mainView,
		    NSLayoutAttribute.Top, 1, 10));
	} else {
	    mainView.addConstraint(NSLayoutConstraint.create(textViewTitle,
		    NSLayoutAttribute.Top, NSLayoutRelation.Equal,
		    previousView, NSLayoutAttribute.Bottom, 1, 10));
	}

	// text
	mainView.addConstraint(NSLayoutConstraint.create(textViewText,
		NSLayoutAttribute.Width, NSLayoutRelation.Equal, mainView,
		NSLayoutAttribute.Width, 1, -40));
	mainView.addConstraint(NSLayoutConstraint.create(textViewText,
		NSLayoutAttribute.CenterX, NSLayoutRelation.Equal, mainView,
		NSLayoutAttribute.CenterX, 1, 0));
	mainView.addConstraint(NSLayoutConstraint.create(textViewText,
		NSLayoutAttribute.Top, NSLayoutRelation.Equal, textViewTitle,
		NSLayoutAttribute.Bottom, 1, 10));

	return textViewText;
    }

    @Override
    public void viewDidAppear(boolean animated) {
	super.viewDidAppear(animated);
	DebugUtils.debugUI(this.getView(), 0);
    };

    @Override
    public void viewDidLoad() {
	setupViews();
    }
}
