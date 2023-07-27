package com.iamneo.security.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Login {
	@Id
	private int login_id;
    private String login_password;
    private String login_username;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="usr_id",referencedColumnName="usr_id")
    private User user;
}
