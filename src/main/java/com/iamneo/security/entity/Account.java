package com.iamneo.security.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Account {
	@Id
	private int acc_custid;
    private String account_name;
    private int account_number;
    private String account_bank;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="usr_id")
    private User user;
    
    @OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name ="permission_roleid",referencedColumnName="acc_custid")
    private Set<Permission> permissions;
}

