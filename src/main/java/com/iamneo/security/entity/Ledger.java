package com.iamneo.security.entity;

import java.util.List;
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
public class Ledger {
	@Id
	private int ledger_id;
    private String ledger_name;
    private String ledger_info;
    private int revenue;
    @OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name ="permission_roleid",referencedColumnName="ledger_id")
    private Set<Permission> permissions;
}
