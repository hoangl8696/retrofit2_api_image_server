package criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by ly.honghoang on 4/12/2018.
 */

public class UpdateUser {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("description")
    @Expose
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("age", age).append("description", description).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(description).append(age).append(name).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UpdateUser) == false) {
            return false;
        }
        UpdateUser rhs = ((UpdateUser) other);
        return new EqualsBuilder().append(description, rhs.description).append(age, rhs.age).append(name, rhs.name).isEquals();
    }
}
