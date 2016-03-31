package pw.bits.weisper.view.holder;

import android.view.View;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import pw.bits.weisper.R;
import pw.bits.weisper.library.bean.Picture;
import pw.bits.weisper.library.bean.Status;
import pw.bits.weisper.view.image.AvatarImageView;
import pw.bits.weisper.view.image.PictureFlowLayout;
import pw.bits.weisper.view.widget.StatusTextView;

/**
 * Created by rzh on 16/3/19.
 */
public class PictureFlowViewHolder extends StatusAbstractViewHolder {
    @Bind(R.id.picture_flow_layout)
    PictureFlowLayout picture_flow_layout;

    @Bind(R.id.status_text)
    StatusTextView status_text;

    @Bind(R.id.user_profile_image)
    AvatarImageView user_profile_image;

    private int parentWidth = 0;

    public PictureFlowViewHolder(View itemView, int parentWidth) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.parentWidth = parentWidth;
    }

    public void bindView(Status status) {
        List<Picture> pictures = status.getRetweeted() == null ? status.getPictures() : status.getRetweeted().getPictures();

        itemView.setVisibility(pictures.size() == 0 ? View.GONE : View.VISIBLE);
        if (pictures.size() == 0) {
            itemView.getLayoutParams().height = 0;
        }

        user_profile_image.setUser(status.getUser());
        status_text.setText(status.getText());
        picture_flow_layout.setPictures(pictures, parentWidth);
    }
}