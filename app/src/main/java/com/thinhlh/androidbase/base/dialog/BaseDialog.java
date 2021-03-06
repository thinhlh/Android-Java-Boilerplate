package com.thinhlh.androidbase.base.dialog;

import android.app.AlertDialog;
import android.content.Context;

import java.net.ContentHandler;

/**
 * Created by thinhlh on 02/03/2022.
 * Copyright (c). All rights reserved
 */
public abstract class BaseDialog {

    protected Context context;
    protected AlertDialog dialog;

    /**
     * Init context
     */
    public void init(Context appContext) {
        context = appContext;
    }

    /**
     * Dismiss dialog
     */
    public void dismiss() {
        if (dialog != null) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }
    }

}
