/*
 * Files.com API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 0.0.1
 * Contact: support@files.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.brick.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Create user session (log in)
 */
@Schema(description = "Create user session (log in)")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-25T22:25:43.390877+02:00[Europe/Paris]")
public class SessionEntity {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("language")
  private String language = null;

  @JsonProperty("login_token")
  private String loginToken = null;

  @JsonProperty("login_token_domain")
  private String loginTokenDomain = null;

  @JsonProperty("max_dir_listing_size")
  private Integer maxDirListingSize = null;

  @JsonProperty("multiple_regions")
  private Boolean multipleRegions = null;

  @JsonProperty("read_only")
  private Boolean readOnly = null;

  @JsonProperty("root_path")
  private String rootPath = null;

  @JsonProperty("site_id")
  private Integer siteId = null;

  @JsonProperty("ssl_required")
  private Boolean sslRequired = null;

  @JsonProperty("tls_disabled")
  private Boolean tlsDisabled = null;

  @JsonProperty("two_factor_setup_needed")
  private Boolean twoFactorSetupNeeded = null;

  @JsonProperty("allowed_2fa_method_sms")
  private Boolean allowed2faMethodSms = null;

  @JsonProperty("allowed_2fa_method_totp")
  private Boolean allowed2faMethodTotp = null;

  @JsonProperty("allowed_2fa_method_u2f")
  private Boolean allowed2faMethodU2f = null;

  @JsonProperty("allowed_2fa_method_yubi")
  private Boolean allowed2faMethodYubi = null;

  @JsonProperty("use_provided_modified_at")
  private Boolean useProvidedModifiedAt = null;

  @JsonProperty("windows_mode_ftp")
  private Boolean windowsModeFtp = null;

  public SessionEntity id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Session ID
   * @return id
  **/
  @Schema(example = "60525f92e859c4c3d74cb02fd176b1525901b525", description = "Session ID")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public SessionEntity language(String language) {
    this.language = language;
    return this;
  }

   /**
   * Session language
   * @return language
  **/
  @Schema(example = "en", description = "Session language")
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public SessionEntity loginToken(String loginToken) {
    this.loginToken = loginToken;
    return this;
  }

   /**
   * Login token. If set, this token will allow your user to log in via browser at the domain in &#x60;login_token_domain&#x60;.
   * @return loginToken
  **/
  @Schema(example = "@tok-randomcode", description = "Login token. If set, this token will allow your user to log in via browser at the domain in `login_token_domain`.")
  public String getLoginToken() {
    return loginToken;
  }

  public void setLoginToken(String loginToken) {
    this.loginToken = loginToken;
  }

  public SessionEntity loginTokenDomain(String loginTokenDomain) {
    this.loginTokenDomain = loginTokenDomain;
    return this;
  }

   /**
   * Domain to use with &#x60;login_token&#x60;.
   * @return loginTokenDomain
  **/
  @Schema(example = "https://mysite.files.com", description = "Domain to use with `login_token`.")
  public String getLoginTokenDomain() {
    return loginTokenDomain;
  }

  public void setLoginTokenDomain(String loginTokenDomain) {
    this.loginTokenDomain = loginTokenDomain;
  }

  public SessionEntity maxDirListingSize(Integer maxDirListingSize) {
    this.maxDirListingSize = maxDirListingSize;
    return this;
  }

   /**
   * Maximum number of files to retrieve per folder for a directory listing.  This is based on the user&#x27;s plan.
   * @return maxDirListingSize
  **/
  @Schema(description = "Maximum number of files to retrieve per folder for a directory listing.  This is based on the user's plan.")
  public Integer getMaxDirListingSize() {
    return maxDirListingSize;
  }

  public void setMaxDirListingSize(Integer maxDirListingSize) {
    this.maxDirListingSize = maxDirListingSize;
  }

  public SessionEntity multipleRegions(Boolean multipleRegions) {
    this.multipleRegions = multipleRegions;
    return this;
  }

   /**
   * Can access multiple regions?
   * @return multipleRegions
  **/
  @Schema(example = "true", description = "Can access multiple regions?")
  public Boolean isMultipleRegions() {
    return multipleRegions;
  }

  public void setMultipleRegions(Boolean multipleRegions) {
    this.multipleRegions = multipleRegions;
  }

  public SessionEntity readOnly(Boolean readOnly) {
    this.readOnly = readOnly;
    return this;
  }

   /**
   * Is this session read only?
   * @return readOnly
  **/
  @Schema(example = "true", description = "Is this session read only?")
  public Boolean isReadOnly() {
    return readOnly;
  }

  public void setReadOnly(Boolean readOnly) {
    this.readOnly = readOnly;
  }

  public SessionEntity rootPath(String rootPath) {
    this.rootPath = rootPath;
    return this;
  }

   /**
   * Initial root path to start the user&#x27;s session in.
   * @return rootPath
  **/
  @Schema(description = "Initial root path to start the user's session in.")
  public String getRootPath() {
    return rootPath;
  }

  public void setRootPath(String rootPath) {
    this.rootPath = rootPath;
  }

  public SessionEntity siteId(Integer siteId) {
    this.siteId = siteId;
    return this;
  }

   /**
   * Site ID
   * @return siteId
  **/
  @Schema(example = "1", description = "Site ID")
  public Integer getSiteId() {
    return siteId;
  }

  public void setSiteId(Integer siteId) {
    this.siteId = siteId;
  }

  public SessionEntity sslRequired(Boolean sslRequired) {
    this.sslRequired = sslRequired;
    return this;
  }

   /**
   * Is SSL required for this user?  (If so, ensure all your communications with this user use SSL.)
   * @return sslRequired
  **/
  @Schema(example = "true", description = "Is SSL required for this user?  (If so, ensure all your communications with this user use SSL.)")
  public Boolean isSslRequired() {
    return sslRequired;
  }

  public void setSslRequired(Boolean sslRequired) {
    this.sslRequired = sslRequired;
  }

  public SessionEntity tlsDisabled(Boolean tlsDisabled) {
    this.tlsDisabled = tlsDisabled;
    return this;
  }

   /**
   * Is strong TLS disabled for this user? (If this is set to true, the site administrator has signaled that it is ok to use less secure TLS versions for this user.)
   * @return tlsDisabled
  **/
  @Schema(description = "Is strong TLS disabled for this user? (If this is set to true, the site administrator has signaled that it is ok to use less secure TLS versions for this user.)")
  public Boolean isTlsDisabled() {
    return tlsDisabled;
  }

  public void setTlsDisabled(Boolean tlsDisabled) {
    this.tlsDisabled = tlsDisabled;
  }

  public SessionEntity twoFactorSetupNeeded(Boolean twoFactorSetupNeeded) {
    this.twoFactorSetupNeeded = twoFactorSetupNeeded;
    return this;
  }

   /**
   * If true, this user needs to add a Two Factor Authentication method before performing any further actions.
   * @return twoFactorSetupNeeded
  **/
  @Schema(description = "If true, this user needs to add a Two Factor Authentication method before performing any further actions.")
  public Boolean isTwoFactorSetupNeeded() {
    return twoFactorSetupNeeded;
  }

  public void setTwoFactorSetupNeeded(Boolean twoFactorSetupNeeded) {
    this.twoFactorSetupNeeded = twoFactorSetupNeeded;
  }

  public SessionEntity allowed2faMethodSms(Boolean allowed2faMethodSms) {
    this.allowed2faMethodSms = allowed2faMethodSms;
    return this;
  }

   /**
   * Sent only if 2FA setup is needed. Is SMS two factor authentication allowed?
   * @return allowed2faMethodSms
  **/
  @Schema(example = "true", description = "Sent only if 2FA setup is needed. Is SMS two factor authentication allowed?")
  public Boolean isAllowed2faMethodSms() {
    return allowed2faMethodSms;
  }

  public void setAllowed2faMethodSms(Boolean allowed2faMethodSms) {
    this.allowed2faMethodSms = allowed2faMethodSms;
  }

  public SessionEntity allowed2faMethodTotp(Boolean allowed2faMethodTotp) {
    this.allowed2faMethodTotp = allowed2faMethodTotp;
    return this;
  }

   /**
   * Sent only if 2FA setup is needed. Is TOTP two factor authentication allowed?
   * @return allowed2faMethodTotp
  **/
  @Schema(example = "true", description = "Sent only if 2FA setup is needed. Is TOTP two factor authentication allowed?")
  public Boolean isAllowed2faMethodTotp() {
    return allowed2faMethodTotp;
  }

  public void setAllowed2faMethodTotp(Boolean allowed2faMethodTotp) {
    this.allowed2faMethodTotp = allowed2faMethodTotp;
  }

  public SessionEntity allowed2faMethodU2f(Boolean allowed2faMethodU2f) {
    this.allowed2faMethodU2f = allowed2faMethodU2f;
    return this;
  }

   /**
   * Sent only if 2FA setup is needed. Is U2F two factor authentication allowed?
   * @return allowed2faMethodU2f
  **/
  @Schema(example = "true", description = "Sent only if 2FA setup is needed. Is U2F two factor authentication allowed?")
  public Boolean isAllowed2faMethodU2f() {
    return allowed2faMethodU2f;
  }

  public void setAllowed2faMethodU2f(Boolean allowed2faMethodU2f) {
    this.allowed2faMethodU2f = allowed2faMethodU2f;
  }

  public SessionEntity allowed2faMethodYubi(Boolean allowed2faMethodYubi) {
    this.allowed2faMethodYubi = allowed2faMethodYubi;
    return this;
  }

   /**
   * Sent only if 2FA setup is needed. Is Yubikey two factor authentication allowed?
   * @return allowed2faMethodYubi
  **/
  @Schema(example = "true", description = "Sent only if 2FA setup is needed. Is Yubikey two factor authentication allowed?")
  public Boolean isAllowed2faMethodYubi() {
    return allowed2faMethodYubi;
  }

  public void setAllowed2faMethodYubi(Boolean allowed2faMethodYubi) {
    this.allowed2faMethodYubi = allowed2faMethodYubi;
  }

  public SessionEntity useProvidedModifiedAt(Boolean useProvidedModifiedAt) {
    this.useProvidedModifiedAt = useProvidedModifiedAt;
    return this;
  }

   /**
   * Allow the user to provide file/folder modified at dates?  If false, the server will always use the current date/time.
   * @return useProvidedModifiedAt
  **/
  @Schema(example = "true", description = "Allow the user to provide file/folder modified at dates?  If false, the server will always use the current date/time.")
  public Boolean isUseProvidedModifiedAt() {
    return useProvidedModifiedAt;
  }

  public void setUseProvidedModifiedAt(Boolean useProvidedModifiedAt) {
    this.useProvidedModifiedAt = useProvidedModifiedAt;
  }

  public SessionEntity windowsModeFtp(Boolean windowsModeFtp) {
    this.windowsModeFtp = windowsModeFtp;
    return this;
  }

   /**
   * Does this user want to use Windows line-ending emulation?  (CR vs CRLF)
   * @return windowsModeFtp
  **/
  @Schema(description = "Does this user want to use Windows line-ending emulation?  (CR vs CRLF)")
  public Boolean isWindowsModeFtp() {
    return windowsModeFtp;
  }

  public void setWindowsModeFtp(Boolean windowsModeFtp) {
    this.windowsModeFtp = windowsModeFtp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SessionEntity sessionEntity = (SessionEntity) o;
    return Objects.equals(this.id, sessionEntity.id) &&
        Objects.equals(this.language, sessionEntity.language) &&
        Objects.equals(this.loginToken, sessionEntity.loginToken) &&
        Objects.equals(this.loginTokenDomain, sessionEntity.loginTokenDomain) &&
        Objects.equals(this.maxDirListingSize, sessionEntity.maxDirListingSize) &&
        Objects.equals(this.multipleRegions, sessionEntity.multipleRegions) &&
        Objects.equals(this.readOnly, sessionEntity.readOnly) &&
        Objects.equals(this.rootPath, sessionEntity.rootPath) &&
        Objects.equals(this.siteId, sessionEntity.siteId) &&
        Objects.equals(this.sslRequired, sessionEntity.sslRequired) &&
        Objects.equals(this.tlsDisabled, sessionEntity.tlsDisabled) &&
        Objects.equals(this.twoFactorSetupNeeded, sessionEntity.twoFactorSetupNeeded) &&
        Objects.equals(this.allowed2faMethodSms, sessionEntity.allowed2faMethodSms) &&
        Objects.equals(this.allowed2faMethodTotp, sessionEntity.allowed2faMethodTotp) &&
        Objects.equals(this.allowed2faMethodU2f, sessionEntity.allowed2faMethodU2f) &&
        Objects.equals(this.allowed2faMethodYubi, sessionEntity.allowed2faMethodYubi) &&
        Objects.equals(this.useProvidedModifiedAt, sessionEntity.useProvidedModifiedAt) &&
        Objects.equals(this.windowsModeFtp, sessionEntity.windowsModeFtp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, language, loginToken, loginTokenDomain, maxDirListingSize, multipleRegions, readOnly, rootPath, siteId, sslRequired, tlsDisabled, twoFactorSetupNeeded, allowed2faMethodSms, allowed2faMethodTotp, allowed2faMethodU2f, allowed2faMethodYubi, useProvidedModifiedAt, windowsModeFtp);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SessionEntity {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    loginToken: ").append(toIndentedString(loginToken)).append("\n");
    sb.append("    loginTokenDomain: ").append(toIndentedString(loginTokenDomain)).append("\n");
    sb.append("    maxDirListingSize: ").append(toIndentedString(maxDirListingSize)).append("\n");
    sb.append("    multipleRegions: ").append(toIndentedString(multipleRegions)).append("\n");
    sb.append("    readOnly: ").append(toIndentedString(readOnly)).append("\n");
    sb.append("    rootPath: ").append(toIndentedString(rootPath)).append("\n");
    sb.append("    siteId: ").append(toIndentedString(siteId)).append("\n");
    sb.append("    sslRequired: ").append(toIndentedString(sslRequired)).append("\n");
    sb.append("    tlsDisabled: ").append(toIndentedString(tlsDisabled)).append("\n");
    sb.append("    twoFactorSetupNeeded: ").append(toIndentedString(twoFactorSetupNeeded)).append("\n");
    sb.append("    allowed2faMethodSms: ").append(toIndentedString(allowed2faMethodSms)).append("\n");
    sb.append("    allowed2faMethodTotp: ").append(toIndentedString(allowed2faMethodTotp)).append("\n");
    sb.append("    allowed2faMethodU2f: ").append(toIndentedString(allowed2faMethodU2f)).append("\n");
    sb.append("    allowed2faMethodYubi: ").append(toIndentedString(allowed2faMethodYubi)).append("\n");
    sb.append("    useProvidedModifiedAt: ").append(toIndentedString(useProvidedModifiedAt)).append("\n");
    sb.append("    windowsModeFtp: ").append(toIndentedString(windowsModeFtp)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}