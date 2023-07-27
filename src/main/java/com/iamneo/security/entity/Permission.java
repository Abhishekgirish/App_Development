package com.iamneo.security.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Permission {
	@Id
	private int permission_roleid;
    private String permission_name;
    private int permission_id;
    private String permission_module;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="usr_id",referencedColumnName="usr_id")
    private User user;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="ledger_id")
    private Ledger ledger;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="item_name")
    private Inventory inventory;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="acc_custid")
    private Account account;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="customer_id")
    private Customer customer;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="emp_id")
    private Employee employee;
    
}
