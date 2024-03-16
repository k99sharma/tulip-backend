package com.kalash.tulip.pojo;

import com.kalash.tulip.config.Constants;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Validated
@NoArgsConstructor
@Table(name = "users")
public class UserPojo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min=1, max=20)
    private String firstName;

    @Nullable
    @Size(min=1, max=20)
    private String lastName;

    @Column(unique = true)
    @NotEmpty
    @Email
    private String email;
    private String role;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @PrePersist
    public void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
        this.role = Constants.Roles.USER.getValue();   // user is default role
    }

    @PreUpdate
    public void onUpdate(){
        this.modifiedAt = LocalDateTime.now();
    }

    private void setCreatedAt(LocalDateTime localDateTime){
        this.createdAt = localDateTime;
    }

    private void setModifiedAt(LocalDateTime localDateTime){
        this.createdAt = localDateTime;
    }
}
