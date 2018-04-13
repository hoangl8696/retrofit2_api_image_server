package criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by ly.honghoang on 4/12/2018.
 */

public class File {
    @SerializedName("fieldname")
    @Expose
    private String fieldname;
    @SerializedName("originalname")
    @Expose
    private String originalname;
    @SerializedName("encoding")
    @Expose
    private String encoding;
    @SerializedName("mimetype")
    @Expose
    private String mimetype;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("filename")
    @Expose
    private String filename;
    @SerializedName("metadata")
    @Expose
    private Object metadata;
    @SerializedName("bucketName")
    @Expose
    private String bucketName;
    @SerializedName("chunkSize")
    @Expose
    private Integer chunkSize;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("md5")
    @Expose
    private String md5;
    @SerializedName("uploadDate")
    @Expose
    private String uploadDate;
    @SerializedName("contentType")
    @Expose
    private String contentType;

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public String getOriginalname() {
        return originalname;
    }

    public void setOriginalname(String originalname) {
        this.originalname = originalname;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public Integer getChunkSize() {
        return chunkSize;
    }

    public void setChunkSize(Integer chunkSize) {
        this.chunkSize = chunkSize;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("fieldname", fieldname).append("originalname", originalname).append("encoding", encoding).append("mimetype", mimetype).append("id", id).append("filename", filename).append("metadata", metadata).append("bucketName", bucketName).append("chunkSize", chunkSize).append("size", size).append("md5", md5).append("uploadDate", uploadDate).append("contentType", contentType).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(contentType).append(bucketName).append(fieldname).append(size).append(id).append(mimetype).append(chunkSize).append(md5).append(encoding).append(filename).append(uploadDate).append(metadata).append(originalname).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof File) == false) {
            return false;
        }
        File rhs = ((File) other);
        return new EqualsBuilder().append(contentType, rhs.contentType).append(bucketName, rhs.bucketName).append(fieldname, rhs.fieldname).append(size, rhs.size).append(id, rhs.id).append(mimetype, rhs.mimetype).append(chunkSize, rhs.chunkSize).append(md5, rhs.md5).append(encoding, rhs.encoding).append(filename, rhs.filename).append(uploadDate, rhs.uploadDate).append(metadata, rhs.metadata).append(originalname, rhs.originalname).isEquals();
    }
}
