package com.mseen.example.ui.test;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.TextView;

import com.mseen.ui.actionsheet.ActionSheetDialog;
import com.mseen.ui.actionsheet.ActionSheetPopupWindow;
import com.mseen.ui.actionsheet.R;

public class MainActivity extends Activity {

	ActionSheetPopupWindow menuWindow;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv = (TextView) this.findViewById(R.id.text);
		tv.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				menuWindow = new ActionSheetPopupWindow(MainActivity.this, itemsOnClick);
				menuWindow.showAtLocation(MainActivity.this.findViewById(R.id.main), Gravity.BOTTOM
						| Gravity.CENTER_HORIZONTAL, 0, 0);
			}
		});

		TextView show_selectsheet_dialog_TV = (TextView) this.findViewById(R.id.show_selectsheet_dialog_TV);
		show_selectsheet_dialog_TV.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				ActionSheetDialog acionSheetDialog = new ActionSheetDialog(MainActivity.this);

				List<String> values = new ArrayList<String>();
				values.add("拍照");
				values.add("添加文本");
				values.add("添加连接");
				acionSheetDialog.addMenuItems(values, new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
						System.out.println("position" + position);
					}
				});
				acionSheetDialog.setNegativeButton("取消掉吧", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
				acionSheetDialog.setPositiveButton("确定好了", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				});
				acionSheetDialog.show();
			}
		});

	}

	private OnClickListener itemsOnClick = new OnClickListener() {

		public void onClick(View v) {
			menuWindow.dismiss();
		}

	};

}
