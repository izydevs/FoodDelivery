package com.android.skuad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public class ProductViewRenderer extends RecyclerView.Adapter<ProductViewRenderer.ProductViewHolder> {

    private Context mContext;

    ProductViewRenderer (Context context){
        mContext = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.rv_item_product, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
       showImageWithGlide(mContext, "", holder.productImageView);
    }

    private void showImageWithGlide(Context context, String imageUrl, ImageView imageView){
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(16));
        Glide.with(context)
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9nimMLSPnpad5bP65gUv8m3sJcAGAsHS7gQ&usqp=CAU")
                .apply(requestOptions)
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView productImageView;
        ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            initViews(itemView);
        }

        private void initViews(View itemView) {
            productImageView = itemView.findViewById(R.id.ivProduct);
        }
    }
}
