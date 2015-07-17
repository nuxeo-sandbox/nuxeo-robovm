package org.nuxeo.robovm;

import org.robovm.apple.dispatch.DispatchQueue;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBAction;
import org.robovm.objc.annotation.IBOutlet;

@CustomClass("MyViewController")
public class MyViewController extends UIViewController {
    private static NuxeoClient nuxeoClient = new NuxeoClient();

    private UILabel label;

    @IBOutlet
    public void setLabel(UILabel label) {
        this.label = label;
    }

    @IBAction
    private void clicked() {
        nuxeoClient.getDocumentTitle(new NuxeoClient.OnNuxeoListener() {
            @Override
            public void onClick(String title) {
                setTitle(title);
            }
        });
    }

    public void setTitle(final String title) {
        DispatchQueue.getMainQueue().sync(new Runnable() {
            @Override
            public void run() {
                label.setText(title);
            }
        });
    }
}
