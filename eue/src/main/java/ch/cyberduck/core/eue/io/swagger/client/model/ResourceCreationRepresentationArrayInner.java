/*
 * ReSTFS
 * ReSTFS Open API 3.0 Spec
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.eue.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import ch.cyberduck.core.eue.io.swagger.client.model.UploadType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * ResourceCreationRepresentationArrayInner
 */


public class ResourceCreationRepresentationArrayInner {
  @JsonProperty("forceOverwrite")
  private Boolean forceOverwrite = null;

  @JsonProperty("ovewrite")
  private Boolean ovewrite = null;

  @JsonProperty("path")
  private String path = null;

  /**
   * Gets or Sets resourceType
   */
  public enum ResourceTypeEnum {
    CONTAINER("CONTAINER"),
    ALIASCONTAINER("ALIASCONTAINER"),
    FILE("FILE");

    private String value;

    ResourceTypeEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static ResourceTypeEnum fromValue(String text) {
      for (ResourceTypeEnum b : ResourceTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("resourceType")
  private ResourceTypeEnum resourceType = null;

  @JsonProperty("sha256")
  private String sha256 = null;

  @JsonProperty("size")
  private Long size = null;

  @JsonProperty("uploadType")
  private UploadType uploadType = null;

  public ResourceCreationRepresentationArrayInner forceOverwrite(Boolean forceOverwrite) {
    this.forceOverwrite = forceOverwrite;
    return this;
  }

   /**
   * Get forceOverwrite
   * @return forceOverwrite
  **/
  @Schema(description = "")
  public Boolean isForceOverwrite() {
    return forceOverwrite;
  }

  public void setForceOverwrite(Boolean forceOverwrite) {
    this.forceOverwrite = forceOverwrite;
  }

  public ResourceCreationRepresentationArrayInner ovewrite(Boolean ovewrite) {
    this.ovewrite = ovewrite;
    return this;
  }

   /**
   * Get ovewrite
   * @return ovewrite
  **/
  @Schema(description = "")
  public Boolean isOvewrite() {
    return ovewrite;
  }

  public void setOvewrite(Boolean ovewrite) {
    this.ovewrite = ovewrite;
  }

  public ResourceCreationRepresentationArrayInner path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @Schema(required = true, description = "")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public ResourceCreationRepresentationArrayInner resourceType(ResourceTypeEnum resourceType) {
    this.resourceType = resourceType;
    return this;
  }

   /**
   * Get resourceType
   * @return resourceType
  **/
  @Schema(required = true, description = "")
  public ResourceTypeEnum getResourceType() {
    return resourceType;
  }

  public void setResourceType(ResourceTypeEnum resourceType) {
    this.resourceType = resourceType;
  }

  public ResourceCreationRepresentationArrayInner sha256(String sha256) {
    this.sha256 = sha256;
    return this;
  }

   /**
   * Get sha256
   * @return sha256
  **/
  @Schema(description = "")
  public String getSha256() {
    return sha256;
  }

  public void setSha256(String sha256) {
    this.sha256 = sha256;
  }

  public ResourceCreationRepresentationArrayInner size(Long size) {
    this.size = size;
    return this;
  }

   /**
   * Get size
   * @return size
  **/
  @Schema(description = "")
  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  public ResourceCreationRepresentationArrayInner uploadType(UploadType uploadType) {
    this.uploadType = uploadType;
    return this;
  }

   /**
   * Get uploadType
   * @return uploadType
  **/
  @Schema(description = "")
  public UploadType getUploadType() {
    return uploadType;
  }

  public void setUploadType(UploadType uploadType) {
    this.uploadType = uploadType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceCreationRepresentationArrayInner resourceCreationRepresentationArrayInner = (ResourceCreationRepresentationArrayInner) o;
    return Objects.equals(this.forceOverwrite, resourceCreationRepresentationArrayInner.forceOverwrite) &&
        Objects.equals(this.ovewrite, resourceCreationRepresentationArrayInner.ovewrite) &&
        Objects.equals(this.path, resourceCreationRepresentationArrayInner.path) &&
        Objects.equals(this.resourceType, resourceCreationRepresentationArrayInner.resourceType) &&
        Objects.equals(this.sha256, resourceCreationRepresentationArrayInner.sha256) &&
        Objects.equals(this.size, resourceCreationRepresentationArrayInner.size) &&
        Objects.equals(this.uploadType, resourceCreationRepresentationArrayInner.uploadType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(forceOverwrite, ovewrite, path, resourceType, sha256, size, uploadType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceCreationRepresentationArrayInner {\n");
    
    sb.append("    forceOverwrite: ").append(toIndentedString(forceOverwrite)).append("\n");
    sb.append("    ovewrite: ").append(toIndentedString(ovewrite)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
    sb.append("    sha256: ").append(toIndentedString(sha256)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    uploadType: ").append(toIndentedString(uploadType)).append("\n");
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
