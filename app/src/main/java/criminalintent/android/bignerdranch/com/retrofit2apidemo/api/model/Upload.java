package criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by ly.honghoang on 4/12/2018.
 */

public class Upload {
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("imageId")
    @Expose
    private String imageId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("imageId", imageId).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(imageId).append(name).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Upload) == false) {
            return false;
        }
        Upload rhs = ((Upload) other);
        return new EqualsBuilder().append(id, rhs.id).append(imageId, rhs.imageId).append(name, rhs.name).isEquals();
    }
}
