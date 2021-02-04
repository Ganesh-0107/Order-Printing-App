package com.example.ordersapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class OrdersAdapter extends ArrayAdapter<orders>
{
    public OrdersAdapter(Activity context, ArrayList<orders> words)
    {
        super(context, 0, words);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listItemView = convertView;
        if (listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        orders currentOrder = getItem(position);

        int orderno = currentOrder.getOrderNo();
        String orderNo = String.valueOf(orderno);
        TextView ordersView =  (TextView) listItemView.findViewById(R.id.order_no);
        ordersView.setText(orderNo);

        int phonee = currentOrder.getphone();
        String phone = String.valueOf(phonee);
        TextView phoneView =  (TextView) listItemView.findViewById(R.id.phone);
        phoneView.setText(phone);

        String name = currentOrder.getname();
        TextView nameView =  (TextView) listItemView.findViewById(R.id.name);
        nameView.setText(name);

        String areaCode = currentOrder.getareaCode();
        TextView areaView =  (TextView) listItemView.findViewById(R.id.areacode);
        areaView.setText(areaCode);

        int quantityy = currentOrder.getquantity();
        String quantity = String.valueOf(quantityy);
        TextView quantityView =  (TextView) listItemView.findViewById(R.id.quantity);
        quantityView.setText(quantity);

        int amountt = currentOrder.getamount();
        String amount = String.valueOf(amountt);
        TextView amountView =  (TextView) listItemView.findViewById(R.id.amount);
        amountView.setText(amount);

        int totalPricee = currentOrder.gettotalPrice();
        String totalPrice = String.valueOf(totalPricee);
        TextView totalPriceView =  (TextView) listItemView.findViewById(R.id.totalprice);
        totalPriceView.setText(totalPrice);

        return listItemView;
    }


}