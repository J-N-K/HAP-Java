package io.github.hapjava.services.impl;

import io.github.hapjava.accessories.WindowAccessory;
import io.github.hapjava.accessories.optionalcharacteristic.AccessoryWithHoldPosition;
import io.github.hapjava.accessories.optionalcharacteristic.AccessoryWithName;
import io.github.hapjava.accessories.optionalcharacteristic.AccessoryWithObstructionDetection;
import io.github.hapjava.characteristics.impl.common.NameCharacteristic;
import io.github.hapjava.characteristics.impl.common.ObstructionDetectedCharacteristic;
import io.github.hapjava.characteristics.impl.windowcovering.CurrentPositionCharacteristic;
import io.github.hapjava.characteristics.impl.windowcovering.HoldPositionCharacteristic;
import io.github.hapjava.characteristics.impl.windowcovering.PositionStateCharacteristic;
import io.github.hapjava.characteristics.impl.windowcovering.TargetPositionCharacteristic;

/** This service describes a motorized window. */
public class WindowService extends AbstractServiceImpl {

  public WindowService(
      CurrentPositionCharacteristic currentPositionCharacteristic,
      TargetPositionCharacteristic targetPositionCharacteristic,
      PositionStateCharacteristic positionStateCharacteristic) {
    super("0000008B-0000-1000-8000-0026BB765291");
    addCharacteristic(currentPositionCharacteristic);
    addCharacteristic(targetPositionCharacteristic);
    addCharacteristic(positionStateCharacteristic);
  }

  public WindowService(WindowAccessory accessory) {
    this(
        new CurrentPositionCharacteristic(
            accessory::getCurrentPosition,
            accessory::subscribeCurrentPosition,
            accessory::unsubscribeCurrentPosition),
        new TargetPositionCharacteristic(
            accessory::getTargetPosition,
            accessory::setTargetPosition,
            accessory::subscribeTargetPosition,
            accessory::unsubscribeTargetPosition),
        new PositionStateCharacteristic(
            accessory::getPositionState,
            accessory::subscribePositionState,
            accessory::unsubscribePositionState));
    if (accessory instanceof AccessoryWithName) {
      addOptionalCharacteristic(new NameCharacteristic(((AccessoryWithName) accessory)::getName));
    }
    if (accessory instanceof AccessoryWithHoldPosition) {
      addOptionalCharacteristic(
          new HoldPositionCharacteristic(((AccessoryWithHoldPosition) accessory)::setHoldPosition));
    }

    if (accessory instanceof AccessoryWithObstructionDetection) {
      addOptionalCharacteristic(
          new ObstructionDetectedCharacteristic(
              ((AccessoryWithObstructionDetection) accessory)::getObstructionDetected,
              ((AccessoryWithObstructionDetection) accessory)::subscribeObstructionDetected,
              ((AccessoryWithObstructionDetection) accessory)::unsubscribeObstructionDetected));
    }
  }

  public void addOptionalCharacteristic(NameCharacteristic name) {
    addCharacteristic(name);
  }

  public void addOptionalCharacteristic(HoldPositionCharacteristic holdPositionCharacteristic) {
    addCharacteristic(holdPositionCharacteristic);
  }

  public void addOptionalCharacteristic(
      ObstructionDetectedCharacteristic obstructionDetectedCharacteristic) {
    addCharacteristic(obstructionDetectedCharacteristic);
  }
}
