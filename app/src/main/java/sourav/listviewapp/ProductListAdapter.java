package sourav.listviewapp;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.vdopia.ads.lw.LVDOAdRequest;
import com.vdopia.ads.lw.LVDOAdSize;
import com.vdopia.ads.lw.LVDOBannerAd;
import com.vdopia.ads.lw.LVDOBannerAdListener;
import com.vdopia.ads.lw.LVDOConstants;



/**
 * Created by souravbanik on 6/7/18.
 */

public class ProductListAdapter extends BaseAdapter {

    private Context mContext;
    private List<product> mProductList;
    private Map<Integer, View> mViews = new HashMap<>();
    private boolean mAdLoaded;
    private LVDOBannerAd mAdView;
    private  LVDOAdSize mAdSize;

    public ProductListAdapter(Context mContext, List<product> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v =View.inflate(mContext,R.layout.item_product_list,null);

        TextView tvName =(TextView)v.findViewById(R.id.tv_name);
        TextView tvPrice =(TextView)v.findViewById(R.id.tv_price);
        TextView tvDescription =(TextView)v.findViewById(R.id.tv_description);
        LinearLayout llSecond=(LinearLayout)v.findViewById(R.id.llSecond);
        tvName.setText(mProductList.get(position).getName());
        tvPrice.setText(String.valueOf(mProductList.get(position).getPrice())+ "INR");
        tvDescription.setText(mProductList.get(position).getDescription());
        v.setTag(mProductList.get(position).getId());

        if (!mAdLoaded) {
            loadInviewAd(llSecond, position);
        } else {
            View view = mViews.get(position);
            if (view != null) {
                ViewGroup parentViewGroup = (ViewGroup) view.getParent();
                if (parentViewGroup != null) {
                    parentViewGroup.removeAllViews();
                }
                llSecond.addView(view);
            }
        }

        return v;
    }


    private void loadInviewAd(final LinearLayout inViewAd, final int i) {
        LVDOAdRequest adRequest = new LVDOAdRequest(mContext);

        ArrayList<LVDOConstants.PARTNER> mPartnerNames = new ArrayList<>();
        LVDOConstants.PARTNER partner = LVDOConstants.PARTNER.ALL;
        mPartnerNames.add(partner);
        adRequest.setPartnerNames(mPartnerNames);

        //LocationData locationData = new LocationData(mActivity);
        //adRequest.setLocation(locationData.getDeviceLocation());

        adRequest.setDmaCode("807");
        adRequest.setEthnicity("Asian");
        adRequest.setPostalCode("110096");
        adRequest.setCurrPostal("201301");
        adRequest.setAge("27");
        //  adRequest.setMaritalStatus(LVDOAdRequest.LVDOMartialStatus.Single.toString());
        //adRequest.setAppVersion(Utils.getAppVersion(mActivity));
        adRequest.setGender(LVDOAdRequest.LVDOGender.MALE);
        //adRequest.setBirthday(Utils.getDate());
        adRequest.setRequester("Vdopia");
        //adRequest.setAppBundle("chocolateApp");
        adRequest.setAppDomain("vdopia.com");
        // adRequest.setAppName("VdopiaSampleApp");
        adRequest.setAppStoreUrl("play.google.com");
        adRequest.setCategory("prerollad");
        adRequest.setPublisherDomain("vdopia.com");

        mAdView = new LVDOBannerAd(mContext, LVDOAdSize.INVIEW_LEADERBOARD, "llpHX8", new LVDOBannerAdListener() {
            @Override
            public void onBannerAdLoaded(View banner) {
                Log.d("Inview", "Inview Inline Ad Loaded");
                if (banner != null) {
                    ViewGroup parentViewGroup = (ViewGroup) banner.getParent();
                    if (parentViewGroup != null) {
                        parentViewGroup.removeAllViews();
                    }
                    mViews.put(i, banner);
                    mAdLoaded = true;
                    inViewAd.addView(banner);
                    LVDOAdRequest adRequest1 = new LVDOAdRequest(mContext);
                    LVDOBannerAd.prefetch(mContext, LVDOAdSize.INVIEW_LEADERBOARD, "llpHX8", adRequest1);


                }

            }

            @Override
            public void onBannerAdFailed(View banner, LVDOConstants.LVDOErrorCode errorCode) {
                Log.d("Inview", "Inview Inline Ad Failed " + errorCode.toString());
                mAdLoaded = false;
            }

            @Override
            public void onBannerAdClicked(View banner) {
                Log.d("Inview", "Inview Inline Ad Clicked");
            }

            @Override
            public void onBannerAdClosed(View banner) {
                Log.d("Inview", "Inview Inline Ad Closed");

            }

            private void removeViews() {

                inViewAd.setVisibility(View.GONE);
                inViewAd.removeAllViews();
            }
        });

        mAdView.loadAd(adRequest);
    }

    public void destroyView() {
        if (mAdView != null) {
            mAdView.destroyView();
        }
    }
}
