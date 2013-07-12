package com.mseen.ui.actionsheet;

import java.util.List;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ActionSheetDialog extends Dialog {

	public ActionSheetDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
		super(context, R.style.Actionsheet_Theme);
		init(context);
		setCancelable(cancelable);
		setOnCancelListener(cancelListener);
	}

	public ActionSheetDialog(Context context, int theme) {
		super(context, R.style.Actionsheet_Theme);
		init(context);
	}

	public ActionSheetDialog(Context context) {
		super(context, R.style.Actionsheet_Theme);
		init(context);
	}

	private Context mContext = null;
	private ViewGroup contentViewGroup = null;
	private View cancle_btn = null;
	private View ok_btn = null;
	private TextView title_TV = null;;

	private void init(Context context) {

		mContext = context;
		super.setContentView(R.layout.select_sheet_dialog_layout);

		contentViewGroup = (ViewGroup) findViewById(R.id.selectsheet_dialog_content_viewgroup);
		cancle_btn = findViewById(R.id.selectsheet_dialog_cancel_btn);
		ok_btn = findViewById(R.id.selectsheet_dialog_ok_btn);
		title_TV = (TextView) findViewById(R.id.selectsheet_dialog_title_TV);

	}

	@Override
	public void setContentView(int layoutResID) {
		setContentView(ViewGroup.inflate(mContext, layoutResID, null));
	}

	@Override
	public void setContentView(View view) {
		setContentView(view, null);
	}

	@Override
	public void setContentView(View view, LayoutParams params) {
		contentViewGroup.removeAllViews();
		contentViewGroup.addView(view, params);
	}

	public void setNegativeButton(CharSequence text, final DialogInterface.OnClickListener clickListener) {
		cancle_btn.setVisibility(View.VISIBLE);
		((Button) cancle_btn).setText(text);
		cancle_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				dismiss();
				clickListener.onClick(ActionSheetDialog.this, DialogInterface.BUTTON_NEGATIVE);
			}
		});
	}

	public void setPositiveButton(CharSequence text, final DialogInterface.OnClickListener clickListener) {
		ok_btn.setVisibility(View.VISIBLE);
		((Button) ok_btn).setText(text);

		ok_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				dismiss();
				clickListener.onClick(ActionSheetDialog.this, DialogInterface.BUTTON_POSITIVE);
			}
		});

	}

	@Override
	public void setTitle(CharSequence title) {
		title_TV.setVisibility(View.VISIBLE);
		title_TV.setText(title);
	}

	@Override
	public void setTitle(int titleId) {
		setTitle(mContext.getString(titleId));
	}

	@Override
	public void show() {
		getWindow().getAttributes().width = ViewGroup.LayoutParams.MATCH_PARENT;

		super.show();
		getWindow().setGravity(Gravity.BOTTOM);
	}

	public void addMenuItems(List<String> values, AdapterView.OnItemClickListener itemClickListener) {
		ListView selectsheet_dialog_content_LV = (ListView) contentViewGroup
				.findViewById(R.id.selectsheet_dialog_content_LV);
		selectsheet_dialog_content_LV.setVisibility(View.VISIBLE);
		selectsheet_dialog_content_LV.setAdapter(new ArrayAdapter<String>(mContext,
				R.layout.select_sheet_list_item_layout, R.id.select_sheet_list_item_btn, values));
		
		selectsheet_dialog_content_LV.setOnItemClickListener( itemClickListener );
	}
}
