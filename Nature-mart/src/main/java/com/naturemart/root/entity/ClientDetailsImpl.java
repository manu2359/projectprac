package com.naturemart.root.entity;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;



@Entity
@Table(name="ClientDetails")
public class ClientDetailsImpl implements ClientDetails {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer AccessTokenValiditySeconds;
	@Transient
	private Map<String, Object> AdditionalInformation;
	
	@ManyToMany
	 @JoinTable( name="client_clientauthorities",
	   			 joinColumns= {@JoinColumn(name="cid")},
	             inverseJoinColumns= {@JoinColumn(name="caid")}
	 )
    private Collection<ClientDetailsGrantedAuthority> clientDetailsGrantedAuthority;
	
	@Transient
	private Collection<GrantedAuthority> Authorities;
	
	@Transient
	private Set<String> AuthorizedGrantTypes;
	
	private String clientId;
	
	private String ClientSecret;
	
	private Integer RefreshTokenValiditySeconds;
	
	 @Transient
	 private Set<String> registeredRedirectUri;
	 @Transient
	 private Set<String> resourceIds;
	 @Transient
	 private Set<String> scope;
	 
	 private boolean autoApprove;
	 private boolean scoped;
	 private boolean secretRequired;
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Collection<ClientDetailsGrantedAuthority> getClientDetailsGrantedAuthority() {
		return clientDetailsGrantedAuthority;
	}

	public void setClientDetailsGrantedAuthority(Collection<ClientDetailsGrantedAuthority> clientDetailsGrantedAuthority) {
		this.clientDetailsGrantedAuthority = clientDetailsGrantedAuthority;
	}

	public boolean isAutoApprove() {
		return autoApprove;
	}

	public void setAutoApprove(boolean autoApprove) {
		this.autoApprove = autoApprove;
	}

	public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
		AccessTokenValiditySeconds = accessTokenValiditySeconds;
	}

	public void setAdditionalInformation(Map<String, Object> additionalInformation) {
		AdditionalInformation = additionalInformation;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		Authorities = authorities;
	}

	public void setAuthorizedGrantTypes(Set<String> authorizedGrantTypes) {
		AuthorizedGrantTypes = authorizedGrantTypes;
	}

	public void setClientId(String clientId) {
		clientId = clientId;
	}

	public void setClientSecret(String clientSecret) {
		ClientSecret = clientSecret;
	}

	public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
		RefreshTokenValiditySeconds = refreshTokenValiditySeconds;
	}

	public void setRegisteredRedirectUri(Set<String> registeredRedirectUri) {
		this.registeredRedirectUri = registeredRedirectUri;
	}

	public void setResourceIds(Set<String> resourceIds) {
		this.resourceIds = resourceIds;
	}

	public void setScope(Set<String> scope) {
		this.scope = scope;
	}

	public void setScoped(boolean scoped) {
		this.scoped = scoped;
	}

	public void setSecretRequired(boolean secretRequired) {
		this.secretRequired = secretRequired;
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		
		return this.AccessTokenValiditySeconds;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		
		return this.AdditionalInformation;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
	
		return this.Authorities;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		
		return this.AuthorizedGrantTypes;
	}

	@Override
	public String getClientId() {
		
		return this.clientId;
	}

	@Override
	public String getClientSecret() {
		
		return ClientSecret;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		
		return this.RefreshTokenValiditySeconds;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		
		return this.registeredRedirectUri;
	}

	@Override
	public Set<String> getResourceIds() {
		
		return this.resourceIds;
	}

	@Override
	public Set<String> getScope() {
	
		return this.scope;
	}

	@Override
	public boolean isAutoApprove(String arg0) {
		
		return this.autoApprove;
	}

	@Override
	public boolean isScoped() {
		return this.scoped;
	}

	@Override
	public boolean isSecretRequired() {
	
		return this.secretRequired;
	}

}
