package com.android.hubview.binding

import android.view.View
import androidx.databinding.BindingAdapter
import com.android.hubview.R
import com.android.hubview.di.modules.GlideApp
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

/**
 * Created by Ankit Maheswari on 03/07/22.
 */

@BindingAdapter("setImage")
fun setImage(imageView: ShapeableImageView, imageUrl: String) {
    GlideApp.with(imageView.context)
        .load(imageUrl)
        .fallback(R.drawable.avatar_default)
        .into(imageView)
}

@BindingAdapter("setCreatedAt")
fun setCreatedAt(textView: MaterialTextView, createdAt: String) {
    val created = createdAt.split("T")[0]
    textView.text = textView.context.getString(R.string.pull_request_created, created)
}

@BindingAdapter("setClosedAt")
fun setClosedAt(textView: MaterialTextView, closedAt: String) {
    val closed = closedAt.split("T")[0]
    textView.text = textView.context.getString(R.string.pull_request_closed, closed)
}

@BindingAdapter("setVisible")
fun setVisible(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}
