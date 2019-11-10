package ginp14.project3.model;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class ConfirmationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "token_id")
    private long tokenID;

    @Column(name = "confirmation_token")
    private String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    public ConfirmationToken() {
    }

    public ConfirmationToken(User user) {
        this.user = user;
        created_at = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }

    public long getTokenID() {
        return tokenID;
    }

    public void setTokenID(long tokenID) {
        this.tokenID = tokenID;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
