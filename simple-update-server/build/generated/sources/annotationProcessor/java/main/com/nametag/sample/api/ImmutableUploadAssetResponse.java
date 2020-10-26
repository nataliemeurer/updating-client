package com.nametag.sample.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link UploadAssetResponse}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableUploadAssetResponse.builder()}.
 */
@Generated(from = "UploadAssetResponse", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutableUploadAssetResponse implements UploadAssetResponse {

  private ImmutableUploadAssetResponse(ImmutableUploadAssetResponse.Builder builder) {
  }

  /**
   * This instance is equal to all instances of {@code ImmutableUploadAssetResponse} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableUploadAssetResponse
        && equalTo((ImmutableUploadAssetResponse) another);
  }

  @SuppressWarnings("MethodCanBeStatic")
  private boolean equalTo(ImmutableUploadAssetResponse another) {
    return true;
  }

  /**
   * Returns a constant hash code value.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    return 0;
  }

  /**
   * Prints the immutable value {@code UploadAssetResponse}.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "UploadAssetResponse{}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "UploadAssetResponse", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements UploadAssetResponse {
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableUploadAssetResponse fromJson(Json json) {
    ImmutableUploadAssetResponse.Builder builder = ImmutableUploadAssetResponse.builder();
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link UploadAssetResponse} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable UploadAssetResponse instance
   */
  public static ImmutableUploadAssetResponse copyOf(UploadAssetResponse instance) {
    if (instance instanceof ImmutableUploadAssetResponse) {
      return (ImmutableUploadAssetResponse) instance;
    }
    return ImmutableUploadAssetResponse.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableUploadAssetResponse ImmutableUploadAssetResponse}.
   * <pre>
   * ImmutableUploadAssetResponse.builder()
   *    .build();
   * </pre>
   * @return A new ImmutableUploadAssetResponse builder
   */
  public static ImmutableUploadAssetResponse.Builder builder() {
    return new ImmutableUploadAssetResponse.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableUploadAssetResponse ImmutableUploadAssetResponse}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "UploadAssetResponse", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code UploadAssetResponse} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(UploadAssetResponse instance) {
      Objects.requireNonNull(instance, "instance");
      return this;
    }

    /**
     * Builds a new {@link ImmutableUploadAssetResponse ImmutableUploadAssetResponse}.
     * @return An immutable instance of UploadAssetResponse
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableUploadAssetResponse build() {
      return new ImmutableUploadAssetResponse(this);
    }
  }
}
