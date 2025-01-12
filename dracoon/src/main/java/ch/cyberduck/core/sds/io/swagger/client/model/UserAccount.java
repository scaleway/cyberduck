/*
 * DRACOON API
 * REST Web Services for DRACOON<br><br>This page provides an overview of all available and documented DRACOON APIs, which are grouped by tags.<br>Each tag provides a collection of APIs that are intended for a specific area of the DRACOON.<br><br><a title='Developer Information' href='https://developer.dracoon.com'>Developer Information</a>&emsp;&emsp;<a title='Get SDKs on GitHub' href='https://github.com/dracoon'>Get SDKs on GitHub</a><br><br><a title='Terms of service' href='https://www.dracoon.com/terms/general-terms-and-conditions/'>Terms of service</a>
 *
 * OpenAPI spec version: 4.30.0-beta.4
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.sds.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import ch.cyberduck.core.sds.io.swagger.client.model.CustomerData;
import ch.cyberduck.core.sds.io.swagger.client.model.RoleList;
import ch.cyberduck.core.sds.io.swagger.client.model.UserAttributes;
import ch.cyberduck.core.sds.io.swagger.client.model.UserAuthData;
import ch.cyberduck.core.sds.io.swagger.client.model.UserAuthMethod;
import ch.cyberduck.core.sds.io.swagger.client.model.UserGroup;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
/**
 * User information
 */
@Schema(description = "User information")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-08-16T11:28:10.116221+02:00[Europe/Zurich]")
public class UserAccount {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("userName")
  private String userName = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("isLocked")
  private Boolean isLocked = false;

  @JsonProperty("hasManageableRooms")
  private Boolean hasManageableRooms = null;

  @JsonProperty("userRoles")
  private RoleList userRoles = null;

  @JsonProperty("language")
  private String language = null;

  @JsonProperty("authData")
  private UserAuthData authData = null;

  @JsonProperty("mustSetEmail")
  private Boolean mustSetEmail = false;

  @JsonProperty("needsToAcceptEULA")
  private Boolean needsToAcceptEULA = null;

  @JsonProperty("expireAt")
  private DateTime expireAt = null;

  @JsonProperty("isEncryptionEnabled")
  private Boolean isEncryptionEnabled = null;

  @JsonProperty("lastLoginSuccessAt")
  private DateTime lastLoginSuccessAt = null;

  @JsonProperty("lastLoginFailAt")
  private DateTime lastLoginFailAt = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("homeRoomId")
  private Long homeRoomId = null;

  @JsonProperty("userGroups")
  private List<UserGroup> userGroups = null;

  @JsonProperty("userAttributes")
  private UserAttributes userAttributes = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("lastLoginSuccessIp")
  private String lastLoginSuccessIp = null;

  @JsonProperty("lastLoginFailIp")
  private String lastLoginFailIp = null;

  @JsonProperty("gender")
  private String gender = "n";

  @JsonProperty("needsToChangeUserName")
  private Boolean needsToChangeUserName = false;

  @JsonProperty("authMethods")
  private List<UserAuthMethod> authMethods = null;

  @JsonProperty("login")
  private String login = null;

  @JsonProperty("lockStatus")
  private Integer lockStatus = null;

  @JsonProperty("customer")
  private CustomerData customer = null;

  @JsonProperty("needsToChangePassword")
  private Boolean needsToChangePassword = null;

  public UserAccount id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier for the user
   * @return id
  **/
  @Schema(required = true, description = "Unique identifier for the user")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UserAccount userName(String userName) {
    this.userName = userName;
    return this;
  }

   /**
   * &amp;#128640; Since v4.13.0  Username
   * @return userName
  **/
  @Schema(required = true, description = "&#128640; Since v4.13.0  Username")
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public UserAccount firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * User first name
   * @return firstName
  **/
  @Schema(required = true, description = "User first name")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserAccount lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * User last name
   * @return lastName
  **/
  @Schema(required = true, description = "User last name")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserAccount isLocked(Boolean isLocked) {
    this.isLocked = isLocked;
    return this;
  }

   /**
   * User is locked:  * &#x60;false&#x60; - unlocked  * &#x60;true&#x60; - locked    User is locked and can not login anymore.
   * @return isLocked
  **/
  @Schema(required = true, description = "User is locked:  * `false` - unlocked  * `true` - locked    User is locked and can not login anymore.")
  public Boolean isIsLocked() {
    return isLocked;
  }

  public void setIsLocked(Boolean isLocked) {
    this.isLocked = isLocked;
  }

  public UserAccount hasManageableRooms(Boolean hasManageableRooms) {
    this.hasManageableRooms = hasManageableRooms;
    return this;
  }

   /**
   * User has manageable rooms
   * @return hasManageableRooms
  **/
  @Schema(required = true, description = "User has manageable rooms")
  public Boolean isHasManageableRooms() {
    return hasManageableRooms;
  }

  public void setHasManageableRooms(Boolean hasManageableRooms) {
    this.hasManageableRooms = hasManageableRooms;
  }

  public UserAccount userRoles(RoleList userRoles) {
    this.userRoles = userRoles;
    return this;
  }

   /**
   * Get userRoles
   * @return userRoles
  **/
  @Schema(required = true, description = "")
  public RoleList getUserRoles() {
    return userRoles;
  }

  public void setUserRoles(RoleList userRoles) {
    this.userRoles = userRoles;
  }

  public UserAccount language(String language) {
    this.language = language;
    return this;
  }

   /**
   * &amp;#128640; Since v4.20.0  IETF language tag
   * @return language
  **/
  @Schema(required = true, description = "&#128640; Since v4.20.0  IETF language tag")
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public UserAccount authData(UserAuthData authData) {
    this.authData = authData;
    return this;
  }

   /**
   * Get authData
   * @return authData
  **/
  @Schema(required = true, description = "")
  public UserAuthData getAuthData() {
    return authData;
  }

  public void setAuthData(UserAuthData authData) {
    this.authData = authData;
  }

  public UserAccount mustSetEmail(Boolean mustSetEmail) {
    this.mustSetEmail = mustSetEmail;
    return this;
  }

   /**
   * &amp;#128640; Since v4.13.0  If &#x60;true&#x60;, the user must set the &#x60;email&#x60; at the first login.
   * @return mustSetEmail
  **/
  @Schema(description = "&#128640; Since v4.13.0  If `true`, the user must set the `email` at the first login.")
  public Boolean isMustSetEmail() {
    return mustSetEmail;
  }

  public void setMustSetEmail(Boolean mustSetEmail) {
    this.mustSetEmail = mustSetEmail;
  }

  public UserAccount needsToAcceptEULA(Boolean needsToAcceptEULA) {
    this.needsToAcceptEULA = needsToAcceptEULA;
    return this;
  }

   /**
   * User has accepted EULA.  Present, if EULA is system global active.  cf. &#x60;GET system/config/settings/general&#x60; - &#x60;eulaEnabled&#x60;
   * @return needsToAcceptEULA
  **/
  @Schema(description = "User has accepted EULA.  Present, if EULA is system global active.  cf. `GET system/config/settings/general` - `eulaEnabled`")
  public Boolean isNeedsToAcceptEULA() {
    return needsToAcceptEULA;
  }

  public void setNeedsToAcceptEULA(Boolean needsToAcceptEULA) {
    this.needsToAcceptEULA = needsToAcceptEULA;
  }

  public UserAccount expireAt(DateTime expireAt) {
    this.expireAt = expireAt;
    return this;
  }

   /**
   * Expiration date
   * @return expireAt
  **/
  @Schema(description = "Expiration date")
  public DateTime getExpireAt() {
    return expireAt;
  }

  public void setExpireAt(DateTime expireAt) {
    this.expireAt = expireAt;
  }

  public UserAccount isEncryptionEnabled(Boolean isEncryptionEnabled) {
    this.isEncryptionEnabled = isEncryptionEnabled;
    return this;
  }

   /**
   * User has generated private key.  Possible if client-side encryption is active for this customer
   * @return isEncryptionEnabled
  **/
  @Schema(description = "User has generated private key.  Possible if client-side encryption is active for this customer")
  public Boolean isIsEncryptionEnabled() {
    return isEncryptionEnabled;
  }

  public void setIsEncryptionEnabled(Boolean isEncryptionEnabled) {
    this.isEncryptionEnabled = isEncryptionEnabled;
  }

  public UserAccount lastLoginSuccessAt(DateTime lastLoginSuccessAt) {
    this.lastLoginSuccessAt = lastLoginSuccessAt;
    return this;
  }

   /**
   * Last successful logon date
   * @return lastLoginSuccessAt
  **/
  @Schema(description = "Last successful logon date")
  public DateTime getLastLoginSuccessAt() {
    return lastLoginSuccessAt;
  }

  public void setLastLoginSuccessAt(DateTime lastLoginSuccessAt) {
    this.lastLoginSuccessAt = lastLoginSuccessAt;
  }

  public UserAccount lastLoginFailAt(DateTime lastLoginFailAt) {
    this.lastLoginFailAt = lastLoginFailAt;
    return this;
  }

   /**
   * Last failed logon date
   * @return lastLoginFailAt
  **/
  @Schema(description = "Last failed logon date")
  public DateTime getLastLoginFailAt() {
    return lastLoginFailAt;
  }

  public void setLastLoginFailAt(DateTime lastLoginFailAt) {
    this.lastLoginFailAt = lastLoginFailAt;
  }

  public UserAccount email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Email 
   * @return email
  **/
  @Schema(description = "Email ")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserAccount phone(String phone) {
    this.phone = phone;
    return this;
  }

   /**
   * Phone number
   * @return phone
  **/
  @Schema(description = "Phone number")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public UserAccount homeRoomId(Long homeRoomId) {
    this.homeRoomId = homeRoomId;
    return this;
  }

   /**
   * Homeroom ID
   * @return homeRoomId
  **/
  @Schema(description = "Homeroom ID")
  public Long getHomeRoomId() {
    return homeRoomId;
  }

  public void setHomeRoomId(Long homeRoomId) {
    this.homeRoomId = homeRoomId;
  }

  public UserAccount userGroups(List<UserGroup> userGroups) {
    this.userGroups = userGroups;
    return this;
  }

  public UserAccount addUserGroupsItem(UserGroup userGroupsItem) {
    if (this.userGroups == null) {
      this.userGroups = new ArrayList<>();
    }
    this.userGroups.add(userGroupsItem);
    return this;
  }

   /**
   * All groups the user is member of
   * @return userGroups
  **/
  @Schema(description = "All groups the user is member of")
  public List<UserGroup> getUserGroups() {
    return userGroups;
  }

  public void setUserGroups(List<UserGroup> userGroups) {
    this.userGroups = userGroups;
  }

  public UserAccount userAttributes(UserAttributes userAttributes) {
    this.userAttributes = userAttributes;
    return this;
  }

   /**
   * Get userAttributes
   * @return userAttributes
  **/
  @Schema(description = "")
  public UserAttributes getUserAttributes() {
    return userAttributes;
  }

  public void setUserAttributes(UserAttributes userAttributes) {
    this.userAttributes = userAttributes;
  }

  public UserAccount title(String title) {
    this.title = title;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.18.0  Job title
   * @return title
  **/
  @Schema(description = "&#128679; Deprecated since v4.18.0  Job title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public UserAccount lastLoginSuccessIp(String lastLoginSuccessIp) {
    this.lastLoginSuccessIp = lastLoginSuccessIp;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.6.0  Last successful logon IP address
   * @return lastLoginSuccessIp
  **/
  @Schema(description = "&#128679; Deprecated since v4.6.0  Last successful logon IP address")
  public String getLastLoginSuccessIp() {
    return lastLoginSuccessIp;
  }

  public void setLastLoginSuccessIp(String lastLoginSuccessIp) {
    this.lastLoginSuccessIp = lastLoginSuccessIp;
  }

  public UserAccount lastLoginFailIp(String lastLoginFailIp) {
    this.lastLoginFailIp = lastLoginFailIp;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.6.0  Last failed logon IP address
   * @return lastLoginFailIp
  **/
  @Schema(description = "&#128679; Deprecated since v4.6.0  Last failed logon IP address")
  public String getLastLoginFailIp() {
    return lastLoginFailIp;
  }

  public void setLastLoginFailIp(String lastLoginFailIp) {
    this.lastLoginFailIp = lastLoginFailIp;
  }

  public UserAccount gender(String gender) {
    this.gender = gender;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.12.0  Gender
   * @return gender
  **/
  @Schema(description = "&#128679; Deprecated since v4.12.0  Gender")
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public UserAccount needsToChangeUserName(Boolean needsToChangeUserName) {
    this.needsToChangeUserName = needsToChangeUserName;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.13.0  If &#x60;true&#x60;, the user must change the &#x60;userName&#x60; at the first login.
   * @return needsToChangeUserName
  **/
  @Schema(description = "&#128679; Deprecated since v4.13.0  If `true`, the user must change the `userName` at the first login.")
  public Boolean isNeedsToChangeUserName() {
    return needsToChangeUserName;
  }

  public void setNeedsToChangeUserName(Boolean needsToChangeUserName) {
    this.needsToChangeUserName = needsToChangeUserName;
  }

  public UserAccount authMethods(List<UserAuthMethod> authMethods) {
    this.authMethods = authMethods;
    return this;
  }

  public UserAccount addAuthMethodsItem(UserAuthMethod authMethodsItem) {
    if (this.authMethods == null) {
      this.authMethods = new ArrayList<>();
    }
    this.authMethods.add(authMethodsItem);
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.13.0  Authentication methods:  * &#x60;sql&#x60;  * &#x60;active_directory&#x60;  * &#x60;radius&#x60;  * &#x60;openid&#x60;  use &#x60;authData&#x60; instead
   * @return authMethods
  **/
  @Schema(description = "&#128679; Deprecated since v4.13.0  Authentication methods:  * `sql`  * `active_directory`  * `radius`  * `openid`  use `authData` instead")
  public List<UserAuthMethod> getAuthMethods() {
    return authMethods;
  }

  public void setAuthMethods(List<UserAuthMethod> authMethods) {
    this.authMethods = authMethods;
  }

  public UserAccount login(String login) {
    this.login = login;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.13.0  User login name
   * @return login
  **/
  @Schema(description = "&#128679; Deprecated since v4.13.0  User login name")
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public UserAccount lockStatus(Integer lockStatus) {
    this.lockStatus = lockStatus;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.7.0  User lock status:  * &#x60;0&#x60; - locked  * &#x60;1&#x60; - Web access allowed  * &#x60;2&#x60; - Web and mobile access allowed    Please use &#x60;isLocked&#x60; instead.
   * @return lockStatus
  **/
  @Schema(required = true, description = "&#128679; Deprecated since v4.7.0  User lock status:  * `0` - locked  * `1` - Web access allowed  * `2` - Web and mobile access allowed    Please use `isLocked` instead.")
  public Integer getLockStatus() {
    return lockStatus;
  }

  public void setLockStatus(Integer lockStatus) {
    this.lockStatus = lockStatus;
  }

  public UserAccount customer(CustomerData customer) {
    this.customer = customer;
    return this;
  }

   /**
   * Get customer
   * @return customer
  **/
  @Schema(required = true, description = "")
  public CustomerData getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerData customer) {
    this.customer = customer;
  }

  public UserAccount needsToChangePassword(Boolean needsToChangePassword) {
    this.needsToChangePassword = needsToChangePassword;
    return this;
  }

   /**
   * &amp;#128679; Deprecated since v4.13.0  Determines whether user has to change his / her password
   * @return needsToChangePassword
  **/
  @Schema(required = true, description = "&#128679; Deprecated since v4.13.0  Determines whether user has to change his / her password")
  public Boolean isNeedsToChangePassword() {
    return needsToChangePassword;
  }

  public void setNeedsToChangePassword(Boolean needsToChangePassword) {
    this.needsToChangePassword = needsToChangePassword;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAccount userAccount = (UserAccount) o;
    return Objects.equals(this.id, userAccount.id) &&
        Objects.equals(this.userName, userAccount.userName) &&
        Objects.equals(this.firstName, userAccount.firstName) &&
        Objects.equals(this.lastName, userAccount.lastName) &&
        Objects.equals(this.isLocked, userAccount.isLocked) &&
        Objects.equals(this.hasManageableRooms, userAccount.hasManageableRooms) &&
        Objects.equals(this.userRoles, userAccount.userRoles) &&
        Objects.equals(this.language, userAccount.language) &&
        Objects.equals(this.authData, userAccount.authData) &&
        Objects.equals(this.mustSetEmail, userAccount.mustSetEmail) &&
        Objects.equals(this.needsToAcceptEULA, userAccount.needsToAcceptEULA) &&
        Objects.equals(this.expireAt, userAccount.expireAt) &&
        Objects.equals(this.isEncryptionEnabled, userAccount.isEncryptionEnabled) &&
        Objects.equals(this.lastLoginSuccessAt, userAccount.lastLoginSuccessAt) &&
        Objects.equals(this.lastLoginFailAt, userAccount.lastLoginFailAt) &&
        Objects.equals(this.email, userAccount.email) &&
        Objects.equals(this.phone, userAccount.phone) &&
        Objects.equals(this.homeRoomId, userAccount.homeRoomId) &&
        Objects.equals(this.userGroups, userAccount.userGroups) &&
        Objects.equals(this.userAttributes, userAccount.userAttributes) &&
        Objects.equals(this.title, userAccount.title) &&
        Objects.equals(this.lastLoginSuccessIp, userAccount.lastLoginSuccessIp) &&
        Objects.equals(this.lastLoginFailIp, userAccount.lastLoginFailIp) &&
        Objects.equals(this.gender, userAccount.gender) &&
        Objects.equals(this.needsToChangeUserName, userAccount.needsToChangeUserName) &&
        Objects.equals(this.authMethods, userAccount.authMethods) &&
        Objects.equals(this.login, userAccount.login) &&
        Objects.equals(this.lockStatus, userAccount.lockStatus) &&
        Objects.equals(this.customer, userAccount.customer) &&
        Objects.equals(this.needsToChangePassword, userAccount.needsToChangePassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userName, firstName, lastName, isLocked, hasManageableRooms, userRoles, language, authData, mustSetEmail, needsToAcceptEULA, expireAt, isEncryptionEnabled, lastLoginSuccessAt, lastLoginFailAt, email, phone, homeRoomId, userGroups, userAttributes, title, lastLoginSuccessIp, lastLoginFailIp, gender, needsToChangeUserName, authMethods, login, lockStatus, customer, needsToChangePassword);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAccount {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    isLocked: ").append(toIndentedString(isLocked)).append("\n");
    sb.append("    hasManageableRooms: ").append(toIndentedString(hasManageableRooms)).append("\n");
    sb.append("    userRoles: ").append(toIndentedString(userRoles)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    authData: ").append(toIndentedString(authData)).append("\n");
    sb.append("    mustSetEmail: ").append(toIndentedString(mustSetEmail)).append("\n");
    sb.append("    needsToAcceptEULA: ").append(toIndentedString(needsToAcceptEULA)).append("\n");
    sb.append("    expireAt: ").append(toIndentedString(expireAt)).append("\n");
    sb.append("    isEncryptionEnabled: ").append(toIndentedString(isEncryptionEnabled)).append("\n");
    sb.append("    lastLoginSuccessAt: ").append(toIndentedString(lastLoginSuccessAt)).append("\n");
    sb.append("    lastLoginFailAt: ").append(toIndentedString(lastLoginFailAt)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    homeRoomId: ").append(toIndentedString(homeRoomId)).append("\n");
    sb.append("    userGroups: ").append(toIndentedString(userGroups)).append("\n");
    sb.append("    userAttributes: ").append(toIndentedString(userAttributes)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    lastLoginSuccessIp: ").append(toIndentedString(lastLoginSuccessIp)).append("\n");
    sb.append("    lastLoginFailIp: ").append(toIndentedString(lastLoginFailIp)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    needsToChangeUserName: ").append(toIndentedString(needsToChangeUserName)).append("\n");
    sb.append("    authMethods: ").append(toIndentedString(authMethods)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    lockStatus: ").append(toIndentedString(lockStatus)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    needsToChangePassword: ").append(toIndentedString(needsToChangePassword)).append("\n");
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
