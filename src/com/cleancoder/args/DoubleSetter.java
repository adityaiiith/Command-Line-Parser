package com.cleancoder.args;

import static com.cleancoder.args.ArgsException.ErrorCode.*;

import java.util.*;

public class DoubleSetter implements ArgumentSetter {
  private double doubleValue;

  public DoubleSetter() throws ArgsException {
    this.doubleValue = 0;
  }

  public void set(Iterator<String> currentArgument) throws ArgsException {
    String parameter = null;
    try {
      parameter = currentArgument.next();
      doubleValue = Double.parseDouble(parameter);
    } catch (NoSuchElementException e) {
      throw new ArgsException(MISSING_DOUBLE);
    } catch (NumberFormatException e) {
      throw new ArgsException(INVALID_DOUBLE, parameter);
    }
  }

  public static double getValue(ArgumentSetter am) {
    if (am != null && am instanceof DoubleSetter)
      return ((DoubleSetter) am).doubleValue;
    else
      return 0.0;
  }
}
