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
public class Customer {
	@Id
	private int customer_id;
    private String customer_name;
    private int customer_mobile;
    private String cust_mail;
    private String cust_address;

    @OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name ="permission_roleid",referencedColumnName="customer_id")
    private Set<Permission> permissions;  
    

}
