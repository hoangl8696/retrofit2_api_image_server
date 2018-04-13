package criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model;

/**
 * Created by ly.honghoang on 4/12/2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class User {

    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("uploads")
    @Expose
    private List<Upload> uploads = null;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("contentfulId")
    @Expose
    private String contentfulId;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("name")
    @Expose
    private String name;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<Upload> getUploads() {
        return uploads;
    }

    public void setUploads(List<Upload> uploads) {
        this.uploads = uploads;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContentfulId() {
        return contentfulId;
    }

    public void setContentfulId(String contentfulId) {
        this.contentfulId = contentfulId;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(v).append(email).append(description).append(name).append(age).append(method).append(uploads).append(password).append(contentfulId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof User) == false) {
            return false;
        }
        User rhs = ((User) other);
        return new EqualsBuilder().append(id, rhs.id).append(v, rhs.v).append(email, rhs.email).append(description, rhs.description).append(name, rhs.name).append(age, rhs.age).append(method, rhs.method).append(uploads, rhs.uploads).append(password, rhs.password).append(contentfulId, rhs.contentfulId).isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("method", method).append("uploads", uploads).append("id", id).append("email", email).append("password", password).append("contentfulId", contentfulId).append("v", v).append("description", description).append("age", age).append("name", name).toString();
    }
}
