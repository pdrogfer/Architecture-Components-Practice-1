package com.pgf.architcompspractice1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pgf.architcompspractice1.model.User;
import com.squareup.picasso.Picasso;

import androidx.recyclerview.widget.RecyclerView;

class UserViewHolder extends RecyclerView.ViewHolder {

    ImageView userThumbnail;
    TextView userFirstName;
    TextView userLastName;

    public UserViewHolder(View itemRootView) {
        super(itemRootView);

        userThumbnail = itemRootView.findViewById(R.id.user_thumbnail);
        userFirstName = itemRootView.findViewById(R.id.user_firstname);
        userLastName = itemRootView.findViewById(R.id.user_lastname);
    }

    public void bindUser(User user) {

        Picasso.get()
                .load(user.getAvatarUrl())
                .resize(50, 50)
                .centerCrop()
                .into(userThumbnail);
        userFirstName.setText(user.getFirstName());
        userLastName.setText(user.getLastName());
    }
}
