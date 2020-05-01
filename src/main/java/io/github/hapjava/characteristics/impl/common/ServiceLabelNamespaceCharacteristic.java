package io.github.hapjava.characteristics.impl.common;

import io.github.hapjava.characteristics.impl.base.EnumCharacteristic;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * This characteristic describes the naming schema for an accessory. For example, this
 * characteristic can be used to describe the type of labels used to identify individual services of
 * an accessory.
 */
public class ServiceLabelNamespaceCharacteristic
    extends EnumCharacteristic<ServiceLabelNamespaceEnum> {
  public ServiceLabelNamespaceCharacteristic(
      Supplier<CompletableFuture<ServiceLabelNamespaceEnum>> getter) {
    super(
        "000000CD-0000-1000-8000-0026BB765291",
        "service label namespace",
        1,
        Optional.of(getter),
        Optional.empty(),
        Optional.empty(),
        Optional.empty());
  }
}
