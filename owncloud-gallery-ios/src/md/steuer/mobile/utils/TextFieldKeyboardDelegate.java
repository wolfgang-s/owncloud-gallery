package md.steuer.mobile.utils;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSRange;
import org.robovm.apple.uikit.UITextField;
import org.robovm.apple.uikit.UITextFieldDelegateAdapter;
import org.robovm.apple.uikit.UIView;
import org.robovm.objc.annotation.Method;
import org.robovm.rt.bro.annotation.ByVal;

public class TextFieldKeyboardDelegate extends UITextFieldDelegateAdapter {

    private UIView viewToMove = null;

    public TextFieldKeyboardDelegate(UIView viewToMove) {
	this.viewToMove = viewToMove;
    }

    @Override
    @Method(selector = "textFieldShouldBeginEditing:")
    public boolean shouldBeginEditing(UITextField textField) {
	// TODO Auto-generated method stub
	return true;
    }

    @Override
    @Method(selector = "textFieldDidBeginEditing:")
    public void didBeginEditing(UITextField textField) {
	System.out.println("textFieldDidBeginEditing"
		+ viewToMove.getBounds().origin().y());
	CGRect frame = viewToMove.getFrame();
	// TODO implement ---------------------------------------------++++++
	viewToMove.getBounds().origin().y(-100);
	System.out.println("textFieldDidBeginEditing"
		+ viewToMove.getBounds().origin().y());
    }

    @Override
    @Method(selector = "textFieldShouldEndEditing:")
    public boolean shouldEndEditing(UITextField textField) {
	System.out.println("shouldEndEditing"
		+ viewToMove.getBounds().origin().y());
	viewToMove.getBounds().origin().y(0);
	System.out.println("shouldEndEditing"
		+ viewToMove.getBounds().origin().y());
	return true;
    }

    @Override
    @Method(selector = "textFieldDidEndEditing:")
    public void didEndEditing(UITextField textField) {
	// TODO Auto-generated method stub

    }

    @Override
    @Method(selector = "textField:shouldChangeCharactersInRange:replacementString:")
    public boolean shouldChangeCharacters(UITextField textField,
	    @ByVal NSRange range, String string) {
	// TODO Auto-generated method stub
	return true;
    }

    @Override
    @Method(selector = "textFieldShouldClear:")
    public boolean shouldClear(UITextField textField) {
	// TODO Auto-generated method stub
	return true;
    }

    @Override
    @Method(selector = "textFieldShouldReturn:")
    public boolean shouldReturn(UITextField textField) {
	// TODO Auto-generated method stub
	return true;
    }

}
