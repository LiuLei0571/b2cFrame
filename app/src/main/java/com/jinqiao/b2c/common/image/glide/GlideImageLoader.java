package com.jinqiao.b2c.common.image.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.jinqiao.b2c.R;
import com.jinqiao.b2c.common.helper.ThreadHelper;
import com.jinqiao.b2c.common.image.DisplayOption;
import com.jinqiao.b2c.common.image.ImageDisplayLoader;
import com.jinqiao.b2c.common.image.ImageLoadListener;

import java.io.File;

/**
 * 用途：
 * Created by milk on 17/4/18.
 * 邮箱：649444395@qq.com
 */

public class GlideImageLoader implements ImageDisplayLoader {
    private Context mContext;

    public GlideImageLoader(Context context) {
        mContext = context;
    }

    @Override
    public void display(ImageView imageView, String url, ImageLoadListener listener, DisplayOption  opts) {
        if (imageView != null) {
            DrawableTypeRequest<String> drawableTypeRequest = Glide.with(mContext).load(url);
            if (opts != null) {
                if (opts.cacheMemory != null) {
                    drawableTypeRequest.skipMemoryCache(!opts.cacheMemory);
                }
                if (opts.cacheOnDisk != null) {
                    if (opts.cacheOnDisk) {
                        drawableTypeRequest.diskCacheStrategy(DiskCacheStrategy.SOURCE);
                    } else {
                        drawableTypeRequest.diskCacheStrategy(DiskCacheStrategy.NONE);
                    }
                }
                if (opts.errorResId != null) {
                    drawableTypeRequest.error(opts.errorResId);
                }
                if (opts.maxHeight != null && opts.maxWith != null) {
                    drawableTypeRequest.override(opts.maxWith, opts.maxHeight);
                }
                if (opts.defaultResId != -1) {
                    drawableTypeRequest.placeholder(opts.defaultResId);
                }
                if (opts.loadingResId != -1) {
                    drawableTypeRequest.placeholder(opts.loadingResId);
                }
            }
            if (listener != null) {
                drawableTypeRequest.listener(new RequestListener() {
                    @Override
                    public boolean onException(Exception e, Object model, Target target, boolean isFirstResource) {
                        listener.onLoadFail(url, imageView, e);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Object resource, Object model, Target target, boolean isFromMemoryCache, boolean isFirstResource) {
                        if (resource instanceof GlideBitmapDrawable) {
                            GlideBitmapDrawable resource1 = (GlideBitmapDrawable) resource;
                            listener.onLoadSucess(imageView, resource1.getBitmap());
                        } else {
                            listener.onLoadSucess(imageView, null);
                        }
                        return false;
                    }
                });
            }
            drawableTypeRequest.thumbnail(0.4f).dontAnimate().into(imageView);
        }
    }

    @Override
    public Bitmap syncLoad(File file) {
        try {
            return Glide.with(mContext).load(file).asBitmap().dontAnimate().placeholder(R.drawable.ic_no_image).thumbnail(0.4f).into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).get();
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public Bitmap syncLoad(String url) {
        try {
            return Glide.with(mContext).load(url).asBitmap().dontAnimate().placeholder(R.drawable.ic_no_image).thumbnail(0.4f).into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).get();

        } catch (Exception e) {

        }

        return null;
    }

    @Override
    public void clearCache(int... cachePress) {
        if (cachePress != null) {
            for (int cache : cachePress) {
                switch (cache) {
                    case ImageDisplayLoader.CACHE_IN_DISK:
                        if (ThreadHelper.isMainThread()) {
                            ThreadHelper.postMain(new Runnable() {
                                @Override
                                public void run() {
                                    Glide.get(mContext).clearDiskCache();

                                }
                            });
                        } else {
                            Glide.get(mContext).clearDiskCache();

                        }
                        break;
                    case ImageDisplayLoader.CACHE_IN_MEN:
                        Glide.get(mContext).clearMemory();//清理内存缓存
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    public void pause() {
        Glide.with(mContext).pauseRequests();
    }

    @Override
    public void resume() {
        Glide.with(mContext).resumeRequests();
    }

    @Override
    public void preLoad(String url) {
        if (!ThreadHelper.isMainThread()) {
            ThreadHelper.postMain(new Runnable() {
                @Override
                public void run() {
                    Glide.with(mContext).load(url).asBitmap().placeholder(R.drawable.ic_no_image).preload(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
                }
            });
        } else {
            Glide.with(mContext).load(url).asBitmap().placeholder(R.drawable.ic_no_image).preload(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);

        }
    }
}
