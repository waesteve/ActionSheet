package com.mseen.ui.actionsheet;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;

public class ActionSheetPopupWindow extends PopupWindow {

	private Button btn_take_photo, btn_pick_photo, btn_cancel;
	private View mMenuView;

	public ActionSheetPopupWindow(Activity context, OnClickListener itemsOnClick) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mMenuView = inflater.inflate(R.layout.select_sheet_popupwindow_layout, null);
		btn_take_photo = (Button) mMenuView.findViewById(R.id.btn_take_photo);
		btn_pick_photo = (Button) mMenuView.findViewById(R.id.btn_pick_photo);
		btn_cancel = (Button) mMenuView.findViewById(R.id.selectsheet_popupwindow_cancel_btn);
		btn_cancel.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				dismiss();
			}
		});
		btn_pick_photo.setOnClickListener(itemsOnClick);
		btn_take_photo.setOnClickListener(itemsOnClick);
		this.setContentView(mMenuView);
		this.setWidth(LayoutParams.FILL_PARENT);
		this.setHeight(LayoutParams.WRAP_CONTENT);
		this.setFocusable(true);
		this.setAnimationStyle(R.style.AnimBottom);
		ColorDrawable dw = new ColorDrawable(0xb0000000);
		this.setBackgroundDrawable(dw);
		mMenuView.setOnTouchListener(new OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {

				int height = mMenuView.findViewById(R.id.selectsheet_popupwindow_content_viewgroup).getTop();
				int y = (int) event.getY();
				if (event.getAction() == MotionEvent.ACTION_UP) {
					if (y < height) {
						dismiss();
					}
				}
				return true;
			}
		});

	}

}
