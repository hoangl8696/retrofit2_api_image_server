package criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by ly.honghoang on 4/12/2018.
 */

public class FileSummary {
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("length")
    @Expose
    private Integer length;
    @SerializedName("chunkSize")
    @Expose
    private Integer chunkSize;
    @SerializedName("uploadDate")
    @Expose
    private String uploadDate;
    @SerializedName("md5")
    @Expose
    private String md5;
    @SerializedName("filename")
    @Expose
    private String filename;
    @SerializedName("contentType")
    @Expose
    private String contentType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getChunkSize() {
        return chunkSize;
    }

    public void setChunkSize(Integer chunkSize) {
        this.chunkSize = chunkSize;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("length", length).append("chunkSize", chunkSize).append("uploadDate", uploadDate).append("md5", md5).append("filename", filename).append("contentType", contentType).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(chunkSize).append(md5).append(length).append(filename).append(contentType).append(uploadDate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FileSummary) == false) {
            return false;
        }
        FileSummary rhs = ((FileSummary) other);
        return new EqualsBuilder().append(id, rhs.id).append(chunkSize, rhs.chunkSize).append(md5, rhs.md5).append(length, rhs.length).append(filename, rhs.filename).append(contentType, rhs.contentType).append(uploadDate, rhs.uploadDate).isEquals();
    }
}
