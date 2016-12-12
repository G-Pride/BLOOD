package com.example.kuaidian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.kuaidian.ShopcartExpandableListViewAdapter.CheckInterface;
import com.example.kuaidian.ShopcartExpandableListViewAdapter.ModifyCountInterface;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

public class ShopCar extends Activity implements CheckInterface,
		ModifyCountInterface, OnClickListener {
	private ExpandableListView exListView;
	private CheckBox cb_check_all;
	private TextView tv_total_price;
	private TextView tv_delete;
	private TextView tv_go_to_pay;
	private Context context;

	private double totalPrice = 0.00;// �������Ʒ�ܼ�
	private int totalCount = 0;// �������Ʒ������

	private ShopcartExpandableListViewAdapter selva;
	private List<GroupInfo> groups = new ArrayList<GroupInfo>();// ��Ԫ�������б�
	private Map<String, List<ProductInfo>> children = new HashMap<String, List<ProductInfo>>();// ��Ԫ�������б�

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.shopcar);

		initView();
		initEvents();
	}

	private void initView() {
		context = this;
		virtualData();
		exListView = (ExpandableListView) findViewById(R.id.exListView);
		cb_check_all = (CheckBox) findViewById(R.id.all_chekbox);
		tv_total_price = (TextView) findViewById(R.id.tv_total_price);
		tv_delete = (TextView) findViewById(R.id.tv_delete);
		tv_go_to_pay = (TextView) findViewById(R.id.tv_go_to_pay);
	}

	private void initEvents() {
		selva = new ShopcartExpandableListViewAdapter(groups, children, this);
		selva.setCheckInterface(this);// �ؼ�����1,���ø�ѡ��ӿ�
		selva.setModifyCountInterface(this);// �ؼ�����2,�������������ӿ�
		exListView.setAdapter(selva);

		for (int i = 0; i < selva.getGroupCount(); i++) {
			exListView.expandGroup(i);// �ؼ�����3,��ʼ��ʱ����ExpandableListView��չ���ķ�ʽ����
		}

		cb_check_all.setOnClickListener(this);
		tv_delete.setOnClickListener(this);
		tv_go_to_pay.setOnClickListener(this);
	}

	/**
	 * ģ������<br>
	 * ��ѭ�������������б����ԭ����Ԫ�ر�����һ��List�У���Ӧ����Ԫ����Ͻ����Ԫ�ر�����Map�У�<br>
	 * �������Ԫ�ص�Id(ͨ����һ��Ψһָ����Ԫ����ݵ�ֵ)
	 */
	private void virtualData() {

		for (int i = 0; i < 6; i++) {

			groups.add(new GroupInfo(i + "", "��ʳ��" + (i + 1) + "�ŵ�"));

			List<ProductInfo> products = new ArrayList<ProductInfo>();
			for (int j = 0; j <= i; j++) {

				products.add(new ProductInfo(j + "", "��Ʒ", "", groups.get(i)
						.getName() + "�ĵ�" + (j + 1) + "����Ʒ", 12.00 + i * j, 1));
			}
			children.put(groups.get(i).getId(), products);// ����Ԫ�ص�һ��Ψһֵ������ȡId����Ϊ��Ԫ��List��Key
		}
	}

	@Override
	public void onClick(View v) {
		AlertDialog alert;
		switch (v.getId()) {
		case R.id.all_chekbox:
			doCheckAll();
			break;
		case R.id.tv_go_to_pay:
			if (totalCount == 0) {
				Toast.makeText(context, "��ѡ��Ҫ֧������Ʒ", Toast.LENGTH_LONG).show();
				return;
			}
			alert = new AlertDialog.Builder(context).create();
			alert.setTitle("������ʾ");
			alert.setMessage("�ܼ�:\n" + totalCount + "����Ʒ\n" + totalPrice + "Ԫ");
			alert.setButton(DialogInterface.BUTTON_NEGATIVE, "ȡ��",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							return;
						}
					});
			alert.setButton(DialogInterface.BUTTON_POSITIVE, "ȷ��",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							return;
						}
					});
			alert.show();
			break;
		case R.id.tv_delete:
			if (totalCount == 0) {
				Toast.makeText(context, "��ѡ��Ҫ�Ƴ�����Ʒ", Toast.LENGTH_LONG).show();
				return;
			}
			alert = new AlertDialog.Builder(context).create();
			alert.setTitle("������ʾ");
			alert.setMessage("��ȷ��Ҫ����Щ��Ʒ�ӹ��ﳵ���Ƴ���");
			alert.setButton(DialogInterface.BUTTON_NEGATIVE, "ȡ��",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							return;
						}
					});
			alert.setButton(DialogInterface.BUTTON_POSITIVE, "ȷ��",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							doDelete();
						}
					});
			alert.show();
			break;
		}
	}

	/**
	 * ɾ������<br>
	 * 1.��Ҫ�߱�����ɾ�������׳�������Խ������<br>
	 * 2.�ֽ�Ҫɾ���Ķ���Ž���Ӧ���б������У������������removeAll�ķ�ʽ����ɾ��
	 */
	protected void doDelete() {
		List<GroupInfo> toBeDeleteGroups = new ArrayList<GroupInfo>();// ��ɾ������Ԫ���б�
		for (int i = 0; i < groups.size(); i++) {
			GroupInfo group = groups.get(i);
			if (group.isChoosed()) {

				toBeDeleteGroups.add(group);
			}
			List<ProductInfo> toBeDeleteProducts = new ArrayList<ProductInfo>();// ��ɾ������Ԫ���б�
			List<ProductInfo> childs = children.get(group.getId());
			for (int j = 0; j < childs.size(); j++) {
				if (childs.get(j).isChoosed()) {
					toBeDeleteProducts.add(childs.get(j));
				}
			}
			childs.removeAll(toBeDeleteProducts);

		}

		groups.removeAll(toBeDeleteGroups);

		selva.notifyDataSetChanged();
		calculate();
	}

	@Override
	public void doIncrease(int groupPosition, int childPosition,
			View showCountView, boolean isChecked) {

		ProductInfo product = (ProductInfo) selva.getChild(groupPosition,
				childPosition);
		int currentCount = product.getCount();
		currentCount++;
		product.setCount(currentCount);
		((TextView) showCountView).setText(currentCount + "");

		selva.notifyDataSetChanged();
		calculate();
	}

	@Override
	public void doDecrease(int groupPosition, int childPosition,
			View showCountView, boolean isChecked) {

		ProductInfo product = (ProductInfo) selva.getChild(groupPosition,
				childPosition);
		int currentCount = product.getCount();
		if (currentCount == 1)
			return;
		currentCount--;

		product.setCount(currentCount);
		((TextView) showCountView).setText(currentCount + "");

		selva.notifyDataSetChanged();
		calculate();
	}

	@Override
	public void checkGroup(int groupPosition, boolean isChecked) {
		GroupInfo group = groups.get(groupPosition);
		List<ProductInfo> childs = children.get(group.getId());
		for (int i = 0; i < childs.size(); i++) {
			childs.get(i).setChoosed(isChecked);
		}
		if (isAllCheck())
			cb_check_all.setChecked(true);
		else
			cb_check_all.setChecked(false);
		selva.notifyDataSetChanged();
		calculate();
	}

	@Override
	public void checkChild(int groupPosition, int childPosiTion,
			boolean isChecked) {
		boolean allChildSameState = true;// �жϸ��������������Ԫ���Ƿ���ͬһ��״̬
		GroupInfo group = groups.get(groupPosition);
		List<ProductInfo> childs = children.get(group.getId());
		for (int i = 0; i < childs.size(); i++) {
			if (childs.get(i).isChoosed() != isChecked) {
				allChildSameState = false;
				break;
			}
		}
		if (allChildSameState) {
			group.setChoosed(isChecked);// ���������Ԫ��״̬��ͬ����ô��Ӧ����Ԫ�ر���Ϊ����ͳһ״̬
		} else {
			group.setChoosed(false);// ������Ԫ��һ������Ϊδѡ��״̬
		}

		if (isAllCheck())
			cb_check_all.setChecked(true);
		else
			cb_check_all.setChecked(false);
		selva.notifyDataSetChanged();
		calculate();
	}

	private boolean isAllCheck() {

		for (GroupInfo group : groups) {
			if (!group.isChoosed())
				return false;

		}

		return true;
	}

	/** ȫѡ�뷴ѡ */
	private void doCheckAll() {
		for (int i = 0; i < groups.size(); i++) {
			groups.get(i).setChoosed(cb_check_all.isChecked());
			GroupInfo group = groups.get(i);
			List<ProductInfo> childs = children.get(group.getId());
			for (int j = 0; j < childs.size(); j++) {
				childs.get(j).setChoosed(cb_check_all.isChecked());
			}
		}
		selva.notifyDataSetChanged();
	}

	/**
	 * ͳ�Ʋ���<br>
	 * 1.�����ȫ�ּ�����<br>
	 * 2.����������Ԫ�أ�ֻҪ�Ǳ�ѡ��״̬�ģ��ͽ�����صļ������<br>
	 * 3.���ײ���textView�����������
	 */
	private void calculate() {
		totalCount = 0;
		totalPrice = 0.00;
		for (int i = 0; i < groups.size(); i++) {
			GroupInfo group = groups.get(i);
			List<ProductInfo> childs = children.get(group.getId());
			for (int j = 0; j < childs.size(); j++) {
				ProductInfo product = childs.get(j);
				if (product.isChoosed()) {
					totalCount++;
					totalPrice += product.getPrice() * product.getCount();
				}
			}
		}
		tv_total_price.setText("��" + totalPrice);
		tv_go_to_pay.setText("ȥ֧��(" + totalCount + ")");
	}

}
