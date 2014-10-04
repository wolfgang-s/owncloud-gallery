/*
 * Copyright (C) 2014 Trillian Mobile AB
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 * Portions of this code is based on Apple Inc's HelloWorld sample (v1.8)
 * which is copyright (C) 2008-2010 Apple Inc.
 */

package md.steuer.mobile.owncloudgallery.viewcontroller;

import md.steuer.mobile.utils.TextFieldKeyboardDelegate;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.NSLayoutAttribute;
import org.robovm.apple.uikit.NSLayoutConstraint;
import org.robovm.apple.uikit.NSLayoutRelation;
import org.robovm.apple.uikit.UIBarButtonItem;
import org.robovm.apple.uikit.UIBarButtonItemStyle;
import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControlContentVerticalAlignment;
import org.robovm.apple.uikit.UIControlState;
import org.robovm.apple.uikit.UIEvent;
import org.robovm.apple.uikit.UIFont;
import org.robovm.apple.uikit.UIImage;
import org.robovm.apple.uikit.UIImageView;
import org.robovm.apple.uikit.UIKeyboardType;
import org.robovm.apple.uikit.UIReturnKeyType;
import org.robovm.apple.uikit.UIScrollView;
import org.robovm.apple.uikit.UITextAutocapitalizationType;
import org.robovm.apple.uikit.UITextBorderStyle;
import org.robovm.apple.uikit.UITextField;
import org.robovm.apple.uikit.UITextFieldViewMode;
import org.robovm.apple.uikit.UIViewContentMode;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.apple.uikit.UIWindow;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.Method;

public class LoginViewController extends UIViewController {
    private UIImageView logoImageView;
    private UITextField textFieldHostname;
    private UITextField textFieldUsername;
    private UITextField textFieldPassword;
    private UIButton loginButton;
    private UIWindow window;
    private UIScrollView scrollView;

    public LoginViewController(UIWindow window) {
	this.window = window;

	UIBarButtonItem helpButton = new UIBarButtonItem("Help",
		UIBarButtonItemStyle.Plain, null);

	Selector selector = Selector.register("help:");
	helpButton.setAction(selector);
	helpButton.setTarget(this);
	this.getNavigationItem().setRightBarButtonItem(helpButton);
    }

    private void setupViews() {
	setupUiView();

	// logo
	generateLogoImageView();

	// hostname
	textFieldHostname = generateTextField("Hostname", -60,
		UIKeyboardType.URL, "earth");

	// username
	textFieldUsername = generateTextField("Username", -19,
		UIKeyboardType.ASCIICapable, "person");

	// password
	textFieldPassword = generateTextField("Password", 22,
		UIKeyboardType.ASCIICapable, "key");
	textFieldPassword.setSecureTextEntry(true);

	// login button
	generateLoginButton();
    }

    private void setupUiView() {
	this.getView().setBounds(window.getBounds());
	this.getView().setTranslatesAutoresizingMaskIntoConstraints(false);
    }

    @Override
    public void updateViewConstraints() {
	System.out.println("public void updateViewConstraints()");
	super.updateViewConstraints();
	this.getView().addConstraint(
		NSLayoutConstraint.create(getView(), NSLayoutAttribute.Height,
			NSLayoutRelation.Equal, null, NSLayoutAttribute.Height,
			0, window.getBounds().getHeight() / 2));
	this.getView().addConstraint(
		NSLayoutConstraint.create(getView(), NSLayoutAttribute.Width,
			NSLayoutRelation.Equal, null, NSLayoutAttribute.Width,
			0, window.getBounds().getWidth() / 2));
    };

    @Override
    public void viewWillAppear(boolean animated) {
	super.viewWillAppear(animated);
	this.updateViewConstraints();
    };

    @Method
    private void help(UIBarButtonItem item) {
	this.getNavigationController().popViewController(true);
	HelpViewController helpViewController = new HelpViewController(window);
	this.getNavigationController().pushViewController(helpViewController,
		true);
    }

    private void generateLoginButton() {
	loginButton = new UIButton(new CGRect(0, 0, 200, 30));
	loginButton.setTitle("Login", UIControlState.Normal);
	loginButton.setTranslatesAutoresizingMaskIntoConstraints(false);
	this.getView().addSubview(loginButton);
	this.getView().addConstraint(
		NSLayoutConstraint.create(loginButton,
			NSLayoutAttribute.CenterX, NSLayoutRelation.Equal,
			this.getView(), NSLayoutAttribute.CenterX, 1, 0));
	this.getView().addConstraint(
		NSLayoutConstraint.create(loginButton,
			NSLayoutAttribute.CenterY, NSLayoutRelation.Equal,
			this.getView(), NSLayoutAttribute.CenterY, 1, 53));
	this.getView().addConstraint(
		NSLayoutConstraint.create(loginButton,
			NSLayoutAttribute.Height, NSLayoutRelation.Equal,
			this.getView(), NSLayoutAttribute.Height, 0, 30));
	this.getView().addConstraint(
		NSLayoutConstraint.create(loginButton, NSLayoutAttribute.Width,
			NSLayoutRelation.Equal, this.getView(),
			NSLayoutAttribute.Width, 0.5, 0));
	loginButton
		.addOnTouchUpInsideListener(new UIControl.OnTouchUpInsideListener() {
		    @Override
		    public void onTouchUpInside(UIControl control, UIEvent event) {
			System.out.println("onTouchUpInside");
		    }
		});
    }

    private void generateLogoImageView() {
	logoImageView = new UIImageView(new CGRect(0f, 0f, 20f, 20f));
	logoImageView.setImage(UIImage.createFromBundle("logoWhite.png"));
	logoImageView.setContentMode(UIViewContentMode.ScaleAspectFit);
	logoImageView.setTranslatesAutoresizingMaskIntoConstraints(false);
	logoImageView.setUserInteractionEnabled(false);

	this.getView().addSubview(logoImageView);

	this.getView().addConstraint(
		NSLayoutConstraint.create(logoImageView,
			NSLayoutAttribute.CenterX, NSLayoutRelation.Equal,
			this.getView(), NSLayoutAttribute.CenterX, 1, 0));
	this.getView().addConstraint(
		NSLayoutConstraint.create(logoImageView,
			NSLayoutAttribute.CenterY, NSLayoutRelation.Equal,
			this.getView(), NSLayoutAttribute.CenterY, 1, -120));
	this.getView().addConstraint(
		NSLayoutConstraint.create(logoImageView,
			NSLayoutAttribute.Height, NSLayoutRelation.Equal,
			this.getView(), NSLayoutAttribute.Height, 0, 55));
	this.getView().addConstraint(
		NSLayoutConstraint.create(logoImageView,
			NSLayoutAttribute.Width, NSLayoutRelation.Equal,
			this.getView(), NSLayoutAttribute.Width, 0, 64));
    }

    private UITextField generateTextField(String placeholder, float y,
	    UIKeyboardType keyboardType, String leftViewImageName) {
	UITextField textField = new UITextField(new CGRect(0, 0, 300, 40));
	textField.setDelegate(new TextFieldKeyboardDelegate(this.getView()));
	textField.setTranslatesAutoresizingMaskIntoConstraints(false);
	textField
		.setContentVerticalAlignment(UIControlContentVerticalAlignment.Center);
	textField.setBorderStyle(UITextBorderStyle.RoundedRect);
	textField.setPlaceholder(placeholder);
	textField.setFont(UIFont.getFont("Helvetica", 17));
	textField.setClearsOnBeginEditing(true);
	textField.setAdjustsFontSizeToFitWidth(true);
	textField.setMinimumFontSize(17);
	textField.setAutocapitalizationType(UITextAutocapitalizationType.None);
	textField.setKeyboardType(keyboardType);
	textField.setReturnKeyType(UIReturnKeyType.Done);
	textField.setClearButtonMode(UITextFieldViewMode.WhileEditing);

	UIImageView leftView = new UIImageView(new CGRect(0, 0, 40, 40));
	leftView.setImage(UIImage.createFromBundle(leftViewImageName));
	leftView.setAlpha(0.5);
	textField.setLeftView(leftView);
	textField.setLeftViewMode(UITextFieldViewMode.Always);

	this.getView().addSubview(textField);

	this.getView().addConstraint(
		NSLayoutConstraint.create(textField, NSLayoutAttribute.CenterX,
			NSLayoutRelation.Equal, this.getView(),
			NSLayoutAttribute.CenterX, 1, 0));
	this.getView().addConstraint(
		NSLayoutConstraint.create(textField, NSLayoutAttribute.CenterY,
			NSLayoutRelation.Equal, this.getView(),
			NSLayoutAttribute.CenterY, 1, y));
	this.getView().addConstraint(
		NSLayoutConstraint.create(textField, NSLayoutAttribute.Height,
			NSLayoutRelation.Equal, this.getView(),
			NSLayoutAttribute.Height, 0, 40));
	this.getView().addConstraint(
		NSLayoutConstraint.create(textField, NSLayoutAttribute.Width,
			NSLayoutRelation.Equal, this.getView(),
			NSLayoutAttribute.Width, 0.8, 0));

	return textField;
    }

    @Override
    public void viewDidLoad() {
	setupViews();
    }
}