package com.jinqiao.b2c.common.image;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

import java.io.File;

/**
 */
public class VILImageLoader implements ImageDisplayLoader {
    private static final String FILE_PRE = "file:///";
    private ImageLoader imageLoader = null;
    private DisplayImageOptions defaultDisplayImageOptions;

    public VILImageLoader(ImageLoader imageLoader, DisplayImageOptions defaultDisplayImageOptions) {
        this.imageLoader = imageLoader;
        this.defaultDisplayImageOptions = defaultDisplayImageOptions;
    }


    public void display(ImageView imageView, String url, final ImageLoadListener listener,
                        DisplayOption opts) {
        ImageViewAware imageViewAware = new ImageViewAware(imageView);
        DisplayImageOptions displayImageOptions;
        ImageSize targetSize = null;
        if (opts != null) {
            DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder()
                    .cloneFrom(defaultDisplayImageOptions);
            if (opts.cacheMemory != null) {
                builder.cacheInMemory(opts.cacheMemory);
            }
            if (opts.cacheOnDisk != null) {
                builder.cacheOnDisk(opts.cacheOnDisk);
            }
            if (opts.errorResId != null) {
                builder.showImageOnFail(opts.errorResId);
            }
            if (opts.maxHeight != null && opts.maxWith != null) {
                targetSize = new ImageSize(opts.maxWith, opts.maxHeight);
            }
            if (opts.defaultResId != -1) {
                builder.showImageForEmptyUri(opts.defaultResId);
            }
            if (opts.loadingResId != -1) {
                builder.showImageOnLoading(opts.loadingResId);
            }
            if (opts.errorResId != -1) {
                builder.showImageOnFail(opts.errorResId);
            }
            displayImageOptions = builder.build();
        } else {
            displayImageOptions = defaultDisplayImageOptions;
        }

        if (listener == null) {
            imageLoader.displayImage(url, imageViewAware, displayImageOptions, targetSize, null, null);
        } else {
            imageLoader.displayImage(url, imageViewAware, displayImageOptions, targetSize,
                    new ImageLoadingListener() {
                        @Override
                        public void onLoadingStarted(String imageUri, View view) {
                        }

                        @Override
                        public void onLoadingFailed(String imageUri, View view,
                                                    FailReason failReason) {
                            listener.onLoadFail(imageUri, view, failReason.getCause());
                        }

                        @Override
                        public void onLoadingComplete(String imageUri, View view,
                                                      Bitmap loadedImage) {
                            listener.onLoadSucess(view, loadedImage);
                        }

                        @Override
                        public void onLoadingCancelled(String imageUri, View view) {
                            listener.onLoadFail(imageUri, view, null);
                        }
                    }, new ImageLoadingProgressListener() {
                        @Override
                        public void onProgressUpdate(String imageUri, View view, int current,
                                                     int total) {
                            listener.onProgressUpdate(current, total);
                        }
                    });
        }
    }


    @Override
    public Bitmap syncLoad(File file) {
        if (file != null && file.isFile() && file.exists()) {
            String url = FILE_PRE + file.getAbsolutePath();
            return imageLoader.loadImageSync(url);
        }
        return null;
    }

    @Override
    public Bitmap syncLoad(String url) {
        return imageLoader.loadImageSync(url);
    }

    @Override
    public void clearCache(int... cachePlaces) {
        if (cachePlaces != null) {
            for (int cachePlace : cachePlaces) {
                switch (cachePlace) {
                    case ImageDisplayLoader.CACHE_IN_DISK:
                        imageLoader.clearDiskCache();
                        break;
                    case ImageDisplayLoader.CACHE_IN_MEN:
                        imageLoader.clearMemoryCache();
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    public void pause() {
        imageLoader.pause();
    }

    @Override
    public void resume() {
        imageLoader.resume();
    }

    @Override
    public void preLoad(String url) {
        syncLoad(url);
    }
}
