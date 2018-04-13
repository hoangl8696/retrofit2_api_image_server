package criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by ly.honghoang on 4/12/2018.
 */

public class Credentials {
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;

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

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(email).append(password).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Credentials) == false) {
            return false;
        }
        Credentials rhs = ((Credentials) other);
        return new EqualsBuilder().append(email, rhs.email).append(password, rhs.password).isEquals();
    }
}
