package criminalintent.android.bignerdranch.com.retrofit2apidemo.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by ly.honghoang on 4/12/2018.
 */

public class AuthResponse {
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("user")
    @Expose
    private User user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(token).append(user).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AuthResponse) == false) {
            return false;
        }
        AuthResponse rhs = ((AuthResponse) other);
        return new EqualsBuilder().append(token, rhs.token).append(user, rhs.user).isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("token", token).append("user", user).toString();
    }
}
