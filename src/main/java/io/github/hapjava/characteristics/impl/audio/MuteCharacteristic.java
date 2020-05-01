package io.github.hapjava.characteristics.impl.audio;

import io.github.hapjava.characteristics.ExceptionalConsumer;
import io.github.hapjava.characteristics.HomekitCharacteristicChangeCallback;
import io.github.hapjava.characteristics.impl.base.EnumCharacteristic;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

/** A Mute characteristic allows the control of audio input or output accessory respectively. */
public class MuteCharacteristic extends EnumCharacteristic<MuteEnum> {
  public MuteCharacteristic(
      Supplier<CompletableFuture<MuteEnum>> getter,
      ExceptionalConsumer<MuteEnum> setter,
      Consumer<HomekitCharacteristicChangeCallback> subscriber,
      Runnable unsubscriber) {
    super(
        "0000011A-0000-1000-8000-0026BB765291",
        "Mute",
        1,
        Optional.of(getter),
        Optional.of(setter),
        Optional.of(subscriber),
        Optional.of(unsubscriber));
  }
}
